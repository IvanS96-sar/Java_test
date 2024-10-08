package org.example;

public class ObjectData {
        public String group;
        public String type;
        public long number;
        public long weight;


    public ObjectData(String group, String type, long number, long weight) {
        this.group = group;
        this.type = type;
        this.number = number;
        this.weight = weight;
    }

    public ObjectData() {
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Description{" +
                "group='" + group + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                ", weight=" + weight +
                '}';
    }
}

