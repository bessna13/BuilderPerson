import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Anna")
                .setSurname("Volf")
                .setAge(OptionalInt.of(31))
                .setAddress("Sidney")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Anton")
                .build();
        System.out.println("Mom " + mom + " has son " + son);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(OptionalInt.of(-100)).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}