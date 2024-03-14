package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.custom.AdminBo;
import lk.ijse.Bo.custom.Boimpl.AdminBoImpl;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class AdminLoginFormController {

    public AnchorPane root;
    public JFXButton btnBack;
    @FXML
    private JFXButton btnLogIn;

    @FXML
    private CheckBox checkBoxPw;

    @FXML
    private PasswordField hiddenTxtPassword;

    @FXML
    private TextField showTextPw;

    @FXML
    private TextField txtUserName;
    private AdminBo adminBo = (AdminBo) BoFactory.getBoFactory().getBoType(BoFactory.BoTypes.ADMIN);

    @FXML
    void btnLogInOnAction(ActionEvent event) {

        login();

    }

    @FXML
    void checkBoxPwOnAction(ActionEvent event) {

        if (checkBoxPw.isSelected()){
            showTextPw.setText(hiddenTxtPassword.getText());
            showTextPw.setVisible(true);
            hiddenTxtPassword.setVisible(false);
        }
        else{
            hiddenTxtPassword.setText(showTextPw.getText());
            hiddenTxtPassword.setVisible(true);
            showTextPw.setVisible(false);
        }
    }
    void login(){
        String username = txtUserName.getText();
        String pw = hiddenTxtPassword.getText();
        String pw1 = showTextPw.getText();
        try {
            List<AdminDto> adminDtoList = adminBo.getAllAdmins();

            boolean loginSuccess = false;
            for (AdminDto dto : adminDtoList) {
                if (dto.getUserName().equals(username) && (dto.getPassword().equals(pw) || dto.getPassword().equals(pw1))) {

                    AnchorPane anchorPane = null;
                    try {
                        anchorPane = FXMLLoader.load(getClass().getResource("/view/Admin_view/Admin_dashboard-form.fxml"));
                        Scene scene = new Scene(anchorPane);
                        Stage stage = (Stage) root.getScene().getWindow();
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        fillProfileData();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    // Set login success flag to true
                    loginSuccess = true;
                    break;
                }
            }

            if (loginSuccess) {
                // Show success message if login is successful
                new Alert(Alert.AlertType.CONFIRMATION, "Login Successful").show();
            } else {
                // Show error message if login fails
                new Alert(Alert.AlertType.ERROR, "Your login details are incorrect").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillProfileData() {
        AdminProfileFormController.setValue(txtUserName.getText());
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/loging_form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            fillProfileData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
