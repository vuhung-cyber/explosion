package bomberman.entities.enemy;

import bomberman.entities.Move;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Random;

// balloon di chuyển ngẫu nhiên di chuyển với vận tốc cố định

public class Balloon extends Enemy {

    public static int k = 0;
    protected int direction;
    public Balloon(int x, int y, Image img) {
        super(x, y, img);
        setSpeed(1);
        randomDirection();
    }

    @Override
    public Rectangle getRec(){
        this.rec = new Rectangle(_x, _y,25,25);
        return this.rec;
    }

    @Override
    public void update() {
        if (k % 100 == 0) {
            randomDirection();
        }
         if (live) {
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
         }
         k++;
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        img = Sprite.movingSprite(Sprite.balloon_left1, Sprite.balloon_left1, Sprite.balloon_left2, left++, 60).getFxImage();
    }

    @Override
    public void moveRight() {
        super.moveRight();
        img = Sprite.movingSprite(Sprite.balloon_right1, Sprite.balloon_right2, Sprite.balloon_right3, right++, 60).getFxImage();
    }

    @Override
    public void moveDown() {
        super.moveDown();
        img = Sprite.movingSprite(Sprite.balloon_right1, Sprite.balloon_right2, Sprite.balloon_right3, right++, 60).getFxImage();
    }

    @Override
    public void moveUp() {
        super.moveUp();
        img = Sprite.movingSprite(Sprite.balloon_right1, Sprite.balloon_right2, Sprite.balloon_right3, right++, 60).getFxImage();
    }
    public void randomDirection() {
        Random random = new Random();
        direction = random.nextInt(4);
    }
}
