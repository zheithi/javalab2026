import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Person implements Comparable<Person>, Serializable {

    private final String firstName, lastName;
    private final LocalDate birthday, death;

    private final Set<Person> children = new HashSet<>();

    public Person(String firstName, String lastName, LocalDate birthday, LocalDate death) throws NegativeLifespanException {

        this.firstName = firstName; this.lastName = lastName;
        this.birthday = birthday; this.death = death;

        if (this.death != null && this.birthday.isAfter(this.death)) {

            throw new NegativeLifespanException(this);

        }

    }


    public Person(String firstName, String lastName, LocalDate birthday) throws NegativeLifespanException {

        this(firstName, lastName, birthday, null);

    }

    public static List<Person> fromCsv(String path) throws IOException {

        Map<String, PersonWithParentStrings> people = new HashMap<>();
        BufferedReader file = new BufferedReader(new FileReader(path));

        String line;
        file.readLine();

        while ((line = file.readLine()) != null) {

            try {

                PersonWithParentStrings newperson = PersonWithParentStrings.fromCsvLine(line);
                people.put(newperson.name(), newperson);

            }
            catch (NegativeLifespanException e) { System.err.println(e.getMessage()); }

        }
        file.close();

        PersonWithParentStrings.connectRelatives(people);
        return PersonWithParentStrings.unpackMap(people);

    }

    public static Person fromCsvLine(String line) throws NegativeLifespanException {

        String[] columns = line.split(",", -1);

        String fullname = columns[0]; String[] name = fullname.split(" ");
        String fname = name[0]; String lname = name[1];
        String birth = columns[1]; String death = columns[2];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthdate = LocalDate.parse(birth, formatter);

        try {

            LocalDate deathdate = LocalDate.parse(death, formatter);
            return new Person(fname, lname, birthdate, deathdate);

        }
        catch (DateTimeParseException ignored) { return new Person(fname, lname, birthdate); }

    }

    @Override
    public String toString() {

        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", death=" + death +
                ", children=" + children +
                '}';

    }


    public boolean adopt(Person child) {

        if (child == this) return false;
        return children.add(child);

    }

    public Person getYoungestChild() {

        if (this.children.isEmpty()) return null;

        Person youngest = children.iterator().next();
        for(Person person: children) {

            if (youngest.compareTo(person) > 0) youngest = person;

        }
        return youngest;

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

    @Override
    public int compareTo(Person other) {

        return this.birthday.compareTo(other.birthday);

    }

    String negativeLifespanExceptionMessage() {

        return String.format("%s %s has a negative lifespan.\n" +
                "Your execution via firing squad has been scheduled for October 25th 2026.", this.firstName, this.lastName);

    }

    public static void toBinaryFile(String path, List<Person> people) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(people);
        oos.close();

    }
    public  static List<Person> fromBinaryFile(String path) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Person> people = (ArrayList<Person>) ois.readObject();

        ois.close();
        return people;

    }

}