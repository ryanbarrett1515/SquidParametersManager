/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author ryanb
 */
public class ValueModel implements Comparable<ValueModel>, Serializable {

    private String name;
    private String uncertaintyType;
    private String reference;
    private BigDecimal value;
    private BigDecimal oneSigma;
    private BigDecimal oneSigmaSys;

    public ValueModel() {
        this.name = "";
        uncertaintyType = "";
        reference = "";
        value = null;
        oneSigma = null;
        oneSigmaSys = null;
    }

    public ValueModel(String name) {
        this.name = name;
        uncertaintyType = "";
        reference = "";
        value = null;
        oneSigma = null;
        oneSigmaSys = null;
    }

    public ValueModel(String name, String uncertaintyType, String reference, BigDecimal value, BigDecimal oneSigma, BigDecimal oneSigmaSys) {
        this.name = name;
        this.uncertaintyType = uncertaintyType;
        this.reference = reference;
        this.value = value;
        this.oneSigma = oneSigma;
        this.oneSigmaSys = oneSigmaSys;
    }

    @Override
    public int compareTo(ValueModel o) {
        return name.compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUncertaintyType() {
        return uncertaintyType;
    }

    public void setUncertaintyType(String uncertaintyType) {
        this.uncertaintyType = uncertaintyType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getOneSigma() {
        return oneSigma;
    }

    public void setOneSigma(BigDecimal oneSigma) {
        this.oneSigma = oneSigma;
    }

    public BigDecimal getOneSigmaSys() {
        return oneSigmaSys;
    }

    public void setOneSigmaSys(BigDecimal oneSigmaSys) {
        this.oneSigmaSys = oneSigmaSys;
    }

}