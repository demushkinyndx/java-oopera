package app.show;

import app.person.MusicAuthor;

public class Opera extends MusicalShow {
    private final int choirSize;

    public Opera(Show show, MusicAuthor musicAuthor, String librettoText, int choirSize) {
        super(show, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    @Override
    public String toString() {
        return "Опера " + super.getTitle() +
                ", композитор " + super.getMusicAuthor() +
                ", продолжительность " + super.getDuration() +
                " минут, человек в хоре: " + this.choirSize;
    }
}
