import java.util.TreeSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class PointSET {
    private final Set<Point2D> pointSet;
    
    public PointSET() {                              // construct an empty set of points 
        pointSet = new TreeSet<>();
    }

    public boolean isEmpty() {                  // is the set empty? 
        return pointSet.isEmpty();
    }

    public int size() {                         // number of points in the set 
        return pointSet.size();
    }

    public void insert(Point2D p) {              // add the point to the set (if it is not already in the set)
        if (null == p) throw new IllegalArgumentException();
        pointSet.add(p);
    }

    public boolean contains(Point2D p) {           // does the set contain point p? 
        if (null == p) throw new IllegalArgumentException();
        return pointSet.contains(p);
    }

    public void draw() {                         // draw all points to standard draw
        
    }

    public Iterable<Point2D> range(RectHV rect) {             // all points that are inside the rectangle (or on the boundary)
        if (null == rect) throw new IllegalArgumentException();
        List<Point2D> list = new LinkedList<>();
        for (Point2D point : pointSet) {
            if (rect.contains(point)) {
                list.add(point);
            }            
        }
        return list;
    }

    public  Point2D nearest(Point2D p) {            // a nearest neighbor in the set to point p; null if the set is empty 
        if (null == p) throw new IllegalArgumentException();
        if (isEmpty()) return null;
        double nearest = 1.0;
        Point2D np = null;
        for (Point2D point : pointSet) {
            double dist = p.distanceSquaredTo(point);
            if (dist <= nearest) {
                nearest = dist;
                np = point;
            }            
        }
        return np;
    }

    public static void main(String[] args)  {                // unit testing of the methods (optional) 
       PointSET p = new PointSET();
       Point2D pt = new Point2D(0.1, 0.2);
       p.insert(pt);
    }
}