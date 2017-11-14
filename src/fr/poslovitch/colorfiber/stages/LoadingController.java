package fr.poslovitch.colorfiber.stages;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingController implements Initializable {

    @FXML
    private Label announcer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void launch() {
        announcer.setText("Hi!");
        finish();
    }

    public void finish() {
        StageHandler.closeCurrentStage();
        StageHandler.openMainStage();
    }
}
