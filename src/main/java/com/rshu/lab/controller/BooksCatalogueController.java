package com.rshu.lab.controller;

import com.rshu.lab.App;
import com.rshu.lab.entity.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BooksCatalogueController extends Controller {

    @FXML
    private TextField textField;

    @FXML
    private TableView<Book> bookTableView;
    @FXML
    private TableColumn<Book, Integer> bookID;
    @FXML
    private TableColumn<Book, String> title;
    @FXML
    private TableColumn<Book, String> author;
    @FXML
    private TableColumn<Book, Integer> pledge;
    @FXML
    private TableColumn<Book, Integer> rentalPrice;
    @FXML
    private TableColumn<Book, String> genre;

    @FXML
    private Button addBook;
    @FXML
    private Button editBook;

    @FXML
    private void initialize() {

        bookID.setCellValueFactory(cellData -> cellData.getValue().getBookIDProp().asObject());
        title.setCellValueFactory(cellData -> cellData.getValue().getTitleProp());
        author.setCellValueFactory(cellData -> cellData.getValue().getAuthorProp());
        pledge.setCellValueFactory(cellData -> cellData.getValue().getPledgeProp().asObject());
        rentalPrice.setCellValueFactory(cellData -> cellData.getValue().getRentalPriceProp().asObject());
        genre.setCellValueFactory(cellData -> cellData.getValue().getGenreProp());
    }

    public void setMainApp(App app) {
        super.setMainApp(app);
        refreshTableView();
    }

    private void refreshTableView() {
        getMainApp().setBooks();
        bookTableView.setItems(getMainApp().getBooks());
    }


    @FXML
    private void searchByText() {
        // TODO: 17.06.2018

        refreshTableView();
    }

    @FXML
    private void handleAddBook() {

        getStage().hide();
        getMainApp().showAddBookDialog();
        getStage().show();

        refreshTableView();
    }

    private Book getSelectedData() {
        return bookTableView.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleEditBook() {

        Book book = getSelectedData();

        if (book != null) {
            getStage().hide();
            getMainApp().showEditBookDialog(book);
            getStage().show();

            refreshTableView();
        }
    }

}
