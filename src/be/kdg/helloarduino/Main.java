package be.kdg.helloarduino;

import be.kdg.helloarduino.model.SerialArduinoConnection;
import be.kdg.helloarduino.view.SnakeView;
import be.kdg.helloarduino.view.SnakePresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        SerialArduinoConnection connection = new SerialArduinoConnection();
        SnakeView view = new SnakeView();
        new SnakePresenter(connection, view);
        stage.setTitle("Snake by Alex Van Dijck");
        stage.setScene(new Scene(view,400,400));
        stage.show();
        stage.getIcons().add(new Image("Images/strawberry.png"));
    }
}
