import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable<Person> {

    private final String firstName, lastName;
    private final LocalDate birthday;

    public Person(String firstName, String lastName, LocalDate birthday) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;

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

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", children=" + children +
                '}';
    }

    @Override
    public int compareTo(Person other) {

        return 0;

    }
}
