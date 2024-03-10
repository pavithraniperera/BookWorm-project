package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.BookDto;

import java.io.IOException;

public class BookPopupCardFormController {

    @FXML
    private JFXButton btnBorrow;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookname;

    @FXML
    private Label lblCategory;

    @FXML
    private Label lblStatus;
    private BookDto dto;

    @FXML
    private AnchorPane root2;
    private AnchorPane pane2;
    public void initialize(){

    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/User_view/Borrow_book_form.fxml"));
            Parent fxml = loader.load();
            BorrowBookFormController borrowBookController = loader.getController(); // Accessing the controller
            borrowBookController.setValues(dto);

            pane2.getChildren().removeAll();
            pane2.getChildren().setAll(fxml);
            Stage stage = (Stage) root2.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public  void setValues(BookDto dto, AnchorPane pane2) {
        this.pane2 = pane2;
          this.dto = dto;
           lblAuthor.setText(dto.getAuthor());
           lblBookname.setText(dto.getTitle());
           lblStatus.setText(dto.getAvailability());
           lblCategory.setText(dto.getCategory());
           if (dto.getAvailability().equals("Unavailable")){
               btnBorrow.setDisable(false);
               new Alert(Alert.AlertType.INFORMATION,"Sorry "+lblBookname.getText() + " is Currently Unavailable").show();
           }
    }
}
