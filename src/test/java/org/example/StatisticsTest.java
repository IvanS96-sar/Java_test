package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTest {

    @Test
    void testCountDuplicates() {
        List<ObjectData> objects = new ArrayList<>();
        objects.add(new ObjectData("A", "X", 10,55));
        objects.add(new ObjectData("B", "Y", 20,32));
        objects.add(new ObjectData("A", "X", 30,23));
        objects.add(new ObjectData("C", "Z", 40,23));
        objects.add(new ObjectData("A", "X", 50,32));

        Map<String, Integer> duplicates = new HashMap<>();
        for (ObjectData object : objects) {
            String key = object.group + "." + object.type;
            duplicates.put(key, duplicates.getOrDefault(key, 0) + 1);
        }

        assertEquals(3, duplicates.get("A.X"));
    }


    @Test
    void testCalculateGroupWeights() {
        List<ObjectData> objects = new ArrayList<>();
        objects.add(new ObjectData("A", "X", 10,40));
        objects.add(new ObjectData("B", "Y", 20,66));
        objects.add(new ObjectData("A", "Z", 30,50));
        objects.add(new ObjectData("C", "X", 40,32));
        objects.add(new ObjectData("A", "X", 50,10));

        Map<String, Long> groupWeights = new HashMap<>();
        for (ObjectData object : objects) {
            String group = object.getGroup();
            long weight = object.getWeight();

            groupWeights.compute(group, (k, v) -> (v == null) ? weight : v + weight);
        }


        assertEquals(100L, groupWeights.get("A"));
    }

    @Test
    void TestMaxWeight() {
        List<ObjectData> objects = new ArrayList<>();
        objects.add(new ObjectData("A", "X", 10,40));
        objects.add(new ObjectData("B", "Y", 20,66));
        objects.add(new ObjectData("A", "Z", 30,50));
        objects.add(new ObjectData("C", "X", 40,32));
        objects.add(new ObjectData("A", "X", 50,10));
        long maxWeight = objects.stream().mapToLong(ObjectData::getWeight).max().orElse(0L);
        assertEquals(66, maxWeight);
    }
   @Test
    void TestMinWeight() {
        List<ObjectData> objects = new ArrayList<>();

        objects.add(new ObjectData("A", "X", 10,40));
        objects.add(new ObjectData("B", "Y", 20,66));
        objects.add(new ObjectData("A", "Z", 30,50));
        objects.add(new ObjectData("C", "X", 40,32));
        objects.add(new ObjectData("A", "X", 50,10));

       long minWeight = objects.stream().mapToLong(ObjectData::getWeight).min().orElse(0L);
        assertEquals(10, minWeight);
    }
}






