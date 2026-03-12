import java.util.Locale;

public class Point {

        private float x, y;

    public Point(float x, float y) {

        this.x = x;
        this.y = y;

    } // constructor
    public Point() {

        this.x = 0.0f;
        this.y = 0.0f;

    }                 // constructor
    public Point(Point p) {

        this.x = p.getX();
        this.y = p.getY();

    }          // copy constructor

    @Override
    public String toString() {

        return "Point{" + "x=" + x + ", y=" + y + '}';

    }

    public void setX(float x) {

        this.x = x;

    }
    public void setY(float y) {

        this.y = y;

    }

    public float getX() {

        return x;

    }
    public float getY() {

        return y;

    }

    public String toSvg() {

        return String.format(Locale.ENGLISH,"<circle r=\"5\" cx=\"%f\" cy=\"%f\" fill=\"red\" />",x,y);

    }

    public void translate(float dx, float dy) {

        x += dx; y += dy;

    }

    public Point translated(float dx, float dy) {

        Point point = new Point();
        point.x = this.x + dx; point.y = this.y + dy;

        return point;

    }

}
