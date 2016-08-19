package ru.ivadimn.tests.model;

/**
 * Created by vadim on 19.08.16.
 */
public class TestInfo {

    private int id;
    private String name;
    private String type;
    private String shortName;
    private String description;
    private double time;

    public TestInfo(int id, String name, String type, String shortName, String description, double time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.shortName = shortName;
        this.description = description;
        this.time = time;
    }

    public TestInfo() {
        //no-op
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }


}
