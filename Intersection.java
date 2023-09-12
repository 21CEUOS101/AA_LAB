public class Intersection{

    static class Point{
        int x;
        int y;

        Point(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean on_seg(Point p2,Point p1,Point p0)
    {
        if((Math.min(p2.x,p1.x) <= p0.x && p0.x <= Math.max(p2.x, p1.x)) && (Math.min(p2.y,p1.y) <= p0.y && p0.y <= Math.max(p2.y, p1.y)))
        {
            return true;
        }
        return false;
    }

    public static int direc(Point p0,Point p1,Point p2)
    {
        int x1 = p2.x - p0.x;
        int x2 = p1.x - p0.x;
        int y1 = p2.y - p0.y;
        int y2 = p1.y - p0.y;

        return (x1*y2) - (x2*y1);
    }

    public static boolean intersect(Point p1 , Point p2 , Point p3 , Point p4)
    {
        int d1 = direc(p1,p2,p3);
        int d2 = direc(p1,p2,p4);
        int d3 = direc(p3,p4,p1);
        int d4 = direc(p3,p4,p2);

        if(d1 == 0 && on_seg(p1,p2,p3))
        {
            return true;
        }
        else if(d2 == 0 && on_seg(p1,p2,p4))
        {
            return true;
        }
        else if(d3 == 0 && on_seg(p3,p4,p1))
        {
            return true;
        }
        else if(d4 == 0 && on_seg(p3,p4,p2))
        {
            return true;
        }

        if(d1*d2 < 0 && d3*d4 < 0)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(8, 10);
        Point p3 = new Point(-1, 9);
        Point p4 = new Point(15, 6);

        System.out.println(intersect(p1,p2,p3,p4));
    }
}