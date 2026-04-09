import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable<Person> {

    private final String firstName, lastName;
    private final LocalDate birthday, death;

    public Person(String firstName, String lastName, LocalDate birthday, LocalDate death) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.death = death;

        if(this.birthday.isAfter(this.death)) {

            throw new NegativeLifespanException(this);

        }

    }
    public Person(String firstName, String lastName, LocalDate birthday) {

        this(firstName, lastName, birthday, null);

    }

    private final Set<Person> children = new HashSet<>();

    public boolean adopt(Person child) {

        if(child == this) return false;
        return children.add(child);

    }
    public Person getYoungestChild() {

        if(this.children.isEmpty()) return null;

        Iterator<Person> iterate = this.children.iterator();
        Person curr = iterate.next(), tmp = curr;

        while(true) {

            if(tmp.compareTo(curr) > 0) {

                tmp = curr;

            }
            try { curr = iterate.next(); }
            catch(NoSuchElementException e) { break; }

        }
        return tmp;

    }

    public List<Person> getChildren() {

        List<Person> result = new ArrayList<>();
        result.addAll(children);
        result.sort(Person::compareTo);

        return result;

    }
    public String name() {

        return String.format("%s %s",firstName, lastName);

    }

    public static Person fromCsvLine(String line) {

        String[] col = line.split(",", -1);
        String fullName = col[0];
        String[] name = fullName.split(" ", -1);
        String firstName = name[0]; String lastName = name[1];

        String birthday = col[1]; String death = col[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthDate = LocalDate.parse(birthday, formatter);
        // LocalDate deathDate = LocalDate.parse(death, formatter);
        LocalDate deathDate = null;
        if(!death.isEmpty()) deathDate = LocalDate.parse(death, formatter);

        return new Person(firstName, lastName, birthDate, deathDate);

    }

    public static List<Person> fromCsv(String path) throws IOException {

        ArrayList<Person> tmp = new ArrayList<>();
        BufferedReader source = new BufferedReader(new FileReader(path));

        String line; source.readLine(); // wypierdolenie naglowka
        while((line = source.readLine()) != null) {

            tmp.add(fromCsvLine(line));

        }

        source.close();
        return tmp;

    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", death=" + death +
                // ", children=" + children +
                "}\n";
    }

    @Override
    public int compareTo(Person other) {

        return 0;

    }

    String negativeLifespanExceptionMessage() {

        return String.format("%s %s has a negative lifespan.\n" +
                "Your execution via firing squad has been scheduled for October 25th 2026.", this.firstName, this.lastName);

    }

}