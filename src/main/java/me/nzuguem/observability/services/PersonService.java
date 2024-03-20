package me.nzuguem.observability.services;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;
import me.nzuguem.observability.clients.RandomPersonClient;
import me.nzuguem.observability.entities.Person;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class PersonService {

    private final RandomPersonClient randomPersonClient;

    public PersonService(@RestClient RandomPersonClient randomPersonClient) {
        this.randomPersonClient = randomPersonClient;
    }

    @WithSpan
    public Person findById(@SpanAttribute Long id) {

        var person = Person.byId(id);

        return person.orElseGet(this.randomPersonClient::randomPerson);
    }

    @WithSpan
    public List<Person> findAll() {
        return Person.all();
    }
}
