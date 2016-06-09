package com.yijia.beans;

import java.io.Serializable;

/**
 * Created by laz on 2016/6/9.
 */
public class CompanyCertifyData implements Serializable {
    String companycertifyaddress;

    public CompanyCertifyData(String companycertifyaddress) {
        this.companycertifyaddress = companycertifyaddress;
    }

    public String getCompanycertifyaddress() {
        return companycertifyaddress;
    }

    public void setCompanycertifyaddress(String companycertifyaddress) {
        this.companycertifyaddress = companycertifyaddress;
    }
}
