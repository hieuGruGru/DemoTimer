package com.example.timerdemo;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.net.URL;

public class Controller implements EventHandler<KeyEvent> {

    boolean moveRight = false, moveLeft = false, moveUp = false, moveDown = false;
    private static final int DX = 1, DY = 1;

    @FXML
    ImageView Character;
    @FXML
    Button startBtn;

    @FXML
    void initialize(){
        String path = "/com/example/timerdemo/map@.png";
        URL imageUrl = getClass().getResource(path);
        Image image = new Image(imageUrl.toExternalForm());
        Character.setImage(image); //initialize image view
    }

    @FXML
    void start(){

        Character.getScene().setOnKeyPressed(this);  //add Key press and release handlers to scene
        Character.getScene().setOnKeyReleased(this);

        //construct and invoke AnimationTimer
        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long now) {
                move();  //repeatedly invoke move
            }
        };
        timer.start();

        startBtn.setDisable(true);
    }

    @Override
    public void handle(KeyEvent e) {
        moveRight = false; moveLeft = false;  moveUp = false; moveDown = false;
        //change movement directions based on key events
        switch (e.getCode()) {
            case UP:
                moveUp = true;
                break;
            case LEFT:
                moveLeft = true;
                break;
            case RIGHT:
                moveRight = true;
                break;
            case DOWN:
                moveDown = true;
                break;
        }
    }

    //move if any of the direction control booleans is true
    private void move() {
        if(moveLeft) {
            Character.setLayoutX(Character.getLayoutX()-DX);
        }else  if(moveRight) {
            Character.setLayoutX(Character.getLayoutX()+DX);
        }else if(moveDown) {
            Character.setLayoutY(Character.getLayoutY()+DY);
        }else if(moveUp) {
            Character.setLayoutY(Character.getLayoutY()-DY);
        }
    }
}