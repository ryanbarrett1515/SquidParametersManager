/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager.parameterModels;

import java.io.Serializable;
import java.math.BigDecimal;
import org.cirdles.squidParametersManager.ValueModel;
import org.cirdles.squidParametersManager.matrices.CorrelationMatrixModel;
import org.cirdles.squidParametersManager.matrices.CovarianceMatrixModel;
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
    protected CorrelationMatrixModel corrModel;
    protected CovarianceMatrixModel covModel;

    public ParametersManager() {
        modelName = "";
        labName = "";
        version = "";
        dateCertified = DateHelper.getCurrentDate();
        comments = "";
        references = "";
        values = new ValueModel[5];
        values[0] = new ValueModel("test", "test", "test", new BigDecimal(9.4983756873465873465687345),
                new BigDecimal(0), new BigDecimal(0));
        values[1] = new ValueModel("test", "test", "test", new BigDecimal(0),
                new BigDecimal(0), new BigDecimal(0));
        values[2] = new ValueModel("test", "test", "test", new BigDecimal(0),
                new BigDecimal(0), new BigDecimal(0));
        values[3] = new ValueModel("test", "test", "test", new BigDecimal(0),
                new BigDecimal(0), new BigDecimal(0));
        values[4] = new ValueModel("test", "test", "test", new BigDecimal(0),
                new BigDecimal(0), new BigDecimal(0));
        corrModel = new CorrelationMatrixModel();
        covModel = new CovarianceMatrixModel();
    }

    public ParametersManager(String modelName) {
        this.modelName = modelName;
        this.labName = labName;
        this.version = version;
        this.dateCertified = dateCertified;
        comments = "";
        references = "";
        values = new ValueModel[0];
        corrModel = new CorrelationMatrixModel();
        covModel = new CovarianceMatrixModel();
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
        corrModel = new CorrelationMatrixModel();
        covModel = new CovarianceMatrixModel();
    }

    public ParametersManager(String modelName, String labName, String version,
            String dateCertified, String comments, String references) {
        this.modelName = modelName;
        this.labName = labName;
        this.version = version;
        this.dateCertified = dateCertified;
        this.comments = comments;
        this.references = references;
        values = new ValueModel[0];
        corrModel = new CorrelationMatrixModel();
        covModel = new CovarianceMatrixModel();
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
        corrModel = new CorrelationMatrixModel();
        covModel = new CovarianceMatrixModel();
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

    public CorrelationMatrixModel getCorrModel() {
        return corrModel;
    }

    public void setCorrModel(CorrelationMatrixModel corrModel) {
        this.corrModel = corrModel;
    }

    public CovarianceMatrixModel getCovModel() {
        return covModel;
    }

    public void setCovModel(CovarianceMatrixModel covModel) {
        this.covModel = covModel;
    }

}
