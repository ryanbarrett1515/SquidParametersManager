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

    String laboratoryName;
    ParametersManager physicalConstantsModel;
    ParametersManager refMatModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        physicalConstantsModel = new ParametersManager();
        refMatModel = new ParametersManager();
        setUpPhysicalConstantsModelsTextFields();
        setUpReferenceMaterialTextFields();
        setUpLaboratoryName();
    }

    private void setUpPhysicalConstantsModelsTextFields() {
        physConstModelName.setOnKeyTyped(value -> {
            physicalConstantsModel.setModelName(physConstModelName.getText());
        }
        );
        physConstLabName.setOnKeyTyped(value -> {
            physicalConstantsModel.setLabName(physConstLabName.getText());
        }
        );
        physConstDateCertified.setOnKeyTyped(value -> {
            physicalConstantsModel.setModelName(physConstDateCertified.getText());
        }
        );
        physConstVersion.setOnKeyTyped(value -> {
            physicalConstantsModel.setModelName(physConstVersion.getText());
        }
        );
    }

    private void setUpReferenceMaterialTextFields() {
        refMatModelName.setOnKeyTyped(value -> {
            refMatModel.setModelName(refMatModelName.getText());
        });
        refMatLabName.setOnKeyTyped(value -> {
            refMatModel.setLabName(refMatModel.getLabName());
        });
        refMatDateCertified.setOnKeyTyped(value -> {
            refMatModel.setDateCertified(refMatDateCertified.getText());
        });
        refMatModelName.setOnKeyTyped(Value -> {
            refMatModel.setVersion(refMatVersion.getText());
        });
    }

    private void setUpLaboratoryName() {
        labNameTextField.setOnKeyTyped(value -> {
            laboratoryName = labNameTextField.getText();
        });
    }
}
