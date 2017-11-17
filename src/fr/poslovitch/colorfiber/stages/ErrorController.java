package fr.poslovitch.colorfiber.stages;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class ErrorController implements Initializable {

    @FXML
    private Label stacktrace;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void displayStackTrace(Exception e) {
        StringBuilder sb = new StringBuilder();
        Stream.of(e.getStackTrace()).forEach(stack -> sb.append("\n" + stack));
        stacktrace.setText(sb.toString());
    }
}
