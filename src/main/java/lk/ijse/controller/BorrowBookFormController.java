package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BorrowBookFormController {

    @FXML
    private JFXButton btnBorrow;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookTitle;

    @FXML
    private TableColumn<?, ?> colBtnGet;

    @FXML
    private TableColumn<?, ?> colGener;

    @FXML
    private ComboBox<?> combPeriod;

    @FXML
    private Label lblDueDate;

    @FXML
    private TableView<?> tblBook;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtGener;

    @FXML
    private TextField txtSEarch;

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearch(ActionEvent event) {

    }

}
