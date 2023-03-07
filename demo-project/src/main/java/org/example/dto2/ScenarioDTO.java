package org.example.dto2;

import java.util.List;

public class ScenarioDTO {
    private String scenarioName;
    private List<String> scenarioTags;

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public List<String> getScenarioTags() {
        return scenarioTags;
    }

    public void setScenarioTags(List<String> scenarioTags) {
        this.scenarioTags = scenarioTags;
    }
}
