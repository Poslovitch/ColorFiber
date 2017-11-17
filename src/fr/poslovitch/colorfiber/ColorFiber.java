package fr.poslovitch.colorfiber;

import fr.poslovitch.colorfiber.config.Settings;
import fr.poslovitch.colorfiber.stages.StageHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class ColorFiber extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageHandler.openLoadingStage();
        Settings.save();
    }
}
