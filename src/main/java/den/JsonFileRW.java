package den;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileRW {

    private static final String FILENAME = "person.json";

    static void toFileJson(Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(FILENAME)))) {
            oos.writeObject(person);
            System.out.println("Объект сериализован.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Person fromFileJson() {
        Person deserializedPerson = new Person();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get(FILENAME)))) {
            deserializedPerson = (Person) objectInputStream.readObject();
            System.out.println("Объект десериализован.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
            return deserializedPerson;
    }
}
