package app.show;

import app.person.Choreographer;
import app.person.MusicAuthor;

public class Ballet extends MusicalShow {
    private final Choreographer choreographer;

    public Ballet(Show show, MusicAuthor musicAuthor, String librettoText, Choreographer choreographer) {
        super(show, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    @Override
    public String toString() {
        return "Балет " + super.getTitle() +
                ", композитор " + super.getMusicAuthor() +
                ", продолжительность " + super.getDuration() +
                ", хореограф " + this.choreographer;
    }
}
