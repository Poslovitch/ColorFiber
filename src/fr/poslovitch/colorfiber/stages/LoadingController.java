package fr.poslovitch.colorfiber.stages;

import fr.poslovitch.colorfiber.ColorFiber;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class LoadingController implements Initializable {

    @FXML
    private Label announcer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void launch() {
        announcer.setText("Loading FXML files...");

        StageHandler.loaders = new HashMap<>();
        try {
            JarFile jar = new JarFile(new File(ColorFiber.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));

            // Loop through all the entries
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String path = entry.getName();

                // Not in the folder
                if (!path.startsWith("stages")) continue;

                String fileName = path.replace("stages/", "").replace(".fxml","");

                if (path.endsWith(".fxml") && fileName.matches("\\w+")) {
                    StageHandler.loaders.put(fileName, new FXMLLoader(ColorFiber.class.getResource("/" + path)));
                    announcer.setText("FXML files: /" + path);
                    System.out.println(fileName + " : /" + path);
                }
            }

            jar.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        announcer.setText("Connecting to Arduino...");

        finish();
    }

    public void finish() {
        StageHandler.closeCurrentStage();
        StageHandler.openMainStage();
    }
}
