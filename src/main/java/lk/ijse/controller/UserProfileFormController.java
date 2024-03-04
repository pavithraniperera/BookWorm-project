package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class UserProfileFormController {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnLogOUt;

    @FXML
    private JFXButton btnSaveChanges;

    @FXML
    private JFXButton btnUpadte;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPw;

    @FXML
    private TextField txtTele;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Do you want to log out?");
        alert.setContentText("Choose your option.");

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the current stage
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/User_view/User_login_form.fxml")))); // Load and set the scene for login form
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Login form");
            stage.centerOnScreen();
        }

    }

    @FXML
    void btnSaveChangesOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
