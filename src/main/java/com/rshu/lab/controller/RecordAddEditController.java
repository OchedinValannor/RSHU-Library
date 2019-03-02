package com.rshu.lab.controller;

import com.rshu.lab.App;
import com.rshu.lab.entity.Record;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class RecordAddEditController extends Controller {

    @FXML private ChoiceBox<String> readersChoiceBox = new ChoiceBox<>();
    @FXML private ChoiceBox<String> booksChoiceBox = new ChoiceBox<>();
    @FXML private DatePicker returnDatePicker;

    @FXML private Button saveAdd;
    @FXML private Button saveEdit;
    @FXML private Button cancel;

    private Record recordEdit;

    public void setRecordToEdit(Record record) {
        this.recordEdit = record;
    }

    @Override
    public void setMainApp(App app) {
        super.setMainApp(app);
        readersChoiceBox.getItems().addAll(getMainApp().getReaderService().getStrings());
        booksChoiceBox.getItems().addAll(getMainApp().getBookService().getStrings());
    }

    @FXML
    private void handleSaveAdd() {
        String readersChoiceBoxValue = readersChoiceBox.getValue();
        String booksChoiceBoxValue = booksChoiceBox.getValue();
        LocalDate returnDatePickerValue = returnDatePicker.getValue();

        if (readersChoiceBoxValue != null && !readersChoiceBoxValue.isEmpty()
                && booksChoiceBoxValue != null && !booksChoiceBoxValue.isEmpty()
                && returnDatePickerValue != null && returnDatePickerValue.isAfter(LocalDate.now())) {

            int readerID = Integer.parseInt(readersChoiceBoxValue.split(":")[0]);
            int bookID = Integer.parseInt(booksChoiceBoxValue.split(":")[0]);
            Date returnDate = Date.from(returnDatePickerValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
            returnDate.setDate(returnDate.getDate() + 1);

            Record newRecord = new Record(bookID, readerID, new Date(), returnDate);
            getMainApp().getRecordService().add(newRecord);

            getStage().close();
        }
    }

    @FXML
    private void handleSaveEdit() {
        LocalDate returnDatePickerValue = returnDatePicker.getValue();

        if (returnDatePickerValue != null && returnDatePickerValue.isAfter(LocalDate.now())) {

            Date returnDate = Date.from(returnDatePickerValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
            returnDate.setDate(returnDate.getDate() + 1);

            recordEdit.setReturnDate(returnDate);
            getMainApp().getRecordService().update(recordEdit);

            getStage().close();
        }
    }

    @FXML
    private void handleCancel() {
        getStage().close();
    }
}
