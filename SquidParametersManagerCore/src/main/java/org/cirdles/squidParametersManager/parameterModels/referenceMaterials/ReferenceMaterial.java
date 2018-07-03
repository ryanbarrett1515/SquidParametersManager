/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager.parameterModels.referenceMaterials;

import org.cirdles.squidParametersManager.ValueModel;
import org.cirdles.squidParametersManager.parameterModels.ParametersManager;

/**
 *
 * @author ryanb
 */
public class ReferenceMaterial extends ParametersManager {

    ValueModel[] concentrations;

    public ReferenceMaterial() {
        super();
        concentrations = new ValueModel[0];
    }

    public ValueModel[] getConcentrations() {
        return concentrations;
    }

    public void setConcentrations(ValueModel[] concentrations) {
        this.concentrations = concentrations;
    }

}
