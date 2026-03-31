package app.person;

import java.util.Objects;

public class Actor extends Person {
    private final int height;

    public Actor(Person person, int height) {
        super(person.getName(), person.getSurname(), person.getGender());
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + this.getHeight() + " см)";
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        //бт: Актёры считаются одинаковыми, если у них совпадают имя, фамилия и рост.
        return getHeight() == actor.getHeight() &&
                Objects.equals(getName(), actor.getName()) &&
                Objects.equals(getSurname(), actor.getSurname());
    }

    @Override
    public int hashCode() {
        //бт: Актёры считаются одинаковыми, если у них совпадают имя, фамилия и рост.
        return Objects.hash(getName(), getSurname(), getHeight());
    }
}
