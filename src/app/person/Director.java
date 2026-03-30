package app.person;

public class Director extends Person {
    private final int numberOfShows; //количество поставленных спектаклей

    public Director(Person person, int numberOfShows) {
        super(person.getName(), person.getSurname(), person.getGender());
        this.numberOfShows = numberOfShows;
    }

    public int getNumberOfShows() {
        return numberOfShows;
    }

    //БТ: Распечатать информацию о режиссёре спектакля — должны выводиться его имя и фамилия.
    public void printDirectorInfo() {
        System.out.println(this + ", постановок: " + this.numberOfShows);
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getSurname();
    }
}
