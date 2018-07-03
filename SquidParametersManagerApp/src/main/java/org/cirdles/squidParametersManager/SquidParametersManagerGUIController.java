/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import org.cirdles.squidParametersManager.parameterModels.physicalConstantsModels.PhysicalConstantsModel;
import org.cirdles.squidParametersManager.parameterModels.referenceMaterials.ReferenceMaterial;

/**
 * FXML Controller class
 *
 * @author ryanb
 */
public class SquidParametersManagerGUIController implements Initializable {

    @FXML
    private MenuItem physConstImpXML;
    @FXML
    private MenuItem phyConstExpXML;
    @FXML
    private MenuItem remCurrPhyConst;
    @FXML
    private MenuItem editCopyOfCurrPhysConst;
    @FXML
    private MenuItem editNewEmpPhysConst;
    @FXML
    private MenuItem cancelEditOfPhysConst;
    @FXML
    private MenuItem saveAndRegCurrPhysConst;
    @FXML
    private Button physConstQuitButton;
    @FXML
    private ChoiceBox<?> physConstCB;
    @FXML
    private TextField physConstModelName;
    @FXML
    private TextField physConstLabName;
    @FXML
    private TextField physConstVersion;
    @FXML
    private TextField physConstDateCertified;
    @FXML
    private Label physConstIsEditableLabel;
    @FXML
    private MenuItem expRefMatXML;
    @FXML
    private MenuItem impRefMatXML;
    @FXML
    private MenuItem saveAndRegCurrRefMat;
    @FXML
    private MenuItem remCurrRefMat;
    @FXML
    private MenuItem canEditOfRefMat;
    @FXML
    private MenuItem editNewEmptyRefMat;
    @FXML
    private MenuItem editCopyOfCurrRefMat;
    @FXML
    private MenuItem editCurrRefMat;
    @FXML
    private Button refMatQuitButton;
    @FXML
    private ChoiceBox<?> refMatCB;
    @FXML
    private TextField refMatModelName;
    @FXML
    private TextField refMatLabName;
    @FXML
    private TextField refMatVersion;
    @FXML
    private TextField refMatDateCertified;
    @FXML
    private Label refMatIsEditable;
    @FXML
    private Button okayButton;
    @FXML
    private TextField labNameTextField;
    @FXML
    private TextArea physConstReferencesArea;
    @FXML
    private TextArea physConstCommentsArea;
    @FXML
    private TextArea refMatReferencesArea;
    @FXML
    private TextArea refMatCommentsArea;
    @FXML
    private TableView<DataModel> physConstDataTable;
    @FXML
    private TableView<DataModel> refMatDataTable;
    @FXML
    private TextArea molarMassesTextArea;
    @FXML
    private AnchorPane referencesPane;
    @FXML
    private TableView<DataModel> refMatConcentrationsTable;
    
    String laboratoryName;
    PhysicalConstantsModel physConstModel;
    ReferenceMaterial refMatModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        laboratoryName = "";
        physConstModel = new PhysicalConstantsModel();
        refMatModel = new ReferenceMaterial();

        setUpPhysicalConstantsModelsTextFields();
        setUpPhysConstData();
        setUpMolarMasses();
        setUpReferences();

        setUpReferenceMaterialTextFields();
        setUpRefMatData();
        setUpConcentrations();

        setUpLaboratoryName();
    }

    private void setUpPhysConstData() {
        physConstDataTable.getColumns().clear();

        TableColumn nameCol = new TableColumn("name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("name"));

        TableColumn valCol = new TableColumn("value");
        valCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("value"));

        TableColumn absCol = new TableColumn("1σ ABS");
        absCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("oneSigmaABS"));

        TableColumn pctCol = new TableColumn("1σ PCT");
        pctCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("oneSigmaPCT"));

        physConstDataTable.getColumns().addAll(nameCol, valCol, absCol, pctCol);

        final ObservableList<DataModel> obList = FXCollections.observableArrayList();
        for (int i = 0; i < physConstModel.getValues().length; i++) {
            ValueModel valMod = physConstModel.getValues()[i];
            DataModel mod = new DataModel(valMod.getName(), valMod.getValue(),
                    valMod.getOneSigma(), valMod.getOneSigmaSys());
            obList.add(mod);
        }
        physConstDataTable.setItems(obList);

        physConstDataTable.refresh();
    }

    private void setUpRefMatData() {
        refMatDataTable.getColumns().clear();

        TableColumn nameCol = new TableColumn("name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("name"));

        TableColumn valCol = new TableColumn("value");
        valCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("value"));

        TableColumn absCol = new TableColumn("1σ ABS");
        absCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("oneSigmaABS"));

        TableColumn pctCol = new TableColumn("1σ PCT");
        pctCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("oneSigmaPCT"));

        refMatDataTable.getColumns().addAll(nameCol, valCol, absCol, pctCol);

        final ObservableList<DataModel> obList = FXCollections.observableArrayList();
        for (int i = 0; i < refMatModel.getValues().length; i++) {
            ValueModel valMod = refMatModel.getValues()[i];
            DataModel mod = new DataModel(valMod.getName(), valMod.getValue(),
                    valMod.getOneSigma(), valMod.getOneSigmaSys());
            obList.add(mod);
        }
        refMatDataTable.setItems(obList);

        refMatDataTable.refresh();
    }
    
    private void setUpConcentrations() {
        refMatConcentrationsTable.getColumns().clear();

        TableColumn nameCol = new TableColumn("name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("name"));

        TableColumn valCol = new TableColumn("value");
        valCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("value"));

        TableColumn absCol = new TableColumn("1σ ABS");
        absCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("oneSigmaABS"));

        TableColumn pctCol = new TableColumn("1σ PCT");
        pctCol.setCellValueFactory(
                new PropertyValueFactory<DataModel, String>("oneSigmaPCT"));

        refMatConcentrationsTable.getColumns().addAll(nameCol, valCol, absCol, pctCol);

        final ObservableList<DataModel> obList = FXCollections.observableArrayList();
        for (int i = 0; i < refMatModel.getConcentrations().length; i++) {
            ValueModel valMod = refMatModel.getConcentrations()[i];
            DataModel mod = new DataModel(valMod.getName(), valMod.getValue(),
                    valMod.getOneSigma(), valMod.getOneSigmaSys());
            obList.add(mod);
        }
        refMatDataTable.setItems(obList);

        refMatDataTable.refresh();
    }

    private void setUpMolarMasses() {
        Iterator<Entry<String, BigDecimal>> molarMassesIterator
                = physConstModel.getMolarMasses().entrySet().iterator();
        Entry<String, BigDecimal> curr;
        if (molarMassesIterator.hasNext()) {
            curr = molarMassesIterator.next();
            molarMassesTextArea.appendText(curr.getKey() + " = " + curr.getValue());
        }
        while (molarMassesIterator.hasNext()) {
            curr = molarMassesIterator.next();
            molarMassesTextArea.appendText("\n" + curr.getKey() + " = "
                    + curr.getValue());
        }
    }

    private void setUpReferences() {
        ValueModel[] models = physConstModel.getValues();
        int currHeight = 0;
        for (int i = 0; i < models.length; i++) {
            ValueModel mod = models[i];

            Label lab = new Label(mod.getName() + ":");
            referencesPane.getChildren().add(lab);
            lab.setLayoutY(currHeight + 5);
            lab.setLayoutX(10);
            lab.setTextAlignment(TextAlignment.RIGHT);

            TextField text = new TextField(mod.getReference());
            referencesPane.getChildren().add(text);
            text.setLayoutY(currHeight);
            text.setLayoutX(lab.getLayoutX() + 50);
            text.setPrefWidth(100);
            text.setOnKeyReleased(value -> {
                mod.setReference(text.getText());
            });

            currHeight += 40;
        }
    }

    private void setUpPhysicalConstantsModelsTextFields() {
        physConstModelName.setText(physConstModel.getModelName());
        physConstModelName.setOnKeyReleased(value -> {
            physConstModel.setModelName(physConstModelName.getText());
        });
        physConstLabName.setText(physConstModel.getLabName());
        physConstLabName.setOnKeyReleased(value -> {
            physConstModel.setLabName(physConstLabName.getText());
        });
        physConstDateCertified.setText(physConstModel.getDateCertified());
        physConstDateCertified.setOnKeyReleased(value -> {
            physConstModel.setModelName(physConstDateCertified.getText());
        });
        physConstVersion.setText(physConstModel.getVersion());
        physConstVersion.setOnKeyReleased(value -> {
            physConstModel.setModelName(physConstVersion.getText());
        });
        physConstReferencesArea.setText(physConstModel.getReferences());
        physConstReferencesArea.setOnKeyReleased(value -> {
            physConstModel.setReferences(physConstReferencesArea.getText());
        });
        physConstCommentsArea.setText(physConstModel.getComments());
        physConstCommentsArea.setOnKeyReleased(value -> {
            physConstModel.setComments(physConstCommentsArea.getText());
        });
    }

    private void setUpReferenceMaterialTextFields() {
        refMatModelName.setText(refMatModel.getModelName());
        refMatModelName.setOnKeyReleased(value -> {
            refMatModel.setModelName(refMatModelName.getText());
        });
        refMatLabName.setText(refMatModel.getLabName());
        refMatLabName.setOnKeyReleased(value -> {
            refMatModel.setLabName(refMatModel.getLabName());
        });
        refMatDateCertified.setText(refMatModel.getDateCertified());
        refMatDateCertified.setOnKeyReleased(value -> {
            refMatModel.setDateCertified(refMatDateCertified.getText());
        });
        refMatVersion.setText(refMatModel.getVersion());
        refMatVersion.setOnKeyReleased(value -> {
            refMatModel.setVersion(refMatVersion.getText());
        });
        refMatReferencesArea.setText(refMatModel.getReferences());
        refMatReferencesArea.setOnKeyReleased(value -> {
            refMatModel.setReferences(refMatReferencesArea.getText());
        });
        refMatCommentsArea.setText(refMatModel.getComments());
        refMatCommentsArea.setOnKeyReleased(value -> {
            refMatModel.setComments(refMatCommentsArea.getText());
        });
    }

    private void setUpLaboratoryName() {
        labNameTextField.setText(laboratoryName);
        labNameTextField.setOnKeyReleased(value -> {
            laboratoryName = labNameTextField.getText();
        });

    }

    public class DataModel {

        private SimpleStringProperty name;
        private TextField value;
        private TextField oneSigmaABS;
        private TextField oneSigmaPCT;

        public DataModel(String name, BigDecimal value,
                BigDecimal oneSigmaABS, BigDecimal oneSigmaPCT) {
            this.name = new SimpleStringProperty(name);
            this.value = new TextField(value.toPlainString());
            this.oneSigmaABS = new TextField(oneSigmaABS.toPlainString());
            this.oneSigmaPCT = new TextField(oneSigmaPCT.toPlainString());
        }

        public String getName() {
            return name.get();
        }

        public TextField getValue() {
            return value;
        }

        public TextField getOneSigmaABS() {
            return oneSigmaABS;
        }

        public TextField getOneSigmaPCT() {
            return oneSigmaPCT;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public void setValue(TextField value) {
            this.value = value;
        }

        public void setOneSigmaABS(TextField oneSigmaABS) {
            this.oneSigmaABS = oneSigmaABS;
        }

        public void setOneSigmaPCT(TextField oneSigmaPCT) {
            this.oneSigmaPCT = oneSigmaPCT;
        }

    }
}
