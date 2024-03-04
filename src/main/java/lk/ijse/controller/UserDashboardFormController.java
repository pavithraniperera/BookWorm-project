package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserDashboardFormController {

    public AnchorPane pane2;
    public AnchorPane root;
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

        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/User_view/Borrow_book_form.fxml"));
            pane2.getChildren().removeAll();

            pane2.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/User_view/User_dashboard_form.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/User_view/User_history_form.fxml"));
            pane2.getChildren().removeAll();

            pane2.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnLibraryOnAction(ActionEvent event) {
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/User_view/My_library_form.fxml"));
            pane2.getChildren().removeAll();

            pane2.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/view/User_view/User_profile_form.fxml"));
            pane2.getChildren().removeAll();

            pane2.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
