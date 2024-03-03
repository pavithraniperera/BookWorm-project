package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class AllTransactionHistoryFormController {

    public AnchorPane root;
    @FXML
    private TableColumn<?, ?> ColBookId;

    @FXML
    private TableColumn<?, ?> ColBookName;

    @FXML
    private JFXButton btnOverdue;

    @FXML
    private TableColumn<?, ?> colBranchId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colTransactionId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private ComboBox<?> combType;

    @FXML
    private TableView<?> tblTransaction;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnOverdueAction(ActionEvent event) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/Admin_view/Unreturned_book_form.fxml"));
            root.getChildren().removeAll();

            root.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void combTypeOnAction(ActionEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
