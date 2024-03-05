package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Bo.custom.Boimpl.UserBoImpl;
import lk.ijse.Bo.custom.UserBo;
import lk.ijse.dto.UserDto;
import lk.ijse.regex.RegexPattern;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserRegisterFormController {

    @FXML
    private JFXButton btnCreateAccount;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPwd;

    private UserBo userBo = new UserBoImpl();

    @FXML
    void btnCreateAccountOnAction(ActionEvent event) {
        if (validation()){
            try {
                userBo.saveUser(new UserDto(txtName.getText(),txtEmail.getText(),txtPwd.getText()));
                new Alert(Alert.AlertType.CONFIRMATION,"Your registration is successful").show();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }



    public boolean validation(){
        if (!(Pattern.matches(String.valueOf(RegexPattern.getNamePattern()),txtName.getText()))){
            new Alert(Alert.AlertType.ERROR,"Invalid name").show();
            return  false;
        }

        if (!(Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",txtPwd.getText()))){
            new Alert(Alert.AlertType.ERROR,"Invalid Password type");
            return  false;
        }

        if (!(Pattern.matches(String.valueOf(RegexPattern.getEmailPattern()),txtEmail.getText()))){
            new Alert(Alert.AlertType.ERROR,"Invalid Email").show();
            return  false;
        }

        return  true;

    }

}
