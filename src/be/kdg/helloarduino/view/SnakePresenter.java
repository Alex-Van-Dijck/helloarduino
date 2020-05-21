package be.kdg.helloarduino.view;

import be.kdg.helloarduino.model.SerialArduinoConnection;
import be.kdg.helloarduino.model.SnakeModel;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SnakePresenter implements SerialPortDataListener {
    private SerialArduinoConnection model;
    private SnakeView view;
    private SnakeModel snakeModel;

    public SnakePresenter(SerialArduinoConnection model, SnakeView view) {
        this.model = model;
        this.view = view;
        this.snakeModel = new SnakeModel();
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

                    if(!snakeModel.isKlaar()) {
                        if ((char) oneByte == 'T') {

                            System.out.println(snakeModel.getRichting());
                            switch(snakeModel.getRichting()){
                                case 0:
                                    view.beweegVooruit();
                                    break;
                                case 1:
                                    view.beweegLinks();
                                    break;
                                case 2:
                                    view.beweegOnder();
                                    break;
                                case 3:
                                    view.beweegRechts();
                                    break;
                            }

                        }else{

                            snakeModel.input((char)oneByte);

                        }
                    }
                }
            }
        });
    }
}
