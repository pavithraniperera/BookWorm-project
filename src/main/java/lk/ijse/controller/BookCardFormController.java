package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import jakarta.transaction.Transactional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.custom.Boimpl.BookBoImpl;
import lk.ijse.Bo.custom.Boimpl.TransactionBoImpl;
import lk.ijse.Bo.custom.BookBo;
import lk.ijse.Bo.custom.TransactionBo;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dto.BookDto;
import lk.ijse.dto.TransactionDto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

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
    private BookBo bookBo = (BookBo) BoFactory.getBoFactory().getBoType(BoFactory.BoTypes.BOOK);
    private TransactionBo transactionBo = (TransactionBo) BoFactory.getBoFactory().getBoType(BoFactory.BoTypes.TRANSACTION);
    private TransactionDto transactionDto ;

    @FXML
    void btnReturnOnAction(ActionEvent event) {

        try {
            var dto= transactionBo.gettransactionByBookUser(transactionDto.getBookId(),transactionDto.getUserId());
            System.out.println(dto.getId());
            dto.setReturn(true);
            dto.setReturnedDate(LocalDateTime.now());
            BookDto dto1 =  bookBo.getBook(transactionDto.getBookId());
            dto1.setAvailability("Available");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Do you want to Return the book?");
            alert.setContentText("Choose your option.");

            ButtonType yesButton = new ButtonType("Yes");
            ButtonType noButton = new ButtonType("No");

            alert.getButtonTypes().setAll(yesButton, noButton);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == yesButton) {

               updateBookAndTransaction(dto1,dto);
               libraryFormController.initialize();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Transactional
    private void updateBookAndTransaction(BookDto dto1, TransactionDto dto) {

        if (dto != null) {

            BookDto bookDto = null;
            try {
                transactionBo.update(dto);
                bookDto = bookBo.getBook(dto.getBookId());
                bookDto.setAvailability("Available");
                bookBo.updateBook(bookDto);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            new Alert(Alert.AlertType.INFORMATION, "Book is Returned successfully").show();
        } else {

            try {
                throw new Exception("Transaction not found.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

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
