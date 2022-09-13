package org.acme;

import org.jboss.logging.annotations.Param;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
@ApplicationScoped
@Path("/hello")
public class PersonResource {

    @Inject
    PersonService service;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/all")
    public List<Person> getAll(){
        return service.findAll();
    }

    @GET
    @Path("{id}")
    public Person getById(Long id){
        return service.findById(id);
    }

    @POST
    @Transactional
    public void persist(Person person){
        service.persist(person);
    }

}