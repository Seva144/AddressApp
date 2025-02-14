package test;

import ch.makery.model.Person;
import ch.makery.view.BirthdayStatisticsController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    /*Счетчик месяцев*/
    @org.junit.Test
    public void testMyMethod() {

        List<Person> personData = new ArrayList<>();

        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));


        for (Person p: personData) {
            p.setBirthday(between(LocalDate.of(1995, 1, 1), LocalDate.now()));
        }

        int[] monthCounter = new int[12];
        for (Person p : personData) {
            int month = p.getBirthday().getMonthValue() - 1;
            monthCounter[month]++;
        }

    }

}
