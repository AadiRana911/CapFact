package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CapScreen {

    @FXML
    private TextArea question;

    @FXML
    private TextArea answer;

    @FXML
    void capitalize(ActionEvent event) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(Main.getSocket().getInputStream()));
            PrintWriter out = new PrintWriter(Main.getSocket().getOutputStream(), true);
            out.println("1," + question.getText());
            String response = in.readLine();
            answer.setText(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void backToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);

        Stage newStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newStage.setScene(scene);
        newStage.show();
    }

}
