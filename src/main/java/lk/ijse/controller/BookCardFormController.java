package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.ijse.Bo.custom.Boimpl.BookBoImpl;
import lk.ijse.Bo.custom.BookBo;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.TransactionDto;

import java.sql.SQLException;

public class BookCardFormController {

    @FXML
    private JFXButton btnReturn;

    @FXML
    private Label lblBookname;

    @FXML
    private Label lblBorrowDate;

    @FXML
    private Label lblCategory;

    @FXML
    private Label lblDueDate;
    private MyLibraryFormController libraryFormController;
    private BookBo bookBo = new BookBoImpl();
    private TransactionDto transactionDto ;

    @FXML
    void btnReturnOnAction(ActionEvent event) {
        


    }

    public void setData(TransactionDto transactionDto) {
        try {
           this. transactionDto = transactionDto;
            BookDto bookDto = bookBo.getBook(transactionDto.getBookId());
            lblBookname.setText(transactionDto.getBookId());
            lblCategory.setText(bookDto.getCategory());
            lblBorrowDate.setText(String.valueOf(transactionDto.getBorrowed()));
            lblDueDate.setText(String.valueOf(transactionDto.getDueDate()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void setLibraryFormController(MyLibraryFormController libraryFormController) {
        this.libraryFormController = libraryFormController;
    }

    public MyLibraryFormController getLibraryFormController() {
        return libraryFormController;
    }
}
