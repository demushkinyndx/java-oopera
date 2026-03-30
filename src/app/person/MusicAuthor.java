package app.person;

public class MusicAuthor extends Person {
    public MusicAuthor(Person person) {
        super(person.getName(), person.getSurname(), person.getGender());
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getSurname();
    }
}
