package com.rshu.lab;

import com.rshu.lab.controller.*;
import com.rshu.lab.entity.Book;
import com.rshu.lab.entity.Reader;
import com.rshu.lab.entity.Record;
import com.rshu.lab.entity.RecordData;
import com.rshu.lab.service.BookService;
import com.rshu.lab.service.ReaderService;
import com.rshu.lab.service.RecordService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App extends Application {

    private static BookService bookService;
    private static ReaderService readerService;
    private static RecordService recordService;

    private static ObservableList<Book> books = FXCollections.observableArrayList();
    private static ObservableList<Reader> readers = FXCollections.observableArrayList();
    private static ObservableList<RecordData> records = FXCollections.observableArrayList();

    private BorderPane root;
    private Stage primaryStage;


    //Services
    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        App.bookService = bookService;
    }

    public ReaderService getReaderService() {
        return readerService;
    }

    public void setReaderService(ReaderService readerService) {
        App.readerService = readerService;
    }

    public RecordService getRecordService() {
        return recordService;
    }

    public void setRecordService(RecordService recordService) {
        App.recordService = recordService;
    }


    //Data sources
    public ObservableList<Book> getBooks() {
        return books;
    }

    public void setBooks() {
        if (!books.isEmpty()) {
            books.clear();
        }

        books.addAll(bookService.getAll());
    }

    public ObservableList<Reader> getReaders() {
        return readers;
    }

    public void setReaders() {
        if (!readers.isEmpty()) {
            readers.clear();
        }

        readers.addAll(readerService.getAll());
    }

    public ObservableList<RecordData> getRecords() {
        return records;
    }

    public void setRecords(Selections selection) {
        if (!records.isEmpty()) {
            records.clear();
        }

        if (selection == Selections.ALL) {
            records.addAll(recordService.getAllMetaData());
        }
        if (selection == Selections.OPEN) {
            records.addAll(recordService.getUnfinished());
        }
        if (selection == Selections.CLOSED) {
            records.addAll(recordService.getFinished());
        }
    }


    //Stages
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-config.xml");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Library");

        initRootLayout();
        showMainView();
    }


    //Init views
    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/view/root.fxml"));
            root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMainView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/view/main_view.fxml"));
            AnchorPane pane = loader.load();

            root.setCenter(pane);
            MainViewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Controller getController(String viewDirectory, String title,
                                     boolean resizable, Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewDirectory));
        AnchorPane pane = loader.load();

        stage.setTitle(title);
        stage.setResizable(resizable);
        stage.initModality(Modality.WINDOW_MODAL);

        stage.initOwner(primaryStage);
        Scene scene = new Scene(pane);
        stage.setScene(scene);

        return loader.getController();
    }

    public void showRecordAddView() {
        try {
            Stage stage = new Stage();
            RecordAddEditController controller = (RecordAddEditController) getController(
                    "/view/record_add_view.fxml", "New record in journal", false, stage);

            controller.setDialogStage(stage);
            controller.setMainApp(this);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void showRecordEditView(Record record) {
        try {
            Stage stage = new Stage();
            RecordAddEditController controller = (RecordAddEditController) getController(
                    "/view/record_edit_view.fxml", "Edit record in journal", false, stage);

            controller.setDialogStage(stage);
            controller.setMainApp(this);
            controller.setRecordToEdit(record);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void showCalculationsView() {
        try {
            Stage stage = new Stage();
            CalculationsController controller = (CalculationsController) getController(
                    "/view/calculations_view.fxml", "Calculations", false, stage);

            controller.setDialogStage(stage);
            controller.setMainApp(this);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void showReadersCatalogueView() {
        try {
            Stage stage = new Stage();
            ReadersCatalogueController controller = (ReadersCatalogueController) getController(
                    "/view/readers_catalogue_view.fxml", "Readers Catalogue", false, stage);

            controller.setDialogStage(stage);
            controller.setMainApp(this);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void showBooksCatalogueView() {
        try {
            Stage stage = new Stage();
            BooksCatalogueController controller = (BooksCatalogueController) getController(
                    "/view/books_catalogue_view.fxml", "Books Catalogue", false, stage);

            controller.setDialogStage(stage);
            controller.setMainApp(this);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void showAddReaderDialog() {
        try {
            Stage stage = new Stage();
            ReaderAddEditController controller = (ReaderAddEditController) getController(
                    "/view/reader_add_view.fxml", "Add Reader", false, stage);

            controller.setDialogStage(stage);
            controller.setMainApp(this);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void showEditReaderDialog(Reader reader) {
        try {
            Stage stage = new Stage();
            ReaderAddEditController controller = (ReaderAddEditController) getController(
                    "/view/reader_edit_view.fxml", "Edit Reader", false, stage);

            controller.setDialogStage(stage);
            controller.setReaderToEdit(reader);
            controller.setMainApp(this);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void showAddBookDialog() {
        try {
            Stage stage = new Stage();
            BookAddEditController controller = (BookAddEditController) getController(
                    "/view/book_add_view.fxml", "Add Book", false, stage);

            controller.setDialogStage(stage);
            controller.setMainApp(this);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void showEditBookDialog(Book book) {
        try {
            Stage stage = new Stage();
            BookAddEditController controller = (BookAddEditController) getController(
                    "/view/book_edit_view.fxml", "Edit Book", false, stage);

            controller.setDialogStage(stage);
            controller.setBookToEdit(book);
            controller.setMainApp(this);

            stage.showAndWait();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
