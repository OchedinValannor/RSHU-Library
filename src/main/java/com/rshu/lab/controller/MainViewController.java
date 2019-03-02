package com.rshu.lab.controller;

import com.rshu.lab.App;
import com.rshu.lab.Selections;
import com.rshu.lab.entity.Record;
import com.rshu.lab.entity.RecordData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainViewController extends Controller {

    //Table
    @FXML private TableView<RecordData> recordsTableView;
    @FXML private TableColumn<RecordData, Integer> recordID;
    @FXML private TableColumn<RecordData, String> book;
    @FXML private TableColumn<RecordData, String> reader;
    @FXML private TableColumn<RecordData, String> issueDate;
    @FXML private TableColumn<RecordData, String> returnDate;

    //Selections
    @FXML private Button allButton;
    @FXML private Button openButton;
    @FXML private Button closedButton;
    //Actions
    @FXML private Button newRecordButton;
    @FXML private Button updateRecordButton;
    @FXML private Button calculationsButton;
    //Catalogues
    @FXML private Button readersButton;
    @FXML private Button booksButton;

//    private App app;

    @FXML
    private void initialize() {

        recordID.setCellValueFactory(cellData -> cellData.getValue().getRecordIDProp().asObject());
        book.setCellValueFactory(cellData -> cellData.getValue().getTitleProp());
        reader.setCellValueFactory(cellData -> cellData.getValue().getSurnameProp());
        issueDate.setCellValueFactory(cellData -> cellData.getValue().getIssueDateProp());
        returnDate.setCellValueFactory(cellData -> cellData.getValue().getReturnDateProp());
    }

    public void setMainApp(App app) {
        super.setMainApp(app);
        refreshTableView(Selections.ALL);
    }

    private void refreshTableView(Selections selection) {
        getMainApp().setRecords(selection);
        recordsTableView.setItems(getMainApp().getRecords());
    }

    private RecordData getSelectedData() {
        return recordsTableView.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleAllButton() {
        refreshTableView(Selections.ALL);
    }

    @FXML
    private void handleOpenButton() {
        refreshTableView(Selections.OPEN);
    }

    @FXML
    private void handleClosedButton() {
        refreshTableView(Selections.CLOSED);
    }

    @FXML
    private void handleNewRecordButton() {

        getMainApp().showRecordAddView();
        refreshTableView(Selections.ALL);
    }

    @FXML
    private void handleUpdateRecordButton() {
        RecordData recordData = getSelectedData();

        if (recordData != null) {
            Record record = getMainApp().getRecordService().getByID(recordData.getRecordID());
            getMainApp().showRecordEditView(record);
            refreshTableView(Selections.ALL);
        }
    }

    @FXML
    private void handleCalculationsButton() {
        getMainApp().showCalculationsView();
    }

    @FXML
    private void handleReadersButton(){
        getMainApp().showReadersCatalogueView();
    }

    @FXML
    private void handleBooksButton(){
        getMainApp().showBooksCatalogueView();
    }
}
