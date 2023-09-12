import java.lang.reflect.Array;
import java.util.*;

public class Convex_Hull {

    static class Point{
        int x;
        int y;

        Point(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static Point select(Point[] arr)
    {
        ArrayList<Integer> a = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].y < min)
            {
                min = arr[i].y;
            }
        }

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].y == min)
            {
                a.add(i);
            }
        }

        int left = Integer.MAX_VALUE;
        int left_i = 0;

        for(int i=0;i<a.size();i++)
        {
            if(arr[a.get(i)].x < left)
            {
                left = arr[a.get(i)].x;
                left_i = a.get(i);
            }
        }

        return arr[left_i];
    }

    public static int direc(Point p0,Point p1,Point p2)
    {
        int x1 = p2.x - p0.x;
        int x2 = p1.x - p0.x;
        int y1 = p2.y - p0.y;
        int y2 = p1.y - p0.y;

        return (x1*y2) - (x2*y1);
    }

    public static Point[] sort_all(Point[] arr, Point p0) {
        Arrays.sort(arr, 1, arr.length, new PointComparator(p0)); // Sort starting from index 1 to skip p0
        return arr;
    }

    static class PointComparator implements Comparator<Point>{
        Point p0;

        PointComparator(Point p0) {
            this.p0 = p0;
        }

        public double angle(Point p1, Point p2) {
            double angle1 = Math.atan2(p1.y - p0.y, p1.x - p0.x);
            double angle2 = Math.atan2(p2.y - p0.y, p2.x - p0.x);

            if (angle1 < angle2) {
                return -1;
            } else if (angle1 > angle2) {
                return 1;
            }
            return 0;
        }

        public int compare(Point p1, Point p2) {
            return Double.compare(angle(p1, p2), 0);
        }
    }
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(1, 2);
        Point p5 = new Point(0, 5);
        Point p6 = new Point(2, 2);
        Point p7 = new Point(-1, 3);

        Point[] arr = {p1,p2,p3,p4,p5,p6,p7};

        Point ans = select(arr);

        System.out.println(ans.x + "  " + ans.y);

        Object[] ans1 = sort_all(arr,ans);

        for(int i=0;i<ans1.length;i++)
        {
            Point p = (Point) ans1[i];
            System.out.println(p.x + " " + p.y);
        }
    }
}
