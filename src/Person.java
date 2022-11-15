import java.util.Locale;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);

    }

//    public Person(String name, String surname, int age, String address) {
//        this.name = name;
//        this.surname = surname;
//        this.age = OptionalInt.of(age);
//        this.address = address;
//    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return !address.equals(null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return getSurname();
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }

    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " " + surname);
        if (age.getAsInt() >= 0) {
            sb.append(" Age: " + age.getAsInt());
        }
        if (address != null) {
            sb.append(" Adress: " + address);
        }


        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = name.hashCode() * surname.hashCode();
        if (age.getAsInt() > 0) {
            hash = hash ^ age.getAsInt();
        }
        if (address != null) {
            hash = hash * address.hashCode();
        }

        return hash;

    }

    public PersonBuilder newChildBuilder() {
     PersonBuilder newChildBuilder = new PersonBuilder();
     newChildBuilder.setSurname(surname).setAddress(address).setAge(OptionalInt.of(0));
     return newChildBuilder;
    }
}
