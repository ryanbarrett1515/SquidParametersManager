/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.cirdles.squidParametersManager.parameterModels.ParametersManager;

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

    String laboratoryName;
    ParametersManager physConstModel;
    ParametersManager refMatModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        laboratoryName = "";
        physConstModel = new ParametersManager();
        refMatModel = new ParametersManager();
        setUpPhysicalConstantsModelsTextFields();
        setUpReferenceMaterialTextFields();
        setUpLaboratoryName();
    }

    private void setUpPhysicalConstantsModelsTextFields() {
        physConstModelName.setText(physConstModel.getModelName());
        physConstModelName.setOnKeyTyped(value -> {
            physConstModel.setModelName(physConstModelName.getText());
        });
        physConstLabName.setText(physConstModel.getLabName());
        physConstLabName.setOnKeyTyped(value -> {
            physConstModel.setLabName(physConstLabName.getText());
        });
        physConstDateCertified.setText(physConstModel.getDateCertified());
        physConstDateCertified.setOnKeyTyped(value -> {
            physConstModel.setModelName(physConstDateCertified.getText());
        });
        physConstVersion.setText(physConstModel.getVersion());
        physConstVersion.setOnKeyTyped(value -> {
            physConstModel.setModelName(physConstVersion.getText());
        });
        physConstReferencesArea.setText(physConstModel.getReferences());
        physConstReferencesArea.setOnKeyTyped(value -> {
            physConstModel.setReferences(physConstReferencesArea.getText());
        });
        physConstCommentsArea.setText(physConstModel.getComments());
        physConstCommentsArea.setOnKeyTyped(value -> {
            physConstModel.setComments(physConstCommentsArea.getText());
        });
    }

    private void setUpReferenceMaterialTextFields() {
        refMatModelName.setText(refMatModel.getModelName());
        refMatModelName.setOnKeyTyped(value -> {
            refMatModel.setModelName(refMatModelName.getText());
        });
        refMatLabName.setText(refMatModel.getLabName());
        refMatLabName.setOnKeyTyped(value -> {
            refMatModel.setLabName(refMatModel.getLabName());
        });
        refMatDateCertified.setText(refMatModel.getDateCertified());
        refMatDateCertified.setOnKeyTyped(value -> {
            refMatModel.setDateCertified(refMatDateCertified.getText());
        });
        refMatVersion.setText(refMatModel.getVersion());
        refMatVersion.setOnKeyTyped(value -> {
            refMatModel.setVersion(refMatVersion.getText());
        });
        refMatReferencesArea.setText(refMatModel.getReferences());
        refMatReferencesArea.setOnKeyTyped(value -> {
            refMatModel.setReferences(refMatReferencesArea.getText());
        });
        refMatCommentsArea.setText(refMatModel.getComments());
        refMatCommentsArea.setOnKeyTyped(value -> {
            refMatModel.setComments(refMatCommentsArea.getText());
        });
    }

    private void setUpLaboratoryName() {
        labNameTextField.setText(laboratoryName);
        labNameTextField.setOnKeyTyped(value -> {
            laboratoryName = labNameTextField.getText();
        });
    }
}
