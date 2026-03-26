import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {

    private final Map<String, List<Person>> people = new HashMap<>();

    public void add(Person person) {

        String key = person.name();

        if(this.people.containsKey(key)) {

            List<Person> tmp = this.people.get(key);
            tmp.add(person);
            tmp.sort(Person::compareTo);

        }
        else {

            List<Person> tmp = new ArrayList<>();
            tmp.add(person);
            this.people.put(key, tmp);

        }

    }
    public List<Person> get(String key) {

        return people.get(key);

    }

}