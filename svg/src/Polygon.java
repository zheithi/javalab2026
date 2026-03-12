import java.util.Arrays;
import java.util.Locale;

public class Polygon {

        private final Point[] points;
        private final Style style;


    public Polygon(Point[] points) {

        this(points,new Style("transparent","black", 1.0));

    }
    public Polygon(Point[] points, Style style) {

        this.points=new Point[points.length];
        this.style=style;
        for(int i=0; i< points.length; ++i) {
            this.points[i] = new Point(points[i]);
        }

    }
    public Polygon(Polygon p){

        this(p.points);

    }

    @Override
    public String toString() {

        return "Polygon{" + "array=" + Arrays.toString(points) + '}';

    }
    public String toSvg(){

        StringBuilder pointString = new StringBuilder();

        for (Point point: points){

            pointString.append(point.getX()).append(",").append(point.getY()).append(" ");

        }

        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" style="+style.toSvg()+"/>", pointString);

    }

}