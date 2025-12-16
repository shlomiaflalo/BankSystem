package bank;

import java.util.Objects;

//No need to create an instance from this object
public abstract class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return this.age == person.age &&
                Objects.equals(this.firstName, person.firstName) &&
                Objects.equals(this.lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName, this.age);
    }


    @Override
    public String toString() {
        return
                "firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", age: " + age;
    }
}
