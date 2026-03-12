public class Segment {

        private final Point p, q;

    public Segment(Point p, Point q) {

        this.p = p; this.q = q;

    }

    public float length() {

        return(float) Math.hypot((p.getX() - q.getX()), (p.getY() - q.getY()));

    }

    @Override
    public String toString() {

        return "Segment{" + "p=" + p + ", q=" + q + '}';

    }


}
