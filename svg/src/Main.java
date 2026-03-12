import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Point[] points = new Point[5]; {
            points[0] = new Point(36.1F, 64.4F);
            points[1] = new Point(26.2F, 73.4F);
            points[2] = new Point(18.1F, 81.4F);
            points[3] = new Point(74.1F, 65.4F);
            points[4] = new Point(93.1F, 89.4F);
    }
        Point[] points2 = new Point[3]; {
            points2[0] = new Point(15.6F, 11.7F);
            points2[1] = new Point(20.6F, 19.7F);
            points2[2] = new Point(26.6F, 13.7F);
        }
        Point[] points3 = new Point[3]; {
            points3[0] = new Point(35.6F, 21.7F);
            points3[1] = new Point(40.6F, 29.7F);
            points3[2] = new Point(46.6F, 23.7F);
        }

        Polygon polygon = new Polygon(points);
        points[2].setX(1000);

        Polygon triangle1 = new Polygon(points2);
        Polygon triangle2 = new Polygon(points3);

        SvgScene scene1 = new SvgScene();
        scene1.addPolygon(polygon);
        scene1.addPolygon(triangle1);
        scene1.addPolygon(triangle2);

        scene1.addPolygon(
                Polygon.square(new Segment(
                                new Point(130.0f, 100.0f), new Point(100.0f, 140.0f)
                        ),
                        new Style("red", "green", 3.0)
                )
        );

        System.out.println(scene1.toSvg());
        scene1.save("/home/student/Pulpit/Fortnite.svg");

    }

}