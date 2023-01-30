package com.ISS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        try (Stream<String> stream = Files.lines(Paths.get("ressource/instructions.asm"))){

            // convert stream into a string
            String contents = stream.collect(Collectors.joining(System.lineSeparator()));

            // print string
            System.out.println(contents);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
