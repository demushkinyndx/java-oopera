package app.person;

public class Choreographer extends Person {
    public Choreographer(Person person) {
        super(person.getName(), person.getSurname(), person.getGender());
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getSurname();
    }
}
