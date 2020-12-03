
package bomberman.entities.enemy;

import bomberman.entities.Bomber;
import bomberman.entities.Move;
import bomberman.entities.enemy.Enemy;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

import java.util.Random;

public class Oneal extends Enemy {
    Bomber bomber;

    protected int direction;
    Random random = new Random();

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
        if (direction == 0) {
            moveLeft();
            if (collision()) {
                move();
            } else {
                randomDirection();
            }
        } else if (direction == 1) {
            moveRight();
            if (collision()) {
                move();
            } else {
                randomDirection();
            }
        } else if (direction == 2) {
            moveUp();
            if (collision()) {
                move();
            } else {
                randomDirection();
            }
        } else if (direction == 3) {
            moveDown();
            if (collision()) {
                move();
            } else {
                randomDirection();
            }
        }
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, left++, 18).getFxImage();
    }

    @Override
    public void moveRight() {
        super.moveRight();
        img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, right++, 18).getFxImage();

    }

    @Override
    public void moveUp() {
        super.moveUp();
        img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, left++, 18).getFxImage();
    }

    @Override
    public void moveDown() {
        super.moveDown();
        img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, left++, 18).getFxImage();
    }
    public void randomDirection() {
        if(bomber == null)  {
            direction = random.nextInt(4);
        } else {
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
}
