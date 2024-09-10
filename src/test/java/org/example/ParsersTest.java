package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParsersTest {
    @Test
    void testParseJson() throws IOException {
        Parsers parsers = new Parsers();
        List<ObjectData> objects = parsers.parseJson("D:\\test\\sout.json");

        assertEquals(1, objects.size());

        for (ObjectData object : objects) {
            assertEquals("HHuSBkqZthQFL", object.group);
            assertEquals("BFmrYkjdzMDV", object.type);
            assertEquals(3931317129041882615L, object.number);
            assertEquals(4837609127582047936L, object.weight);
        }
    }

    @Test
    void testParseCsv() throws IOException {
        Parsers parsers = new Parsers();
        List<ObjectData> objects = parsers.parseCsv("D:\\test\\millyy.csv");

        assertEquals(1, objects.size());

        for (ObjectData object : objects) {
            assertEquals("DsFgfTAVRx", object.group);
            assertEquals("pnlQtcxtlKcb", object.type);
            assertEquals(1106161691708532402L, object.number);
            assertEquals(592041073446952945L, object.weight);
        }
    }

    @Test
    void testParseCsvInvalidFile()  {

        Parsers parsers = new Parsers();
        assertThrows(FileNotFoundException.class, () -> parsers.parseCsv("src/test/resources/invalid_test.csv"));
    }
    @Test
    void testParseJsonInvalidFile() {

        Parsers parsers = new Parsers();
        assertThrows(FileNotFoundException.class, () -> parsers.parseJson("invalid/file/path.json"));
    }
}

