package org.example;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите путь к файлу (Для закрытия  введите 'exit'): ");
                String filePath = scanner.nextLine();

                if (filePath.equalsIgnoreCase("exit")) {
                    break;
                }

                List<ObjectData> objects;
                if (filePath.endsWith(".json")) {
                        objects = new Parsers().parseJson(filePath);
                        new Statistics().analyzeObjects(objects);
                } else if (filePath.endsWith(".csv")) {
                        objects = new Parsers().parseCsv(filePath);
                        new Statistics().analyzeObjects(objects);
                } else {
                    System.err.println("Неверный формат файла.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }


