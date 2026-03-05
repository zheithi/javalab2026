import java.util.Arrays;
import java.util.Locale;

public class Polygon {

    private Point[] array;

    public Polygon(Point[] points) {
        this.array = new Point[points.length];

        for(int i = 0; i < points.length; ++i) {
            this.array[i] = new Point(points[i]);
        }
        //System.arraycopy(points, 0, this.points, 0, points.length);
    }
    public Polygon(Polygon p){
        this(p.array);
    }

    @Override
    public String toString() {

        return "Polygon{" + "array=" + Arrays.toString(array) + '}';

    }
    public String toSvg() {

        StringBuilder pointString = new StringBuilder();

        for (Point point : array) {

            pointString.append(point.getX()).append(",").append(point.getY()).append(" ");

        }

        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" style=\"fill:lime;stroke:purple;stroke-width:3\" />", pointString.toString());

    }

}