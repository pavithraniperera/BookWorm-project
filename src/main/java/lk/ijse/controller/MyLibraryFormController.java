package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.custom.Boimpl.BookBoImpl;
import lk.ijse.Bo.custom.Boimpl.TransactionBoImpl;
import lk.ijse.Bo.custom.Boimpl.UserBoImpl;
import lk.ijse.Bo.custom.BookBo;
import lk.ijse.Bo.custom.TransactionBo;
import lk.ijse.Bo.custom.UserBo;
import lk.ijse.Dao.custom.TransactionDao;
import lk.ijse.Tm.BookTm;
import lk.ijse.dto.TransactionDto;
import lk.ijse.entity.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static lk.ijse.controller.UserLoginFormController.userId;

public class MyLibraryFormController {

    public AnchorPane pane2;
    public javafx.scene.control.ScrollPane ScrollPane;
    public GridPane bookGrid;
    private ObservableList<TransactionDto> observableList = FXCollections.observableArrayList();

    private TransactionBo transactionBo = (TransactionBo) BoFactory.getBoFactory().getBoType(BoFactory.BoTypes.TRANSACTION);

    public void initialize(){
        loadUnreturnedBooks();
    }

    private void loadUnreturnedBooks() {
        try {
            List<TransactionDto> dtos = transactionBo.getUnreturned(userId);
            for (TransactionDto dto : dtos){
                observableList.add(dto);
            }
            displayUi();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayUi() {
        int row = 0;
        int col =0;
        bookGrid.getRowConstraints().clear();
        bookGrid.getColumnConstraints().clear();
        for (int i =0;i< observableList.size();i++){

            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/User_view/BookCard_form.fxml"));
                AnchorPane pane = loader.load();
                BookCardFormController controller = loader.getController();
                controller.setData(observableList.get(i));
                controller.setLibraryFormController(this);
                if (col==1){
                    col=0;
                    row++;
                }
                bookGrid.add(pane,col++,row);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
