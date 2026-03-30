package app.show;

import app.Theatre;
import app.person.Actor;
import app.person.Director;
import app.person.Gender;

import java.util.ArrayList;

public class Show {
    private final String title;
    private final int duration; //длительность в минутах
    private final Director director; //режиссер

    @Override
    public String toString() {
        return "Спектакль " + this.title + ", продолжительность " + duration + " минут";
    }

    private final ArrayList<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    public void addActor(Actor actor) {
        if (this.listOfActors.contains(actor)) {
            System.out.println(String.format("%s уже участвует в спектакле \"%s\"", actor, this.title));
            return;
        }

        if (actor == null) {
            System.out.println("Невозможно добавить null");
            return;
        }

        this.listOfActors.add(actor);
        if (Theatre.DEBUG) {
            System.out.println(
                    String.format(
                            "%s добавлен%s в спектакль \"%s\"",
                            actor,
                            actor.getGender().equals(Gender.FEMALE) ? "а" : "",
                            this.title
                    )
            );
        }
    }

    //Распечатать список всех актёров, участвующих в спектакле. Для каждого актёра при этом должны выводиться имя и фамилия, а также в скобках его рост.
    public void printListOfActors() {
        for (Actor actor : this.listOfActors) {
            System.out.println(actor + " (" + actor.getHeight() + " см)");
        }
    }

    public String getTitle() {
        return title;
    }

    /**
     * БТ: на вход подаётся объект нового актёра и фамилия того, которого он заменяет
     * Если в спектакле будут Верник отец и Верник сын, то заменится тот, кто был добавлен раньше,
     * Приходящий на замену актер не удаляется из других спектаклей
     */
    public void replaceActor(Actor newActor, String oldActorSurname) {
        if (newActor == null || oldActorSurname == null || oldActorSurname.isEmpty()) {
            System.out.println("Оба актера должны быть указаны (не null)");
            return;
        }

        if (this.listOfActors.contains(newActor)) {
            System.out.println(newActor + " уже участвует в этом спектакле");
            return;
        }

        int indexFrom = this.getIndexBySurname(oldActorSurname);
        if (indexFrom < 0) {
            System.out.println(oldActorSurname + " не участвует в этом спектакле");
            return;
        }

        this.listOfActors.set(indexFrom, newActor);
        if (Theatre.DEBUG) {
            System.out.println(String.format("Успешная замена: %s на %s", oldActorSurname, newActor.getSurname()));
        }
    }

    private int getIndexBySurname(String surname) {
        for (int i = 0; i < this.listOfActors.size(); i++) {
            if (surname.equals(this.listOfActors.get(i).getSurname())) {
                return i;
            }
        }
        return -1;
    }

    public Director getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }
}