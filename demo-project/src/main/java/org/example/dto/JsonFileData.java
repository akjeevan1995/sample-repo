package org.example.dto;

public class JsonFileData {
    String Feature;
    String[] FeatureTags;
    Scenarios scenarios;
    String featureFilePath;

    public String getFeature() {
        return Feature;
    }

    public void setFeature(String feature) {
        Feature = feature;
    }

    public String[] getFeatureTags() {
        return FeatureTags;
    }

    public void setFeatureTags(String[] featureTags) {
        FeatureTags = featureTags;
    }

    public Scenarios getScenarios() {
        return scenarios;
    }

    public void setScenarios(Scenarios scenarios) {
        this.scenarios = scenarios;
    }

    public String getFeatureFilePath() {
        return featureFilePath;
    }

    public void setFeatureFilePath(String featureFilePath) {
        this.featureFilePath = featureFilePath;
    }
}
