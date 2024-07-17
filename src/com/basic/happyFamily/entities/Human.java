package com.basic.happyFamily.entities;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<String, String> schedule;
    private Family family;
    private ZoneId zoneId;

//    static {
//        System.out.println("Class Human is loaded");
//    }

    {
        schedule = new HashMap<>();
        zoneId = ZoneId.systemDefault();
//        System.out.println("Instance " + this.getClass() + " is loaded");
    }

    public Human() {}

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, String birthDate) {
        long birthDateMillis = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .atStartOfDay(zoneId)
                .toInstant()
                .toEpochMilli();

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDateMillis;
    }

    public Human(String name, String surname, String birthDate, int iq) {
        long birthDateMillis = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .atStartOfDay(zoneId)
                .toInstant()
                .toEpochMilli();

        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.birthDate = birthDateMillis;
    }

    public Human(String name, String surname, long birthDate, int iq, Map<String, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
        long birthDateMillis = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .atStartOfDay(zoneId)
                .toInstant()
                .toEpochMilli();

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDateMillis;
        this.iq = iq;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass()) // instanceof
            return false;

        Human human = (Human) obj;

        return name.equals(human.getName()) &&
                surname.equals(human.getSurname()) &&
                birthDate == human.getBirthDate() &&
                iq == human.getIq() &&
                family.equals(human.getFamily());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (surname == null ? 0 : surname.hashCode());
        result = prime * result + (int)birthDate;
        result = prime * result + iq;
        result = prime * result + family.hashCode();

        return result;
    }

    @Override
    public String toString() {
        String scheduleStr = "[";

        if (!schedule.isEmpty()) {
            for (Map.Entry<String, String> entry : schedule.entrySet()) {
                String day = entry.getKey();
                String task = entry.getValue();

                scheduleStr += "[%s: %s]".formatted(day, task);
            }
        }

        scheduleStr += "]";

        Instant instant = Instant.ofEpochMilli(birthDate);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zoneId);

        return "Human{name='%s', surname='%s', birthDate='%s', iq=%d, schedule=%s}".formatted(
                name,
                surname,
                dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                iq,
                scheduleStr
        );
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object is deleted: " + this);
    }

    public void addTask(String day, String task) {
        String tasks = schedule.get(day);
        String tasksNew = tasks == null ? task : tasks + ", " + task;

        schedule.put(day, tasksNew);
    }

    public void greetPet() {
        Set<Pet> pets = getFamily().getPets();
        String nicknames = "";

        if (pets.isEmpty()) {
            System.out.println("I don't have pets");
        }

        for (Pet pet : pets) {
            nicknames += pet.getNickname() + " ,";
        }

        System.out.printf("Hi, %s\n", nicknames);
    }

    public void describePet() {
        Set<Pet> pets = getFamily().getPets();

        for (Pet pet : pets) {
            String trickyMsg = pet.getTrickLevel() > 50 ? "very tricky" : "almost not tricky";

            System.out.printf("I have a %s, it's %.2f years old, it's %s\n",
                    pet.getSpecies(),
                    pet.getAge(),
                    trickyMsg
            );
        }
    }

    public boolean feedPet(boolean feed, Pet pet) {
        int randomNumber = new Random().nextInt(101);
        boolean needFeed = feed || pet.getTrickLevel() > randomNumber;

        if (needFeed) {
            System.out.printf("Hm... I've fed %s\n", pet.getNickname());
            return true;
        } else {
            System.out.printf("I think, %s is not hungry )) \n", pet.getNickname());
            return false;
        }
    }

    private Period getFullAge() {
        Instant instant = Instant.ofEpochMilli(birthDate);
        LocalDate dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC")).toLocalDate();
        LocalDate now = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")).toLocalDate();

        return Period.between(dateTime, now);
    }

    public int getAge() {
        Period fullAge = getFullAge();

        return fullAge.getYears();
    }

    public String describeAge() {
        Period fullAge = getFullAge();

        return "Age: %d years, %d months, %d days".formatted(
                fullAge.getYears(),
                fullAge.getMonths(),
                fullAge.getDays()
        );
    }
}
