package app.show;

import app.person.MusicAuthor;

public class MusicalShow extends Show {
    private final String librettoText;
    private final MusicAuthor musicAuthor;

    public MusicalShow(Show show, MusicAuthor musicAuthor, String librettoText) {
        super(show.getTitle(), show.getDuration(), show.getDirector());
        this.librettoText = librettoText;
        this.musicAuthor = musicAuthor;
    }

    public MusicAuthor getMusicAuthor() {
        return musicAuthor;
    }

    //БТ: Распечатать текст либретто.
    public void printLibrettoText() {
        System.out.println(this.librettoText);
    }
}
