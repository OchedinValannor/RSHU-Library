package com.rshu.lab.controller;

import com.rshu.lab.entity.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BookAddEditController extends Controller {

    @FXML
    private TextField title;
    @FXML
    private TextField author;
    @FXML
    private TextField pledge;
    @FXML
    private TextField rentalPrice;
    @FXML
    private TextField genre;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    private Book bookEdit;


    public void setBookToEdit(Book book) {
        this.bookEdit = book;

        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        pledge.setText(book.getPledge() + "");
        rentalPrice.setText(book.getRentalPrice() + "");
        genre.setText(book.getGenre());
    }

    private boolean isAvailable() {
        return title.getText() != null && !title.getText().isEmpty()
                && author.getText() != null && !author.getText().isEmpty()
                && pledge.getText() != null && !pledge.getText().isEmpty()
                && rentalPrice.getText() != null && !rentalPrice.getText().isEmpty()
                && genre.getText() != null && !genre.getText().isEmpty();
    }

    private Book getBook() {
        return new Book(title.getText(), author.getText(),
                Integer.parseInt(pledge.getText()), Integer.parseInt(rentalPrice.getText()), genre.getText());
    }

    @FXML
    private void handleSaveAdd() {

        if (isAvailable()) {
            getMainApp().getBookService().add(getBook());

            getStage().close();
        }
    }

    @FXML
    private void handleSaveEdit() {

        if (isAvailable()) {
            Book book = getBook();
            book.setBookID(bookEdit.getBookID());
            getMainApp().getBookService().update(book);

            getStage().close();
        }
    }

    @FXML
    private void handleCancel() {
        getStage().close();
    }
}
