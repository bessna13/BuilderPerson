import java.util.OptionalInt;

public class PersonBuilder {
    String name;
    String surname;
    OptionalInt age;
    String adress;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(OptionalInt age) {
        if (age.getAsInt()<0){
            throw new IllegalArgumentException ("Age is incorrect");
        }
        this.age = OptionalInt.of(age.getAsInt());
        return this;
    }

    public PersonBuilder setAddress(String adress) {
        this.adress = adress;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Name or surname is empty");
        }
        if (age.isPresent()) {
            person = new Person(name, surname, age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        return person;
    }

}