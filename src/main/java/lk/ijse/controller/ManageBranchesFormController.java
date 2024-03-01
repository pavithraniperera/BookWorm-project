package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageBranchesFormController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<?> tblBranch;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private JFXButton txtDelete;

    @FXML
    private TextField txtName;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void txtDeleteAction(ActionEvent event) {

    }

    @FXML
    void txtUpdateOnAction(ActionEvent event) {

    }

}
