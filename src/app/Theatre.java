package app;

import app.person.*;

import app.show.Ballet;
import app.show.MusicalShow;
import app.show.Opera;
import app.show.Show;

import java.util.HashMap;

public class Theatre {

    public static boolean DEBUG = false;

    public static void main(String[] args) {
        HashMap<String, Person> persons = makePersonsList();

        //Создать трёх актеров и двух режиссёров. Также создайте одного автора музыки и одного хореографа
        MusicAuthor musicAuthor = RoleMaker.makeMusicAuthor(persons.get("rimskiy-korsakov"));
        Actor actorIzotova = RoleMaker.makeActor(persons.get("izotova"), 165);
        Actor actorNizhinski = RoleMaker.makeActor(persons.get("nizhinski"), 165);
        Actor actorRubinstein = RoleMaker.makeActor(persons.get("rubinstein"), 180);
        Choreographer choreographer = RoleMaker.makeChoreographer(persons.get("kolegov"));

        HashMap<String, Show> shows = makeShowsList(persons);

        //Создать три спектакля: обычный, оперный и балет
        Show show = shows.get("show");

        Ballet ballet = new Ballet(
                shows.get("ballet"),
                musicAuthor,
                "В Красном урочище живут Мороз и Весна-Красна. "
                        + "Их дочь Снегурочка хочет жить среди людей, очарованная песнями пастуха Леля. "
                        + "Родители отпускают её под присмотр Бобыля.",
                choreographer
        );

        Opera opera = new Opera(
                shows.get("opera"),
                musicAuthor,
                "Полина просит Алексея сыграть на рулетке, чтобы спасти её "
                        + "от нищеты и долгов перед Маркизом. Алексей проигрывает её бриллианты, "
                        + "но надеется на выигрыш.",
                23
        );

        //Распределить актёров по спектаклям.
        show.addActor(actorIzotova);
        show.addActor(actorRubinstein);
        ballet.addActor(actorNizhinski);
        ballet.addActor(actorIzotova);
        opera.addActor(actorNizhinski);
        opera.addActor(actorRubinstein);

        //Для каждого спектакля выведите на экран список актёров.
        printShowInfo(show);
        printShowInfo(ballet);
        printShowInfo(opera);

        //Замените актёра в одном из спектаклей на актёра из другого спектакля и ещё раз выведите для него список актёров.
        opera.replaceActor(actorIzotova, actorNizhinski.getSurname());
        opera.printListOfActors();

        //Попробуйте заменить в другом спектакле несуществующего актёра
        ballet.replaceActor(actorRubinstein, "Безруков");
    }


    private static HashMap<String, Person> makePersonsList() {
        HashMap<String, Person> persons = new HashMap<>();
        persons.put("rimskiy-korsakov", new Person("Николай", "Римский-Корсаков", Gender.MALE));
        persons.put("fokin", new Person("Михаил", "Фокин", Gender.MALE));
        persons.put("kolegov", new Person("Михаил", "Колегов", Gender.MALE));
        persons.put("zverev", new Person("Александр", "Зверев", Gender.MALE));
        persons.put("rubinstein", new Person("Ида", "Рубинштейн", Gender.FEMALE));
        persons.put("nizhinski", new Person("Вацлав", "Нижинский", Gender.MALE));
        persons.put("izotova", new Person("Юлия", "Изотова", Gender.FEMALE));
        return persons;
    }

    private static HashMap<String, Show> makeShowsList(HashMap<String, Person> persons) {
        HashMap<String, Show> shows = new HashMap<>();
        Director directorZverev = RoleMaker.makeDirector(persons.get("zverev"), 68);
        Director directorFokin = RoleMaker.makeDirector(persons.get("fokin"), 33);

        shows.put("show", new Show("Цветы для Элджернона", 110, directorFokin));
        shows.put("ballet", new Show("Снегурочка", 180, directorFokin));
        shows.put("opera", new Show("Игрок", 150, directorZverev));
        return shows;
    }


    public static void printShowInfo(Show show) {
        System.out.println("\r\n");
        System.out.println(show);
        //БТ: Распечатать информацию о режиссёре спектакля — должны выводиться его имя и фамилия.
        System.out.print("Режиссер: ");
        show.getDirector().printDirectorInfo();

        //Распечатать список всех актёров, участвующих в спектакле. Для каждого актёра при этом должны выводиться имя и фамилия, а также в скобках его рост.
        System.out.println("Актеры:");
        show.printListOfActors();

        if (show instanceof MusicalShow) {
            System.out.println("Либретто: ");
            ((MusicalShow) show).printLibrettoText();
        }
    }
}
