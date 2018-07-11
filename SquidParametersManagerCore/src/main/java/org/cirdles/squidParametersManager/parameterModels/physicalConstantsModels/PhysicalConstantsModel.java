/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager.parameterModels.physicalConstantsModels;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import org.cirdles.squidParametersManager.parameterModels.ParametersManager;
import org.cirdles.squidParametersManager.util.XStreamETReduxConverters.ETReduxPhysConstConverter;

/**
 *
 * @author ryanb
 */
public class PhysicalConstantsModel extends ParametersManager {

    Map<String, BigDecimal> molarMasses;

    public PhysicalConstantsModel() {
        super();
        molarMasses = new TreeMap<>();
        setUpDefaultMolarMasses();
    }

    public Map<String, BigDecimal> getMolarMasses() {
        return molarMasses;
    }

    public void setMolarMasses(Map<String, BigDecimal> molarMasses) {
        this.molarMasses = molarMasses;
    }

    public void setUpDefaultMolarMasses() {
        molarMasses.put("gmol204", new BigDecimal("203.973028"));
        molarMasses.put("gmol205", new BigDecimal("204.9737"));
        molarMasses.put("gmol206", new BigDecimal("205.974449"));
        molarMasses.put("gmol207", new BigDecimal("206.975880"));
        molarMasses.put("gmol208", new BigDecimal("207.976636"));
        molarMasses.put("gmol230", new BigDecimal("230.033128"));
        molarMasses.put("gmol232", new BigDecimal("232.038051"));
        molarMasses.put("gmol235", new BigDecimal("235.043922"));
        molarMasses.put("gmol238", new BigDecimal("238.050785"));
    }

    public static PhysicalConstantsModel getPhysicalConstantsModelFromETReduxXML(String input) {
        XStream xstream = getETReduxXStream();
        PhysicalConstantsModel model = (PhysicalConstantsModel) xstream.fromXML(input);
        return model;
    }

    public static PhysicalConstantsModel getPhysicalConstantsModelFromETReduxXML(File input) {
        XStream xstream = getETReduxXStream();
        PhysicalConstantsModel model = (PhysicalConstantsModel) xstream.fromXML(input);
        return model;
    }

    public static XStream getETReduxXStream() {
        XStream xstream = new XStream();
        xstream.registerConverter(new ETReduxPhysConstConverter());
        xstream.alias("PhysicalConstantsModel", PhysicalConstantsModel.class);
        return xstream;
    }

}
