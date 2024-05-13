package co.udea.airline.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import co.udea.airline.api.model.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static final String USERS_FILE_PATH = "src/main/resources/persons.json";
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void savePerson(Person person) throws IOException {
        lock.writeLock().lock();
        try {
            File file = Paths.get(USERS_FILE_PATH).toFile();
            List<Person> persons = new ArrayList<>();
            if (file.exists() && file.length() > 0) {
                persons.addAll(Arrays.asList(mapper.readValue(file, Person[].class)));
            }

            if (persons.stream().anyMatch(p -> p.getId().equals(person.getId()))) {
                logger.error("Attempt to save duplicate person with ID: {}", person.getId());
                throw new RuntimeException("A person with ID " + person.getId() + " already exists.");
            }

            persons.add(person);
            mapper.writeValue(file, persons);
            logger.info("Person saved with ID: {}", person.getId());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static boolean emailExists(String email) {
        lock.readLock().lock();
        try {
            File file = new File(USERS_FILE_PATH);
            if (file.exists() && file.length() > 0) {
                List<Person> people = Arrays.asList(mapper.readValue(file, Person[].class));
                return people.stream().anyMatch(p -> email.equals(p.getMail()));
            }
            return false;
        } catch (IOException e) {
            logger.error("Error reading from JSON file", e);
            throw new RuntimeException("Failed to read users from JSON", e);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static Person findPersonByMail(String mail) {
        lock.readLock().lock();
        try {
            File file = new File(USERS_FILE_PATH);
            if (file.exists() && file.length() > 0) {
                List<Person> people = Arrays.asList(mapper.readValue(file, Person[].class));
                return people.stream().filter(p -> mail.equals(p.getMail())).findFirst().orElse(null);
            }
            return null;
        } catch (IOException e) {
            logger.error("Error reading from JSON file", e);
            throw new RuntimeException("Failed to read users from JSON", e);
        } finally {
            lock.readLock().unlock();
        }
    }
}

