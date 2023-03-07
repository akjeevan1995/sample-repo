package org.example.dto2;

import java.util.List;

public class  FeatureDTO {
    private String featureName;
    private List<String> featureTags;
    private List<ScenarioDTO> scenarioDTOList;
    private String featureFilePath;

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public List<String> getFeatureTags() {
        return featureTags;
    }

    public void setFeatureTags(List<String> featureTags) {
        this.featureTags = featureTags;
    }

    public List<ScenarioDTO> getScenarioDTOList() {
        return scenarioDTOList;
    }

    public void setScenarioDTOList(List<ScenarioDTO> scenarioDTOList) {
        this.scenarioDTOList = scenarioDTOList;
    }

    public String getFeatureFilePath() {
        return featureFilePath;
    }

    public void setFeatureFilePath(String featureFilePath) {
        this.featureFilePath = featureFilePath;
    }

    public void setOtherFeatureTags(String join) {
    }

    public void setTeamComponentCategory(String join) {
    }

    public void setScenarioName(String join) {
    }

    public void setOtherTags(String join) {
    }
}
