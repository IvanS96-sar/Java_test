package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    public void analyzeObjects(List<ObjectData> objects) {

        Map<String, Integer> duplicates = new HashMap<>();
        for (ObjectData object : objects) {
             String key = object.group + "." + object.type;
            duplicates.put(key, duplicates.getOrDefault(key, 0) + 1);
        }


        Map<String, Long> groupWeights = new HashMap<>();
        for (ObjectData object : objects) {
            groupWeights.put(object.group, groupWeights.getOrDefault(object.group, 0L) + object.weight);
        }


        long maxWeight = objects.stream().mapToLong(ObjectData::getWeight).max().orElse(0L);
        long minWeight = objects.stream().mapToLong(ObjectData::getWeight).min().orElse(0L);



        System.out.println("Дубликаты:");
        duplicates.forEach((key, value) -> {
            if (value > 1) {
                System.out.println("Ключ: " + key + ", Значение: " + value);
            }
        });

        System.out.println("Суммарный вес по группам:");
        groupWeights.forEach((group, weight) -> System.out.println(group + ": " + weight));

        System.out.println("Максимальный вес: " + maxWeight);
        System.out.println("Минимальный вес: " + minWeight);
    }
}
