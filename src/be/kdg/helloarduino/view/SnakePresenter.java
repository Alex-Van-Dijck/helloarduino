package be.kdg.helloarduino.view;

import be.kdg.helloarduino.model.SerialArduinoConnection;
import be.kdg.helloarduino.model.Snake;
import be.kdg.helloarduino.model.Spel;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import javafx.application.Platform;

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

                    spel.overInput(oneByte);
                    drawSnake();

                }
            }
        });
    }

    public void drawSnake(){
        view.getChildren().clear();
        Snake snake = spel.getSnake();
        for(int i = 0; i < snake.getSnakeBodies().size(); i++){
            view.add(view.getHoofd(), snake.getSnakeBodies().get(i).getBodyX(),snake.getSnakeBodies().get(i).getBodyY());
        }
    }
}
