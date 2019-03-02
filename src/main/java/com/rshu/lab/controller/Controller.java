package com.rshu.lab.controller;

import com.rshu.lab.App;
import javafx.stage.Stage;

public abstract class Controller {

    private App app;
    private Stage stage;

    public App getMainApp() {
        return app;
    }

    public void setMainApp(App app) {
        this.app = app;
    }

    public Stage getStage() {
        return stage;
    }

    public void setDialogStage(Stage stage) {
        this.stage = stage;
    }
}
