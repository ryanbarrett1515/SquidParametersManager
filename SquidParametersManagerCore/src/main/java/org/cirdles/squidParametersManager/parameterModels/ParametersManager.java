/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager.parameterModels;

import java.io.Serializable;
import org.cirdles.squidParametersManager.util.DateHelper;

/**
 *
 * @author ryanb
 */
public class ParametersManager implements
        Comparable<ParametersManager>,
        Serializable {

    protected String modelName;
    protected String labName;
    protected String version;
    protected String dateCertified;
    
    @Override
    public int compareTo(ParametersManager o) {
        return modelName.compareTo(o.getModelName());
    }
    
public ParametersManager() {
    modelName = "";
    labName = "";
    version = "";
    dateCertified = DateHelper.getCurrentDate();
    }

    public ParametersManager(String modelName, String labName, String version, String dateCertified) {
        this.modelName = modelName;
        this.labName = labName;
        this.version = version;
        this.dateCertified = dateCertified;
    }

    
    
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDateCertified() {
        return dateCertified;
    }

    public void setDateCertified(String dateCertified) {
        this.dateCertified = dateCertified;
    }

}
