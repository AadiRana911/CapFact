package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button captextbtn;

    @FXML
    private Button factBtn;

    @FXML
    void moveToCapTextScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CapScreen.fxml"));
        Scene scene = new Scene(root);

        Stage newStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    void moveToFactScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FactScreen.fxml"));
        Scene scene = new Scene(root);

        Stage newStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newStage.setScene(scene);
        newStage.show();
    }
}
