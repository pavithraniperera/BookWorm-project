package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLoginFormController {

    public AnchorPane root1;
    @FXML
    private JFXButton btnLogIn;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private CheckBox checkBoxPw;

    @FXML
    private PasswordField hiddenTxtPassword;

    @FXML
    private TextField showTextPw;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLogInOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/User_register_form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root1.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void checkBoxPwOnAction(ActionEvent event) {

    }

}
