public abstract class Shape {

    protected final Style style;
    public Shape(Style style) {

        this.style = style;

    }

    public abstract String toSvg();

}
