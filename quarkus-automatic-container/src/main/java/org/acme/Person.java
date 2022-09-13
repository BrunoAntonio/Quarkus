package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Person extends PanacheEntity {
    public String name;
    public String genre;

    public static Person findByName(String name){
        return find("name", name).firstResult();
    }

}