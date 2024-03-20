package com.udea.authorizationauthentication.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.udea.authorizationauthentication.exception.PersonAlreadyExistsException;
import com.udea.authorizationauthentication.model.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class JsonUtils {

    private static final String USERS_FILE_PATH = "src/main/resources/persons.json";

    public static void savePerson(Person person) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = Paths.get(USERS_FILE_PATH).toFile();

        List<Person> persons = new ArrayList<>();
        // Lee los usuarios existentes si el archivo existe
        if (file.exists() && file.length() > 0) {
            Person[] existingPersons = mapper.readValue(file, Person[].class);
            persons.addAll(Arrays.asList(existingPersons));
        }

        // Verifica si ya existe una persona con el mismo ID
        if (persons.stream().anyMatch(p -> p.getId().equals(person.getId()))) {
            throw new PersonAlreadyExistsException("A person with ID " + person.getId() + " already exists.");
        }

        persons.add(person);

        // Escribe todos los usuarios de vuelta al archivo JSON
        mapper.writeValue(file, persons);
    }
}
