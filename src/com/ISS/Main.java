// Dans notre assembleur il doit traiter le jeu d'instruction réduit
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

    public static int getBinaryInstruction(String instruction) {
        byte[] result;

        String[] parts = instruction.split(" ");

        String operateur = parts[0]; //operateur stock l'opérateur (add, MULT etc.)
        String[] args = parts[1].split(",");// args stock les arguments (registres ou valeurs immédiates)

        int instructionComplete = 0;
        switch (operateur) {
            case "add":
                instructionComplete += (1 << 27);
                break;
            case "sub":
                instructionComplete += (2 << 27);
                break;
            case "mul":
                instructionComplete += (3 << 27);
                break;
            case "div":
                instructionComplete += (4 << 27);
                break;
            case "and":
                instructionComplete += (5 << 27);
                break;
            case "or":
                instructionComplete += (6 << 27);
                break;
            case "xor":
                instructionComplete += (7 << 27);
                break;
            case "shl":
                instructionComplete += (8 << 27);
                break;
            case "shr":
                instructionComplete += (9 << 27);
                break;
            case "jmp":
                instructionComplete += (11 << 27);
                break;
            case "load":
                instructionComplete += (15 << 27);
                break;
            case "store":
                instructionComplete += (16 << 27);
                break;
            default:
                System.out.println("error operator");
                exit(1);
        }
        if (args.length != 3){
            System.out.println("Mauvais nombre d'arguments sur une ligne, nbargs=");//TODO
            exit(1);
        }
        for (String arg: args) {
            System.out.println(arg);

            if (arg.charAt(0)=='R'){

            }
            if (Character.isDigit(arg.charAt(0))){

            }
        }

        return instructionComplete;
    }

}