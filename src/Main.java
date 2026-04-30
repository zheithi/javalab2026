public class Main {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        list.add("ala");
        list.add("ma");
        list.add("kota");

        list.addFirst("Mała");

        System.out.println(list.get(1));
        System.out.println(list.size());

        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
    }
}
