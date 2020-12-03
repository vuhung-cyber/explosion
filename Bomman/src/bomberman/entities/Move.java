package bomberman.entities;

import bomberman.entities.tile.Grass;
import bomberman.graphics.Sprite;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Random;

import static bomberman.BombermanGame.entities;
import static bomberman.BombermanGame.stillObjects;

public class Move extends Entity {
    int tempX;
    int tempY;
    int speed;
    protected static int right = 0;
    protected static int left = 0;
    protected static int up = 0;
    protected static int down = 0;
    public boolean live;


    public Move(int x, int y, Image img) {
        super(x,y,img);
        live = true;
    }

    public void moveRight() {
        tempX = _x + speed;
        tempY = _y;
    }

    public void moveLeft() {
        tempX = _x - speed;
        tempY = _y;
    }

    public void moveUp() {
        tempY = _y - speed;
        tempX = _x;
    }

    public void moveDown() {
        //System.out.println("yes");
        tempY = _y + speed;
        tempX = _x;
    }

    @Override
    public void update() {};

    public boolean collision() {
        Rectangle rectangle = new Rectangle(tempX, tempY, 26, 26);
        for (Entity x:stillObjects) {
            if (!(x instanceof Grass)) {
                if (rectangle.intersects(x.getRec())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean collisionEnemy() {
        for(Entity x : entities) {
            if(x != entities.get(entities.size() - 1)) {
                if(entities.get(entities.size() - 1).getRec().intersects(x.getRec())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void move() {
        _x = tempX;
        _y = tempY;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
