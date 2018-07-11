/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager.parameterModels.referenceMaterials;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import org.cirdles.squidParametersManager.ValueModel;
import org.cirdles.squidParametersManager.parameterModels.ParametersManager;
import org.cirdles.squidParametersManager.parameterModels.physicalConstantsModels.PhysicalConstantsModel;
import static org.cirdles.squidParametersManager.parameterModels.physicalConstantsModels.PhysicalConstantsModel.getETReduxXStream;
import org.cirdles.squidParametersManager.util.XStreamETReduxConverters.ETReduxRefMatConverter;

/**
 *
 * @author ryanb
 */
public class ReferenceMaterial extends ParametersManager {

    ValueModel[] concentrations;
    boolean[] dataMeasured;

    public ReferenceMaterial() {
        super();
        concentrations = new ValueModel[0];
        dataMeasured = new boolean[0];
    }

    public ValueModel[] getConcentrations() {
        return concentrations;
    }

    public void setConcentrations(ValueModel[] concentrations) {
        this.concentrations = concentrations;
    }

    public boolean[] getDataMeasured() {
        return dataMeasured;
    }

    public void setDataMeasured(boolean[] dataMeasured) {
        this.dataMeasured = dataMeasured;
    }

    public static XStream getETReduxXStream() {
        XStream xstream = new XStream();
        xstream.registerConverter(new ETReduxRefMatConverter());
        xstream.alias("ReferenceMaterial", ReferenceMaterial.class);
        return xstream;
    }

    public static ReferenceMaterial getReferenceMaterialFromETReduxXML(String input) {
        XStream xstream = getETReduxXStream();
        ReferenceMaterial model = (ReferenceMaterial) xstream.fromXML(input);
        return model;
    }

    public static ReferenceMaterial getReferenceMaterialFromETReduxXML(File input) {
        XStream xstream = getETReduxXStream();
        ReferenceMaterial model = (ReferenceMaterial) xstream.fromXML(input);
        return model;
    }
}
