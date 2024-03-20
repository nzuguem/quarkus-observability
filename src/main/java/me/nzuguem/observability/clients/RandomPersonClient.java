package me.nzuguem.observability.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.nzuguem.observability.entities.Person;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("persons")
@RegisterRestClient(configKey = "persons-random-api")
public interface RandomPersonClient {

    @GET
    @Path("random")
    Person randomPerson();

}
