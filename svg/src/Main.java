public class Main {

    public static void main(String[] args) {

        Point[] points = new Point[5];
        points[0] = new Point(36.1F, 64.4F);
        points[1] = new Point(26.2F, 73.4F);
        points[2] = new Point(18.1F, 81.4F);
        points[3] = new Point(74.1F, 65.4F);
        points[4] = new Point(93.1F, 89.4F);

        Polygon polygon = new Polygon(points);
        points[2].setX(1000);

        System.out.println(polygon.toSvg());

    }

    public static float findMax(Segment[] segments){

        float max = segments[0].length();

        for (Segment s : segments) {

            if (max > s.length()) max = s.length();

        }

        return max;

    }

}