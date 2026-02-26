import java.util.Locale;

public class Point {

    public float x, y;

    @Override
    public String toString() {

        return "Point{" + "x=" + x + ", y=" + y + '}';

    }

    public String toSvg() {

        return String.format(Locale.ENGLISH,"<circle r=\"5\" cx=\"%f\" cy=\"%f\" fill=\"red\" />",x,y);

    }

}
