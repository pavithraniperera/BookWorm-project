package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class UnreturnedBookFormController {

    @FXML
    private ComboBox<?> cmbBranch;

    @FXML
    private TableColumn<?, ?> colBook;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colOverdueDays;

    @FXML
    private TableView<?> tblOverdueBooks;

    @FXML
    void cmbBranchOnActions(ActionEvent event) {

    }

}
