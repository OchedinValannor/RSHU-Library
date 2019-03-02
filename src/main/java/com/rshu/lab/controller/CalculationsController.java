package com.rshu.lab.controller;

import com.rshu.lab.entity.RecordData;
import com.rshu.lab.service.RecordService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class CalculationsController extends Controller {

    @FXML
    private DatePicker issueDatePicker;
    @FXML
    private DatePicker returnDatePicker;

    @FXML
    private TableView<RecordData> recordsTableView;
    @FXML
    private TableColumn<RecordData, Integer> recordID;
    @FXML
    private TableColumn<RecordData, Integer> bookID;
    @FXML
    private TableColumn<RecordData, Integer> readerID;
    @FXML
    private TableColumn<RecordData, String> issueDate;
    @FXML
    private TableColumn<RecordData, String> returnDate;
    @FXML
    private TableColumn<RecordData, Integer> rentSum;

    @FXML
    private Button calculateIncome;
    @FXML
    private Label totalResult;

    private static ObservableList<RecordData> records = FXCollections.observableArrayList();


    @FXML
    private void initialize() {

        recordID.setCellValueFactory(cellData -> cellData.getValue().getRecordIDProp().asObject());
        bookID.setCellValueFactory(cellData -> cellData.getValue().getBookIDProp().asObject());
        readerID.setCellValueFactory(cellData -> cellData.getValue().getReaderIDProp().asObject());
        issueDate.setCellValueFactory(cellData -> cellData.getValue().getIssueDateProp());
        returnDate.setCellValueFactory(cellData -> cellData.getValue().getReturnDateProp());
        rentSum.setCellValueFactory(cellData -> cellData.getValue().getTotalRentProp().asObject());
    }


    private void refreshTableViewAndResult(Date issueDate, Date returnDate) {

        int result;
        totalResult.setText("0");

        if (!records.isEmpty()) {
            records.clear();
        }

        RecordService recordService = getMainApp().getRecordService();
        if (issueDate != null && returnDate != null) {
            records.addAll(recordService.getMetaDataInPeriod(issueDate, returnDate));
            result = recordService.incomeInPeriod(issueDate, returnDate);

        } else if (issueDate != null) {
            records.addAll(recordService.getMetaDataAfterDate(issueDate));
            result = recordService.incomeAfterDate(issueDate);

        } else if (returnDate != null) {
            records.addAll(recordService.getMetaDataBeforeDate(returnDate));
            result = recordService.incomeBeforeDate(returnDate);

        } else {
            records.addAll(recordService.getAllMetaData());
            result = recordService.totalIncome();
        }

        totalResult.setText(result + "");
        recordsTableView.setItems(records);
    }


    @FXML
    public void handleCalculateIncome() {

        Date issueDate = null;
        Date returnDate = null;

        LocalDate issueDatePickerValue = issueDatePicker.getValue();
        if (issueDatePickerValue != null) {
            issueDate = Date.from(issueDatePickerValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
//            issueDate.setDate(issueDate.getDate() + 1);
        }

        LocalDate returnDatePickerValue = returnDatePicker.getValue();
        if (returnDatePickerValue != null) {
            returnDate = Date.from(returnDatePickerValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
            returnDate.setDate(returnDate.getDate() + 1);
        }

        try {
            refreshTableViewAndResult(issueDate, returnDate);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
