import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

   private final LineSegment [] segments;

   // finds all line segments containing 4 or more points
   public FastCollinearPoints(Point[] points) {
       if (null == points) throw new IllegalArgumentException("Excep");
       
        checkForNullPoints(points);
        Point[] pointsCopySO = Arrays.copyOf(points, points.length);
        Point[] pointsCopyNO = Arrays.copyOf(points, points.length);
        ArrayList<LineSegment> segmentsList = new ArrayList<>();
        Arrays.sort(pointsCopyNO);
        checkForDuplicatedPoints(pointsCopyNO);
        for (int i = 0; i < pointsCopyNO.length; ++i)
        {
            Point origin = pointsCopyNO[i];
            Arrays.sort(pointsCopySO);
            Arrays.sort(pointsCopySO, origin.slopeOrder());
            int ct = 1;
            Point st = null;
            for (int j = 0; j < pointsCopySO.length - 1; j++) {
                if (pointsCopySO[j].slopeTo(origin) == pointsCopySO[j+1].slopeTo(origin)) {
                   ct++;
                   if (ct == 2) {
                       st = pointsCopySO[j];
                       ct++;
                   } else if (ct >= 4 && j + 1 == pointsCopySO.length - 1) {
                       if (st.compareTo(origin) > 0) {
                        segmentsList.add(new LineSegment(origin, pointsCopySO[j + 1]));
                       }
                       ct = 1;
                   }
                } else if (ct >= 4) {
                    if (st.compareTo(origin) > 0) {
                        segmentsList.add(new LineSegment(origin, pointsCopySO[j]));
                    }
                    ct = 1;
                } else {
                    ct = 1;
                }
            }
        }
        segments = segmentsList.toArray(new LineSegment[segmentsList.size()]);

   }

   // the number of line segments
   public int numberOfSegments() {
       return segments.length;
   }

   // the line segments
   public LineSegment[] segments() {
       return Arrays.copyOf(segments, numberOfSegments());
   }
   
    private void checkForDuplicatedPoints(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicate entries");
            }
        }
    }

    private void checkForNullPoints(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("null entry");
            }
        }
    }
}