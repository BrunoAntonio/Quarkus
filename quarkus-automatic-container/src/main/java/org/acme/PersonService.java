package org.acme;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonService {

    public List<Person> findAll(){
        return Person.listAll();
    }

    public Person findById(Long id){
        return Person.findById(id);
    }

    public void persist(Person person){
        Person.persist(person);
    }

}
