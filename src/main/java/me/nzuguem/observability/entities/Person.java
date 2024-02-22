package me.nzuguem.observability.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Person extends PanacheEntity {

    public String name;

    public LocalDate birth;

    public Status status;

    public static List<Person> all() {
        return listAll();
    }

    public static Person byName(String name) {
        return find("name", name).firstResult();
    }

}
