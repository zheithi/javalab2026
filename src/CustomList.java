import java.util.AbstractList;
import java.util.NoSuchElementException;

public class CustomList<T> extends AbstractList<T> {
    private Node<T> head = null, tail = null;

    public void addLast(T value) {
        Node<T> current = new Node<>(value, null);

        if (head == null) head = current;
        else {
            tail.next = current;
        }
        tail = current;
    }

    public T getLast() {
        try { return tail.value; }  catch (NullPointerException e) {
            throw new NoSuchElementException(e);
        }
    }

    public void addFirst(T value) {
        Node<T> current = new Node<>(value, null);
        head = current;

        if (tail == null) tail = current;
    }

    public T getFirst() {
        try { return head.value; }  catch (NullPointerException e) {
            throw new NoSuchElementException(e);
        }
    }

    public T removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        Node<T> current = head;

        if (head == tail) tail = null;
        head = head.next;

        return current.value;
    }

    public T removeLast() {
        if (head == null)
            throw new NoSuchElementException();
        Node<T> current = head;

        if (head == tail) {
            head = null; tail = null;
            return current.value;
        }
        while (current.next != tail) current = current.next;

        current.next = null;
        T result = tail.value;
        tail = current;

        return result;
    }

    @Override
    public T get(int i) {
        if (i == 0) {
            if (head == null) return null;
            return head.value;
        }
        Node<T> current = head;

        for (int j = 0; j < i; j++) {
            if (current.next == null) return null;
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        if (head == null) return 0;

        Node<T> current = head;
        int i = 1;

        while (current.next != null) {
            current = current.next;
            i++;
        }
        return i;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }
}
