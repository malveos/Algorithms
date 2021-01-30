import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    
    private final LineSegment [] segments;

   // finds all line segments containing 4 points
   public BruteCollinearPoints(Point[] points) {
       if (null == points) throw new IllegalArgumentException("Excep");
       checkNullEntries(points);
       ArrayList<LineSegment> st = new ArrayList<>();
       Point[] pointsCopy = Arrays.copyOf(points, points.length);
       Arrays.sort(pointsCopy);
       checkDuplicatedEntries(pointsCopy);
       for (int i = 0; i < (pointsCopy.length - 3); ++i)
            for (int j = i + 1; j < (pointsCopy.length - 2); ++j)
                for (int k = j + 1; k < (pointsCopy.length - 1); ++k)
                    for (int m = k + 1; m < (pointsCopy.length); ++m) {
                        if (pointsCopy[i].slopeTo(pointsCopy[j]) == pointsCopy[i].slopeTo(pointsCopy[k]) &&
                            pointsCopy[i].slopeTo(pointsCopy[j]) == pointsCopy[i].slopeTo(pointsCopy[m])) {
                                LineSegment ls = new LineSegment(pointsCopy[i], pointsCopy[m]);
                                if (!st.contains(ls)) {
                                    st.add(ls);
                                }
                            }
                    }
        segments = st.toArray(new LineSegment[st.size()]);
   }

   // the number of line segments
   public int numberOfSegments() {
       return segments.length;
   }

   // the line segments
   public LineSegment[] segments() {
       return Arrays.copyOf(segments, numberOfSegments());
   }
   
    private void checkDuplicatedEntries(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicate entries");
            }
        }
    }

    private void checkNullEntries(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("null entry");
            }
        }
    }
}