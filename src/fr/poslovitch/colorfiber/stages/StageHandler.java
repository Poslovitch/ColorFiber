package fr.poslovitch.colorfiber.stages;

import fr.poslovitch.colorfiber.ColorFiber;
import fr.poslovitch.colorfiber.config.Settings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Map;

public class StageHandler {

    public static Map<String, FXMLLoader> loaders;
    private static Stage currentStage;

    public static void closeCurrentStage() {
        currentStage.close();
    }

    public static void openLoadingStage() {
        try {
            FXMLLoader loader = new FXMLLoader(ColorFiber.class.getResource("/stages/loading.fxml"));
            Parent root = loader.load();
            LoadingController controller = (LoadingController) loader.getController();

            currentStage = new Stage();
            currentStage.setTitle("ColorFiber - Loading");
            currentStage.setScene(new Scene(root));
            currentStage.show();
            controller.launch();
        } catch (Exception e) {
            e.printStackTrace();
            //TODO error report
        }
    }

    public static void openMainStage() {
        try {
            Parent root = loaders.get("main").load();

            currentStage = new Stage();
            currentStage.setTitle("ColorFiber");
            currentStage.setScene(new Scene(root));
            currentStage.show();

            currentStage.setOnCloseRequest((event) -> Settings.save());
        } catch (Exception e) {
            e.printStackTrace();
            //TODO error report
        }
    }
}
