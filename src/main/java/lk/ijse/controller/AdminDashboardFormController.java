package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminDashboardFormController {

    @FXML
    private JFXButton btnBook;

    @FXML
    private JFXButton btnBranches;

    @FXML
    private JFXButton btnTransaction;

    @FXML
    private JFXButton btnUser;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private ImageView imgExit;

    @FXML
    private ImageView imgProfile;

    @FXML
    private Label lblBook;

    @FXML
    private Label lblUser;

    @FXML
    private AnchorPane tblCheckOuts;

    @FXML
    void btnBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) {

    }

    @FXML
    void btnTransactionOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewUserOnAction(ActionEvent event) {

    }

    @FXML
    void imgExitOnAction(MouseEvent event) {

    }

    @FXML
    void imgProfileOnAction(MouseEvent event) {

    }

}
