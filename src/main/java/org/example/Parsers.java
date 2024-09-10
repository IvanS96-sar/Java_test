package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Parsers {
    public  List<ObjectData> parseCsv(String filePath) throws IOException {
        List<ObjectData> objects = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                ObjectData object = new ObjectData();
                object.group = line[0];
                object.type = line[1];
                object.number = Long.parseLong(line[2]);
                object.weight = Long.parseLong(line[3]);
                objects.add(object);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
    public  List<ObjectData> parseJson(String filePath) throws IOException {
        Gson gson = new GsonBuilder().create();
        Type objectDataType = new TypeToken<List<ObjectData>>() {
        }.getType();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, objectDataType);
        }
    }
}
