public class NegativeLifespanException extends RuntimeException {

    public NegativeLifespanException(Person person) {

        super(person.negativeLifespanExceptionMessage());

    }

}
