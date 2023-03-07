package org.example.dto;

public class Scenarios {
    String Scenario;
    String[] tags;

    public Scenarios() { }

    public Scenarios(String scenario, String[] tags) {
        Scenario = scenario;
        this.tags = tags;
    }

    public String getScenario() {
        return Scenario;
    }

    public void setScenario(String scenario) {
        Scenario = scenario;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
