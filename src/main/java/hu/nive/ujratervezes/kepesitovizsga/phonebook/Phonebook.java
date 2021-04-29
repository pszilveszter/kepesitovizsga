package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException("Missing parameter, unable to continue");
        }

        Path file = Path.of(output);
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Map.Entry<String, String> entry: contacts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to write file");
        }
    }

}
