/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager.parameterModels;

import java.io.Serializable;
import org.cirdles.squidParametersManager.ValueModel;
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
    protected String comments;
    protected String references;
    protected ValueModel[] values;

    public ParametersManager() {
        modelName = "";
        labName = "";
        version = "";
        dateCertified = DateHelper.getCurrentDate();
        comments = "";
        references = "";
        values = new ValueModel[0];
    }

    public ParametersManager(String modelName) {
        this.modelName = modelName;
        this.labName = labName;
        this.version = version;
        this.dateCertified = dateCertified;
        comments = "";
        references = "";
        values = new ValueModel[0];
    }

    public ParametersManager(String modelName, String labName,
            String version, String dateCertified) {
        this.modelName = modelName;
        this.labName = labName;
        this.version = version;
        this.dateCertified = dateCertified;
        comments = "";
        references = "";
        values = new ValueModel[0];
    }

    public ParametersManager(String modelName, String labName,
            String version, String dateCertified, String comments,
            String references) {
        this.modelName = modelName;
        this.labName = labName;
        this.version = version;
        this.dateCertified = dateCertified;
        this.comments = comments;
        this.references = references;
        values = new ValueModel[0];
    }

    public ParametersManager(String modelName, String labName, String version,
            String dateCertified, String comments, String references,
            ValueModel[] values) {
        this.modelName = modelName;
        this.labName = labName;
        this.version = version;
        this.dateCertified = dateCertified;
        this.comments = comments;
        this.references = references;
        this.values = values;
    }

    @Override
    public int compareTo(ParametersManager o) {
        return modelName.compareTo(o.getModelName());
    }

    public boolean equals(Object o) {
        boolean retVal = o instanceof ParametersManager;
        if (retVal && ((ParametersManager) o).
                getModelName().compareTo(modelName) != 0) {
            retVal = false;
        }
        return retVal;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
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

    public ValueModel[] getValues() {
        return values;
    }

    public void setValues(ValueModel[] values) {
        this.values = values;
    }

}
