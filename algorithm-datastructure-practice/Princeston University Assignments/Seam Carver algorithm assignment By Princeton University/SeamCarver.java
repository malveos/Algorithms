import edu.princeton.cs.algs4.Picture;
import java.awt.Color;
import java.util.Arrays;

public class SeamCarver {

   private int width;
   private int height;
   private int[][] color;
   private double[][] energy;
   private double[][] distTo;
   private double distToDestination;
   private int[][] edgeTo;
   private int edgeToDestination;
   
   // this is used for deciding if its vertical or horizontal processing; true for horizontal
   private boolean transposed;
   
   // create a seam carver object based on the given picture
   public SeamCarver(Picture picture) {
	   if (null == picture) throw new IllegalArgumentException();
	   width = picture.width();
	   height = picture.height();
	   
	   color = new int[height][width];
	   energy = new double[height][width];
	   for (int i = 0; i < height; i++) {
		   for (int j = 0; j < width; j++) {
			   color[i][j] = picture.get(j, i).getRGB();
		   }
	   }
	    for (int i = 0; i < height; i++) {
		   for (int j = 0; j < width; j++) {
			   energy[i][j] = calEnergy(j, i);
		   }
	   }
   }

   private double calEnergy(int x, int y) {
	  if (x < 0 || y < 0 || x >= width() || y >= height()) throw new IllegalArgumentException();
      if (x == 0 || y == 0 || x == width() - 1 || y == height() - 1) return (double) 1000;
	  
	  Color top = new Color(color[y - 1][x]);
	  Color bottom = new Color(color[y + 1][x]);
	  Color left = new Color(color[y][x - 1]);
	  Color right = new Color(color[y][x + 1]);
	  
	  return Math.sqrt(change(top, bottom) + change(left, right));
   }

   private double change(Color x, Color y) {
	   return Math.pow(x.getRed() - y.getRed(), 2) + Math.pow(x.getGreen() - y.getGreen(), 2) + Math.pow(x.getBlue() - y.getBlue(), 2);
   }

   // current picture
   public Picture picture() {
	   Picture temp = new Picture(width(), height());
	   for (int i = 0; i < height(); i++) {
		   for (int j = 0; j < width(); j++) {
			   temp.set(j, i, new Color(color[i][j]));
		   }
	   }
	   return new Picture(temp);
   }

   // width of current picture
   public int width() {
	   return width;
   }

   // height of current picture
   public int height() {
	   return height;
   }

   // energy of pixel at column x and row y
   public double energy(int x, int y) {
	   if (x < 0 || y < 0 || x >= width() || y >= height()) throw new IllegalArgumentException();
	   return energy[y][x];
   }

   // sequence of indices for horizontal seam
   public int[] findHorizontalSeam() {
	   transposed = true;
	   distToDestination = Double.POSITIVE_INFINITY;
	   edgeToDestination = Integer.MAX_VALUE;
	   distTo = new double[height][width];
	   edgeTo = new int[height][width];
	   for (double[] d: distTo) Arrays.fill(d, Double.POSITIVE_INFINITY);
	   for (int[] e: edgeTo) Arrays.fill(e, Integer.MAX_VALUE);
	   
	   for (int i = 0; i < height(); i++) {
		   distTo[i][0] = (double) 1000;
		   edgeTo[i][0] = -1;
	   }

       // leftdown to rightUppword
       for (int depth = height() - 1; depth > 0; depth--) {
		   for (int sideways = 0; sideways < width() && sideways + depth < height(); sideways++) {
			   visitEdge(depth + sideways, sideways);
		   }
	   }
	   
	   // topleft to right downside
	   for (int top = 0; top < width(); top++) {
		   for (int depth = 0; depth < height() && depth + top < width(); depth++) {
			   visitEdge(depth, depth + top);
		   }
	   }
	   
	   int[] seam = new int[width()];
	   seam[width() - 1] = edgeToDestination; // last set to max
	   for (int j = width() - 1; j > 0; j--) {
		   seam[j-1] = edgeTo[seam[j]][j];
	   }
	   distTo = null;
	   edgeTo = null;
	   return seam;
   }

   // sequence of indices for vertical seam
   public int[] findVerticalSeam() {
	   transposed = false;
	   distToDestination = Double.POSITIVE_INFINITY;
	   edgeToDestination = Integer.MAX_VALUE;
	   distTo = new double[height][width];
	   edgeTo = new int[height][width];
	   for (double[] d: distTo) Arrays.fill(d, Double.POSITIVE_INFINITY);
	   for (int[] e: edgeTo) Arrays.fill(e, Integer.MAX_VALUE);
	   
	   Arrays.fill(distTo[0], (double) 1000);
	   Arrays.fill(edgeTo[0], -1);

        // right top to left downside
	   for (int top = width() - 1; top >= 0; top--) {
		   for (int depth = 0; depth < height() && depth + top < width(); depth++) {
			   visitEdge(depth, depth + top);
		   }
	   }

       // left top to right down
       for (int depth = 1; depth < height(); depth++) {
		   for (int sideways = 0; sideways < width() && sideways + depth < height(); sideways++) {
			   visitEdge(depth + sideways, sideways);
		   }
	   }
	   	   
	   int[] seam = new int[height()];
	   seam[height() - 1] = edgeToDestination; // last set to max
	   for (int i = height() - 1; i > 0; i--) {
            seam[i - 1] = edgeTo[i][seam[i]];
       }
	   distTo = null;
	   edgeTo = null;
	   return seam;
   }

   private void visitEdge(int i, int j){
	   if (transposed) {
            if (j == width() - 1) {
                relax(i, j);
            } else if (i == height() - 1) {
                relax(i, j, i, j + 1);
                relax(i, j, i - 1, j + 1);
            } else if (i == 0) {
                relax(i, j, i, j + 1);
                relax(i, j, i + 1, j + 1);
            } else {
                relax(i, j, i - 1, j + 1);
                relax(i, j, i, j + 1);
                relax(i, j, i + 1, j + 1);
            }
        }
        
        else {
            if (i == height() - 1) {
                relax(i, j);
            } else if (j == width() - 1) {
                relax(i, j, i + 1, j - 1);
                relax(i, j, i + 1, j);
            } else if (j == 0) {
                relax(i, j, i + 1, j);
                relax(i, j, i + 1, j + 1);
            } else {
                relax(i, j, i + 1, j - 1);
                relax(i, j, i + 1, j);
                relax(i, j, i + 1, j + 1);
            }
        }
   }

   private void relax(int r, int c) {
	   if (valid(r, c)) {
		   if (distToDestination > distTo[r][c]) {
			   distToDestination = distTo[r][c];
			   if (transposed)
				   edgeToDestination = r;
			   else
				   edgeToDestination = c;
		   }
	   }
   }

   private void relax(int r1, int c1, int r2, int c2) {
	   if (valid(r1,c1) && valid(r2,c2)) {
		   if (distTo[r2][c2] > distTo[r1][c1] + energy[r2][c2]) {
			   distTo[r2][c2] = distTo[r1][c1] + energy[r2][c2];
			   if (transposed)
				   edgeTo[r2][c2] = r1;
			   else
				   edgeTo[r2][c2] = c1;
		   }
	   }
   }

   private boolean valid(int r, int c) {
	   return (r < height() && c < width() && r >= 0 && c >= 0);
   }

   // remove horizontal seam from current picture
   public void removeHorizontalSeam(int[] seam) {
	   if (height() <= 1 || seam == null || seam.length != width())
		   throw new IllegalArgumentException();
	   int yNext = seam[0];
	   for (int y : seam) {
		   if (y > height() - 1 || y < 0 || Math.abs(yNext - y) > 1)
			   throw new IllegalArgumentException();
		   yNext = y;
	   }

       int[][] newColor = new int[height() - 1][width()];
	   double[][] newEnergy = new double[height() - 1][width()];
	   for (int c = 0; c < width(); c++) {
		   int s = seam[c];
		   for (int r = 0; r < s; r++) {
			   newColor[r][c] = color[r][c];
			   newEnergy[r][c] = energy[r][c];
		   }
		   for (int r = s + 1; r < height(); r++) {
			   newColor[r - 1][c] = color[r][c];
			   newEnergy[r - 1][c] = energy[r][c];
		   }
	   }
	   color = newColor; energy = newEnergy; height--;

	   // recalculate energy
	   for (int c = 0; c < width(); c++) {
		   int s = seam[c];
		   if (s == 0) {
			   energy[s][c] = calEnergy(c, s);
		   } else if (s == height()) {
			   energy[s - 1][c] = calEnergy(c, s - 1);
		   } else {
			  energy[s][c] = calEnergy(c, s);
			   energy[s - 1][c] = calEnergy(c, s - 1);
		   }
	   }
   }

   // remove vertical seam from current picture
   public void removeVerticalSeam(int[] seam) {
	   if (width() <= 1 || seam == null || seam.length != height())
		   throw new IllegalArgumentException();
	   int yNext = seam[0];
	   for (int y : seam) {
		   if (y > width() - 1 || y < 0 || Math.abs(yNext - y) > 1)
			   throw new IllegalArgumentException();
		   yNext = y;
	   }

       int[][] newColor = new int[height()][width() - 1];
	   double[][] newEnergy = new double[height()][width() - 1];
	   for (int r = 0; r < height(); r++) {
		   int s = seam[r];
		   for (int c = 0; c < s; c++) {
			   newColor[r][c] = color[r][c];
			   newEnergy[r][c] = energy[r][c];
		   }
		   for (int c = s + 1; c < width(); c++) {
			   newColor[r][c - 1] = color[r][c];
			   newEnergy[r][c - 1] = energy[r][c];
		   }
	   }
	   color = newColor; energy = newEnergy; width--;

	   // recalculate energy
	   for (int r = 0; r < height(); r++) {
		   int s = seam[r];
		   if (s == 0) {
			   energy[r][s] = calEnergy(s, r);
		   } else if (s == width()){
			   energy[r][s - 1] = calEnergy(s - 1, r);
		   } else {
			   energy[r][s] = calEnergy(s, r);
			   energy[r][s - 1] = calEnergy(s - 1, r);
		   }
	   }
   }

   //  unit testing (optional)
   public static void main(String[] args) {
	   
   }

}