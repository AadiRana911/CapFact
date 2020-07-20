package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.Socket;

public class Main extends Application {
    private static Socket socket;
    @Override
    public void start(Stage primaryStage) {
        try {
            socket = new Socket("localhost", 5000);
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }catch (IOException e){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Error.fxml"));
                primaryStage.setTitle("Hello World");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {launch(args);}

    public static Socket getSocket() {
        return socket;
    }
}
