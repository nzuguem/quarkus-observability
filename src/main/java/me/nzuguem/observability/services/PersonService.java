package me.nzuguem.observability.services;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;
import me.nzuguem.observability.entities.Person;

import java.util.List;

@ApplicationScoped
public class PersonService {

    @WithSpan
    public Person findByName(@SpanAttribute String name) {
        return Person.byName(name);
    }

    @WithSpan
    public List<Person> findAll() {
        return Person.all();
    }
}
