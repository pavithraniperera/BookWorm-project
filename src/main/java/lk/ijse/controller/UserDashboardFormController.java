package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

public class UserDashboardFormController {

    @FXML
    private CheckBox CheckboxFilter;

    @FXML
    private JFXButton btnBorrow;

    @FXML
    private JFXButton btnDashbord;

    @FXML
    private JFXButton btnHistory;

    @FXML
    private JFXButton btnLibrary;

    @FXML
    private ComboBox<?> cmbCategory;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colGener;

    @FXML
    private TableColumn<?, ?> colLanguage;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private ImageView imgUsername;

    @FXML
    private TableView<?> tblDashboardBook;

    @FXML
    private TextField txtSearchBook;

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) {

    }

    @FXML
    void btnLibraryOnAction(ActionEvent event) {

    }

    @FXML
    void checkBoxFilterOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCategoryOnAction(ActionEvent event) {

    }

    @FXML
    void imageCloseOnAction(MouseEvent event) {

    }

    @FXML
    void imgClose(DragEvent event) {

    }

    @FXML
    void imgUserNameOnAction(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
