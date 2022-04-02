package task_2_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long minor = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + minor + '\n');

        List<String> conscripts = persons.stream()
                .filter(sex -> sex.getSex() == Sex.MAN)
                .filter(age -> age.getAge() >= 18 && age.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Список призывников:");
        for (String s : conscripts) {
            System.out.println(s);
        }
        System.out.println();

        List<Person> workable = persons.stream()
                .filter(education -> education.getEducation() == Education.HIGHER)
                .filter(value -> value.getSex() == Sex.MAN && value.getAge() >= 18 && value.getAge() < 65 ||
                        value.getSex() == Sex.WOMAN && value.getAge() >= 18 && value.getAge() < 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("Список работоспособных людей с высшим образованием:");
        for (Person s : workable) {
            System.out.println(s);
        }
    }
}
