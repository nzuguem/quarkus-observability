package me.nzuguem.observability.entities.resources;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.nzuguem.observability.entities.Person;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/persons")
@RunOnVirtualThread
public class PersonResource {


    @Path("{name}")
    @GET
    public Person findByName(@RestPath String name) {

        Log.infof("Get person %s", name);

        return Person.byName(name);
    }

    @GET
    public List<Person> findAll() {

        Log.info("Get all persons");

        return Person.all();
    }

}
