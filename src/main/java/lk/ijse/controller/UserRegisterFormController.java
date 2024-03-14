package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.custom.Boimpl.BranchBoImpl;
import lk.ijse.Bo.custom.Boimpl.UserBoImpl;
import lk.ijse.Bo.custom.BranchBo;
import lk.ijse.Bo.custom.UserBo;
import lk.ijse.dto.BranchDto;
import lk.ijse.dto.UserDto;
import lk.ijse.regex.RegexPattern;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class UserRegisterFormController {

    public ComboBox<String> cmbBranch;
    @FXML
    private JFXButton btnCreateAccount;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPwd;

    private UserBo userBo = (UserBo) BoFactory.getBoFactory().getBoType(BoFactory.BoTypes.USER);
    private BranchBo branchBo = (BranchBo) BoFactory.getBoFactory().getBoType(BoFactory.BoTypes.BRANCH);
    public void initialize(){
        loadBranches();
    }

    private void loadBranches() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        try {
            List<BranchDto> branchDtos = branchBo.getAllBranches();
            for (BranchDto dto :branchDtos){
                observableList.add(dto.getBranchName());
            }
            cmbBranch.setItems(observableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnCreateAccountOnAction(ActionEvent event) {
        if (validation()){
            try {
                userBo.saveUser(new UserDto(txtName.getText(),txtEmail.getText(),txtPwd.getText(),cmbBranch.getValue()));
                new Alert(Alert.AlertType.CONFIRMATION,"Your registration is successful").show();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get the current stage
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/User_view/User_login_form.fxml")))); // Load and set the scene for login form
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Login form");
                stage.centerOnScreen();
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
