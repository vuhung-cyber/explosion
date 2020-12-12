package bomberman.entities;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {
    public static Media m1 = new Media(new File("res/sounds/bomberman.wav").toURI().toString());
    public static MediaPlayer bomberman = new MediaPlayer(m1);

    public static Media m2 = new Media(new File("res/sounds/bomb.wav").toURI().toString());
    public static MediaPlayer bomb = new MediaPlayer(m2);

    public static Media m3 = new Media(new File("res/sounds/explosion.wav").toURI().toString());
    public static MediaPlayer explosion = new MediaPlayer(m3);

    public static Media m4 = new Media(new File("res/sounds/die.wav").toURI().toString());
    public static MediaPlayer die = new MediaPlayer(m4);



}
