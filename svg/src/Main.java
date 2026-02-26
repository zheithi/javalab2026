public class Main {

    public static void main(String[] args) {

        Point point = new Point();
        point.x = 3.5F; point.y = 7.1F;

        System.out.println(point.toSvg());

        point.translate(2, 4);
        System.out.println(point.toSvg());

        Point point2 = point.translated(3.5F, 6.1F);
        System.out.println(point2.toSvg());

        Segment segment = new Segment();
        segment.p = point; segment.q = point2;

        System.out.println(segment.length());


        Segment[] segments = new Segment[5];

    }

    public static float findMax(Segment[] segments){

        float max = segments[0].length();

        for (Segment s : segments) {

            if (max > s.length()) max = s.length();

        }

        return max;

    }

}