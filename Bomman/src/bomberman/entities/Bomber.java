package bomberman.entities;

import bomberman.entities.bomb.Bomb;
import bomberman.entities.bomb.explosion;
import bomberman.entities.tile.Grass;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.awt.*;

import static bomberman.BombermanGame.entities;
import static bomberman.BombermanGame.stillObjects;

public class Bomber extends Move {

    KeyCode key;
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
        setSpeed(2);
    }

    @Override
    public void update() {
        if (!live) {
            img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2
                    , Sprite.player_dead3,10, 30).getFxImage();
        }
       return;
    }

    public void moving(KeyCode key){
        if(key == KeyCode.UP){
            super.moveUp();

        }else if(key == KeyCode.DOWN) {
            super.moveDown();
        } else if(key == KeyCode.LEFT) {
            super.moveLeft();
        } else if(key == KeyCode.RIGHT) {
            super.moveRight();

        }

        if(collision())
            super.move();
    }

    //load anh di chuyen.
    public void move(KeyEvent event) {
        if(        event.getCode() == KeyCode.RIGHT) {
            img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, right++, 60).getFxImage();
        }
        if(event.getCode() == KeyCode.LEFT) {
            img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, left++, 60).getFxImage();
        }
        if(event.getCode() == KeyCode.UP) {
            img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, up++, 60).getFxImage();
        }
        if(event.getCode() == KeyCode.DOWN) {
            img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, down++, 60).getFxImage();
        }
    }

    public void bom(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE) {
            Bomb bomb = new Bomb(_x, _y);
            entities.add(bomb);
        }
    }

}
