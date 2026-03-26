import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<Person>(); {
            people.add(new Person("Michał", "Kuczyński", LocalDate.of(1994, 6, 21)));
            people.add(new Person("Benny Sebastian Colón", "Medina", LocalDate.of(2004, 4, 1)));
            people.add(new Person("Theodore Aurelius", "Devereux", LocalDate.of(2005, 4, 10)));
        }
        {
            Person parent = people.get(1);
            Person child = people.get(2);
            System.out.println(parent.adopt(child));
            System.out.println(parent.adopt(parent));

            System.out.println(people);
            System.out.println(parent.getYoungestChild());

            System.out.println(parent.getChildren());
        }
        Family family = new Family();

        for(Person person: people) family.add(person);

        Person benny = (Person) family.get("Benny Sebastian Colón Medina");
        System.out.println(benny);

    }

}
