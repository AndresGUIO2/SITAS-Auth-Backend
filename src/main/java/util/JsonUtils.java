package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.udea.authorizationauthentication.exception.PersonAlreadyExistsException;
import com.udea.authorizationauthentication.model.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for JSON operations related to {@code Person} objects.
 * Provides functionality to serialize and deserialize {@code Person} objects to and from JSON.
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
public class JsonUtils {

    private static final String USERS_FILE_PATH = "src/main/resources/persons.json";

    /**
     * Saves a {@code Person} object to a JSON file.
     * <p>
     * If the JSON file already exists, this method will append the new {@code Person}
     * if there is no existing person with the same ID. If a person with the same ID already exists,
     * a {@code PersonAlreadyExistsException} will be thrown.
     * </p>
     *
     * @param person the {@code Person} object to be saved to the JSON file
     * @throws IOException if an I/O error occurs while writing to the file
     * @throws PersonAlreadyExistsException if a person with the same ID already exists in the JSON file
     */
    public static void savePerson(Person person) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = Paths.get(USERS_FILE_PATH).toFile();

        List<Person> persons = new ArrayList<>();
        // Read existing users if the file exists
        if (file.exists() && file.length() > 0) {
            Person[] existingPersons = mapper.readValue(file, Person[].class);
            persons.addAll(Arrays.asList(existingPersons));
        }

        // Check if a person with the same ID already exists
        if (persons.stream().anyMatch(p -> p.getId().equals(person.getId()))) {
            throw new PersonAlreadyExistsException("A person with ID " + person.getId() + " already exists.");
        }

        persons.add(person);

        // Write all the persons back to the JSON file
        mapper.writeValue(file, persons);
    }
}
