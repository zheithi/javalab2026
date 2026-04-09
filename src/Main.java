import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = null;
        String path = "src/family.csv";
        try {

            people = Person.fromCsv(path);
            System.out.println(people);

        }
        catch (IOException e) {

            System.err.println("IOException: File " + path + " not found. Your soul is forfeit.\n" +
                    "We will come for you shortly. Please stay where you are.");

        }

    }

}