/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidparametersmanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ryanb
 */
public class SquidParametersManagerGUIController implements Initializable {

    @FXML
    private AnchorPane backAnchorPane;
    @FXML
    private TabPane backTabPane;
    @FXML
    private Tab physConstTab;
    @FXML
    private AnchorPane physConstAnchor;
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
    private Tab refMatTab;
    @FXML
    private AnchorPane refMatAnchor;
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
    private Button okayButton;
    @FXML
    private TextField labNameTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
