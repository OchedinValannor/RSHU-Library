package com.rshu.lab.controller;

import com.rshu.lab.entity.Reader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ReaderAddEditController extends Controller {
    @FXML
    private TextField surname;
    @FXML
    private TextField firstName;
    @FXML
    private TextField patronymic;
    @FXML
    private TextField homeAddress;
    @FXML
    private TextField phoneNumber;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    private Reader readerEdit;


    public void setReaderToEdit(Reader reader) {
        this.readerEdit = reader;

        surname.setText(reader.getSurname());
        firstName.setText(reader.getFirstName());
        patronymic.setText(reader.getPatronymic());
        homeAddress.setText(reader.getHomeAddress());
        phoneNumber.setText(reader.getPhoneNumber() + "");
    }

    private boolean isAvailable() {
        return surname.getText() != null && !surname.getText().isEmpty()
                && firstName.getText() != null && !firstName.getText().isEmpty()
                && patronymic.getText() != null && !patronymic.getText().isEmpty()
                && homeAddress.getText() != null && !homeAddress.getText().isEmpty()
                && phoneNumber.getText() != null && !phoneNumber.getText().isEmpty();
    }

    private Reader getReader() {
        return new Reader(surname.getText(), firstName.getText(),
                patronymic.getText(), homeAddress.getText(), Integer.parseInt(phoneNumber.getText()));
    }

    @FXML
    private void handleSaveAdd() {

        if (isAvailable()) {
            getMainApp().getReaderService().add(getReader());

            getStage().close();
        }
    }

    @FXML
    private void handleSaveEdit() {

        if (isAvailable()) {
            Reader reader = getReader();
            reader.setReaderID(readerEdit.getReaderID());
            getMainApp().getReaderService().update(reader);

            getStage().close();
        }
    }

    @FXML
    private void handleCancel() {
        getStage().close();
    }
}
