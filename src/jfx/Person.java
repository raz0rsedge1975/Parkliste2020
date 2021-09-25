package jfx;

public class Person {

    private String name;

    private String vorname;

    private final int id;

    public Person(String name, String vorname, int id) {
        this.name = name;
        this.vorname = vorname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    /*
    public void setName(String name) {
        this.name = name;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    */

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s",id, name, vorname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
