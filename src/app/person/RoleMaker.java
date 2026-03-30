package app.person;

public class RoleMaker {

    public static Director makeDirector(Person person, int numberOfShows) {
        return new Director(person, numberOfShows);
    }

    public static Actor makeActor(Person person, int height) {
        return new Actor(person, height);
    }

    public static MusicAuthor makeMusicAuthor(Person person) {
        return new MusicAuthor(person);
    }

    public static Choreographer makeChoreographer(Person person) {
        return new Choreographer(person);
    }
}
