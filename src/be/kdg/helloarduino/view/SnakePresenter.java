package be.kdg.helloarduino.view;

import be.kdg.helloarduino.model.SerialArduinoConnection;
import be.kdg.helloarduino.model.Snake;
import be.kdg.helloarduino.model.Spel;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class SnakePresenter implements SerialPortDataListener {
    private SerialArduinoConnection model;
    private SnakeView view;
    private Spel spel;
    private Snake snake;

    public SnakePresenter(SerialArduinoConnection model, SnakeView view) {
        this.model = model;
        this.view = view;
        this.spel = new Spel();
        addEventListeners();
        model.addDatalistener(this);
    }

    private void addEventListeners() {

    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
            return;
        }


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (byte oneByte : model.receiveBytes()) {

                    if(!spel.isGetoond()){
                        if(!spel.isKlaar()) {
                            spel.overInput(oneByte);
                            drawSnake();
                        }else{
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setHeaderText("Het spel is afgelopen!");
                            spel.setGetoond(true);
                            alert.showAndWait();
                        }
                    }




                    if(spel.isScore()){
                        model.sendString("S");
                        spel.setScore(false);
                    }

                }
            }
        });
    }

    public void drawSnake(){
        view.getChildren().clear();
        Snake snake = spel.getSnake();

        try {
            for (int i = 0; i < snake.getSnakeBodies().size(); i++) {
                if(snake.getSnakeBodies().get(i).getBodyX() < 19 || snake.getSnakeBodies().get(i).getBodyY() < 19){
                    view.add(view.getHoofd(), snake.getSnakeBodies().get(i).getBodyX(), snake.getSnakeBodies().get(i).getBodyY());
                }
            }
        }catch (IllegalArgumentException ex){
            System.out.println("De slang is buiten het speelveld dus het spel is afgelopen.");
        }
        view.add(view.getPunt(), spel.getFruit().getBodyX(),spel.getFruit().getBodyY());
    }
}
