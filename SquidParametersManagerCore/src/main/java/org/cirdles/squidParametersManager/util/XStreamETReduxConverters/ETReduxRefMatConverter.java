/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager.util.XStreamETReduxConverters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.cirdles.squidParametersManager.ValueModel;
import org.cirdles.squidParametersManager.parameterModels.referenceMaterials.ReferenceMaterial;

/**
 *
 * @author ryanb
 */
public class ETReduxRefMatConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(ReferenceMaterial.class);
    }

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext context) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        ReferenceMaterial model = new ReferenceMaterial();

        reader.moveDown();
        model.setModelName(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        model.setVersion(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        model.setLabName(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        model.setDateCertified(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        model.setReferences(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        model.setComments(reader.getValue());
        reader.moveUp();

        List<ValueModel> values = new ArrayList<>();
        List<Boolean> measures = new ArrayList<>();
        reader.moveDown();
        while (reader.hasMoreChildren()) {
            ValueModel valMod = new ValueModel();

            reader.moveDown();
            
            reader.moveDown();
            valMod.setName(reader.getValue());
            reader.moveUp();

            reader.moveDown();
            valMod.setValue(new BigDecimal(reader.getValue()));
            reader.moveUp();

            reader.moveDown();
            valMod.setUncertaintyType(reader.getValue());
            reader.moveUp();

            reader.moveDown();
            valMod.setOneSigma(new BigDecimal(reader.getValue()));
            reader.moveUp();
            
            reader.moveDown();
            measures.add(Boolean.parseBoolean(reader.getValue()));
            reader.moveUp();
            
            reader.moveUp();
            
            values.add(valMod);
        }
        reader.moveUp();
        ValueModel[] valuesArray = new ValueModel[values.size()];
        boolean[] measuredArray = new boolean[values.size()];
        for(int i = 0; i < values.size(); i++) {
            valuesArray[i] = values.get(i);
            measuredArray[i] = measures.get(i);
        }
        model.setValues(valuesArray);
        model.setDataMeasured(measuredArray);
        
        List<ValueModel> concentrationsList = new ArrayList<>();
        reader.moveDown();
        while (reader.hasMoreChildren()) {
            ValueModel valMod = new ValueModel();

            reader.moveDown();
            
            reader.moveDown();
            valMod.setName(reader.getValue());
            reader.moveUp();

            reader.moveDown();
            valMod.setValue(new BigDecimal(reader.getValue()));
            reader.moveUp();

            reader.moveDown();
            valMod.setUncertaintyType(reader.getValue());
            reader.moveUp();

            reader.moveDown();
            valMod.setOneSigma(new BigDecimal(reader.getValue()));
            reader.moveUp();
            
            reader.moveUp();
            
            concentrationsList.add(valMod);
        }
        reader.moveUp();
        ValueModel[] concentrations = new ValueModel[values.size()];
        for(int i = 0; i < concentrationsList.size(); i++) {
            concentrations[i] = concentrationsList.get(i);
        }
        model.setConcentrations(concentrations);

        return model;
    }
}
