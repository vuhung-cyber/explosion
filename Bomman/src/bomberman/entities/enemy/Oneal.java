
package bomberman.entities.enemy;

import bomberman.BombermanGame;
import bomberman.entities.Bomber;
import bomberman.entities.Move;
import bomberman.entities.enemy.Enemy;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Random;

import static bomberman.BombermanGame.entities;
import static bomberman.BombermanGame.explosionList;

public class Oneal extends Enemy {
    Bomber bomber;
    protected int direction;
    private int k = 0;
    public boolean live = true;

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
        setSpeed(1);
        randomDirection();
    }
    public Oneal(int x, int y, Image img, Bomber bomber) {
        super(x, y, img);
        this.bomber = bomber;
        setSpeed(1);
        randomDirection();
    }

    @Override
    public void update() {
        if (live) {
            if (k % 64 == 0) {
                randomDirection();
            }
            if (direction == 0) {
                moveLeft();
            } else if (direction == 1) {

                moveRight();
            } else if (direction == 2) {

                moveUp();
            } else if (direction == 3) {

                moveDown();
            }
            if (collision() && Move.collisionBomb(this.getRec())) {
                move();
            } else {
                randomDirection();
            }
            k++;
        }

        if(!collisionFlame(this.getRec())) {
            this.setImg(Sprite.oneal_dead.getFxImage());
            setSpeed(0);
            BombermanGame.entities.remove(this);
            live = false;
        }
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, left++, 20).getFxImage();
    }

    @Override
    public void moveRight() {
        super.moveRight();
        img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, right++, 20).getFxImage();

    }

    @Override
    public void moveUp() {
        super.moveUp();
        img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, left++, 20).getFxImage();
    }

    @Override
    public void moveDown() {
        super.moveDown();
        img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, left++, 20).getFxImage();
    }
    public void randomDirection() {
        Random random = new Random();
        if(this.collision())  {
            direction = random.nextInt(4);
        }
        else {
            int distanceX = bomber.get_x() - this.get_x();
            int distanceY = bomber.get_y() - this.get_y();
            int k = random.nextInt(2);
            if (k == 0) {
                direction =  distanceX < 0 ? 0 : 1; // 0 trái, 1 phải
            } else {
                direction =  distanceY < 0 ? 2 : 3; // 2 lên, 3 xuống
            }
        }
    }
    public static boolean collisionFlame(Rectangle r) {
        for(int i=0; i<explosionList.size(); i++) {
            if(!explosionList.isEmpty()) {
                if(r.intersects(explosionList.get(i).getRec())) {
                    return false;
                }
            }
        }
        return true;
    }
}
