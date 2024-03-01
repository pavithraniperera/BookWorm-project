package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardFormController {

    public AnchorPane pane2;
    public TableView tblCheckOuts;
    public JFXButton Dashboard;
    public AnchorPane root;
    @FXML
    private JFXButton btnBook;

    @FXML
    private JFXButton btnBranches;

    @FXML
    private JFXButton btnTransaction;
    

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
    void btnBookOnAction(ActionEvent event) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/Manage_book_form.fxml"));
            pane2.getChildren().removeAll();

            pane2.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/Manage_branches_form.fxml"));
            pane2.getChildren().removeAll();

            pane2.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnTransactionOnAction(ActionEvent event) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/All_Transaction_history_form.fxml"));
            pane2.getChildren().removeAll();

            pane2.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

  

    @FXML
    void imgExitOnAction(MouseEvent event) {

    }

    @FXML
    void imgProfileOnAction(MouseEvent event) {

    }

    public void dashboardOnAction(ActionEvent actionEvent) {

        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/Admin_dashboard-form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
