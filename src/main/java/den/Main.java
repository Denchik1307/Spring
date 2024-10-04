package den;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alex", "Pupkin", 30);
        System.out.println(person);

        Gson gson = new Gson();

        JsonFileRW.toFileJson(person);

        Person newPerson = JsonFileRW.fromFileJson();
        System.out.println(newPerson);
    }
}