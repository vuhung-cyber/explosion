package bomberman.entities;

import bomberman.entities.bomb.Bomb;
import bomberman.entities.bomb.explosion;
import bomberman.entities.enemy.Enemy;
import bomberman.entities.tile.Grass;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.awt.*;
import java.io.File;

import static bomberman.BombermanGame.*;

public class Bomber extends Move {

    /*KeyCode key;
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
    }*/
    KeyCode key;
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
        setSpeed(3);
    }

    @Override
    public Rectangle getRec() {
        this.rec = new Rectangle(_x, _y, 25, 25);
        return this.rec;
    }

    @Override
    public void update() {
        if(Move.collisnEnemy(this.getRec())) {
            live = false;
            img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2
                    , Sprite.player_dead3,10, 30).getFxImage();
            setSpeed(0);
        }
        collisionEnemy();
        if (!live) {
            img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2
                    , Sprite.player_dead3,10, 30).getFxImage();
            setSpeed(0);
        }
    }

    public void moving(KeyCode key){
        if (key == KeyCode.UP){
            goUp();
        } else if(key == KeyCode.DOWN) {
            goDown();
        } else if(key == KeyCode.LEFT) {
            goLeft();
        } else if(key == KeyCode.RIGHT) {
            goRight();
        }
        if (collision()) super.move();
    }

    public void goLeft() {
        super.moveLeft();
        img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, left++, 30).getFxImage();
    }

    public void goRight() {
        super.moveRight();
        img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, right++, 30).getFxImage();
    }

    public void goUp() {
        super.moveUp();
        img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, up++, 30).getFxImage();
    }

    public void goDown() {
        super.moveDown();
        img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, down++, 30).getFxImage();
    }
   public void collisionEnemy() {
       for (int i=0; i<explosionList.size(); i++) {
           if(Move.collisionEndGame(this.getRec(), explosionList.get(i).getRec())) {
               this.live = false;
           }
       }
   }

    public void bom(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE) {
            Bomb bomb = new Bomb(_x, _y);
            entities.add(bomb);
        }
    }

}
