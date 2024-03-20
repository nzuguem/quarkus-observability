package me.nzuguem.observability.resources;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.nzuguem.observability.entities.Person;
import me.nzuguem.observability.services.PersonService;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/persons")
@RunOnVirtualThread
public class PersonResource {

    private final PersonService personService;;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @Path("{id}")
    @GET
    public Person findById(@RestPath Long id) {

        Log.infof("Get person %d", id);

        return this.personService.findById(id);
    }

    @GET
    public List<Person> findAll() {

        Log.info("Get all persons");

        return this.personService.findAll();
    }

}
