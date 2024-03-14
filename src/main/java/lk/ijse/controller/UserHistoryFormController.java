package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.custom.Boimpl.TransactionBoImpl;
import lk.ijse.Bo.custom.Boimpl.UserBoImpl;
import lk.ijse.Bo.custom.TransactionBo;
import lk.ijse.Bo.custom.UserBo;
import lk.ijse.Tm.TransactionTm;
import lk.ijse.dto.TransactionDto;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static lk.ijse.controller.UserLoginFormController.userId;

public class UserHistoryFormController {

    @FXML
    private TableColumn<?, ?> colBookTitle;

    @FXML
    private TableColumn<?, ?> colBorrowedDate;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colReturnedDate;

    @FXML
    private TableView<TransactionTm> tblHistory;
    private TransactionBo transactionBo = (TransactionBo) BoFactory.getBoFactory().getBoType(BoFactory.BoTypes.TRANSACTION);

    private ObservableList<TransactionTm> observableList = FXCollections.observableArrayList();


    public void initialize(){
      ;
        setCellValuefactory();
        loadAllTransactionByUser();


    }

    private void loadAllTransactionByUser() {
        try {
            List<TransactionDto> dtoList = transactionBo.getByUser(userId);
            for (TransactionDto dto : dtoList){
                if (dto.getReturn().equals(true)) {
                    observableList.add(new TransactionTm(
                            dto.getBookId(),
                            formatDateTime(dto.getReturnedDate()),
                            formatDateTime(dto.getBorrowed()),
                            (dto.getDueDate())));
                } else {
                    observableList.add(new TransactionTm(
                            dto.getBookId(),
                            "Not returned Yet",
                            formatDateTime(dto.getBorrowed()),
                            (dto.getDueDate())));
                }

            }
            tblHistory.getItems().clear();
            tblHistory.setItems(observableList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void setCellValuefactory() {
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        colBorrowedDate.setCellValueFactory(new PropertyValueFactory<>("borrow"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colReturnedDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
    }
    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Customize format (e.g., "dd/MM/yyyy")
        return dateTime.format(formatter);
    }
}
