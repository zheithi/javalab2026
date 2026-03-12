import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class SvgScene {

        private final Polygon[] polygons = new Polygon[3];
        private int index = 0;

    public void addPolygon(Polygon arg) {

        polygons[index] = arg;
        index++;
        if(index == 3) index = 0;

    }

    public String toSvg() {

        StringBuilder polygonsString  = new StringBuilder();
        for(var polygon: polygons) {

            polygonsString.append(polygon.toSvg()).append("\n");

        }
        return String.format(Locale.ENGLISH, "<svg height=\"260\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">%s</svg>", polygonsString);

    }

    public void save(String filePath) throws IOException {

        FileWriter writer = new FileWriter(filePath);
        writer.write(toSvg());
        writer.close();

    }

}
