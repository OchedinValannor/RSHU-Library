package com.rshu.lab.controller;

import com.rshu.lab.App;
import com.rshu.lab.entity.Reader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReadersCatalogueController extends Controller {

    @FXML
    private TextField textField;

    @FXML
    private TableView<Reader> readerTableView;
    @FXML
    private TableColumn<Reader, Integer> readerID;
    @FXML
    private TableColumn<Reader, String> surname;
    @FXML
    private TableColumn<Reader, String> firstName;
    @FXML
    private TableColumn<Reader, String> patronymic;
    @FXML
    private TableColumn<Reader, String> homeAddress;
    @FXML
    private TableColumn<Reader, Integer> phoneNumber;

    @FXML
    private Button addReader;
    @FXML
    private Button editReader;

    @FXML
    private void initialize() {

        readerID.setCellValueFactory(cellData -> cellData.getValue().getReaderIDProp().asObject());
        surname.setCellValueFactory(cellData -> cellData.getValue().getSurnameProp());
        firstName.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProp());
        patronymic.setCellValueFactory(cellData -> cellData.getValue().getPatronymicProp());
        homeAddress.setCellValueFactory(cellData -> cellData.getValue().getHomeAddressProp());
        phoneNumber.setCellValueFactory(cellData -> cellData.getValue().getPhoneNumberProp().asObject());
    }

    public void setMainApp(App app) {
        super.setMainApp(app);
        refreshTableView();
    }

    private void refreshTableView() {
        getMainApp().setReaders();
        readerTableView.setItems(getMainApp().getReaders());
    }


    @FXML
    private void searchByText() {
        // TODO: 17.06.2018

        refreshTableView();
    }
    
    @FXML
    private void handleAddReader() {

        getStage().hide();
        getMainApp().showAddReaderDialog();
        getStage().show();

        refreshTableView();
    }

    private Reader getSelectedData() {
        return readerTableView.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void handleEditReader() {

        Reader reader = getSelectedData();

        if (reader != null) {
            getStage().hide();
            getMainApp().showEditReaderDialog(reader);
            getStage().show();

            refreshTableView();
        }
    }

}
