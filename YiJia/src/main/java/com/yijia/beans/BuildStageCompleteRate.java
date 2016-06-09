package com.yijia.beans;

import java.io.Serializable;

/**
 * Created by laz on 2016/6/9.
 */
public class BuildStageCompleteRate implements Serializable {
    int BuildStageCompletePic;
    String BuildStageCompleteContent;

    public BuildStageCompleteRate(int buildStageCompletePic, String buildStageCompleteContent) {
        BuildStageCompletePic = buildStageCompletePic;
        BuildStageCompleteContent = buildStageCompleteContent;
    }

    public int getBuildStageCompletePic() {
        return BuildStageCompletePic;
    }

    public void setBuildStageCompletePic(int buildStageCompletePic) {
        BuildStageCompletePic = buildStageCompletePic;
    }

    public String getBuildStageCompleteContent() {
        return BuildStageCompleteContent;
    }

    public void setBuildStageCompleteContent(String buildStageCompleteContent) {
        BuildStageCompleteContent = buildStageCompleteContent;
    }
}
