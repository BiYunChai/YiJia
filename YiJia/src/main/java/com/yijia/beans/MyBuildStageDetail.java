package com.yijia.beans;

import java.io.Serializable;

/**
 * Created by laz on 2016/6/5.
 */
public class MyBuildStageDetail implements Serializable {
    private String build_stagename;
    private String stage_detailinfo;
    private String stagestartdate;
    private int ifcomplete;

    public MyBuildStageDetail(String build_stagename, String stage_detailinfo, String stagestartdate, int ifcomplete) {
        this.build_stagename = build_stagename;
        this.stage_detailinfo = stage_detailinfo;
        this.stagestartdate = stagestartdate;
        this.ifcomplete = ifcomplete;
    }

    public String getBuild_stagename() {
        return build_stagename;
    }

    public void setBuild_stagename(String build_stagename) {
        this.build_stagename = build_stagename;
    }

    public String getStage_detailinfo() {
        return stage_detailinfo;
    }

    public void setStage_detailinfo(String stage_detailinfo) {
        this.stage_detailinfo = stage_detailinfo;
    }

    public String getStagestartdate() {
        return stagestartdate;
    }

    public void setStagestartdate(String stagestartdate) {
        this.stagestartdate = stagestartdate;
    }

    public int getIfcomplete() {
        return ifcomplete;
    }

    public void setIfcomplete(int ifcomplete) {
        this.ifcomplete = ifcomplete;
    }
}
