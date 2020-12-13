package bomberman.entities;

import bomberman.entities.bomb.Bomb;
import bomberman.entities.tile.Grass;
import bomberman.graphics.Sprite;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Random;

import static bomberman.BombermanGame.*;

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

    //vat 1 va cham vat 2;
    public static boolean collisionEndGame(Rectangle r1, Rectangle r2) {
        if(r1.intersects(r2)) {
            return true;
        }
        return false;
    }

    public static boolean collisionBomb(Rectangle r) {
        for(int i=0; i<entities.size(); i++) {
            if(entities.get(i) instanceof Bomb) {
                if(r.intersects(entities.get(i).getRec())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean collisnEnemy(Rectangle r) {
        for(Entity x : entities) {
            if(!(x instanceof Bomber) && !(x instanceof Bomb)) {
                if(r.intersects(x.getRec())) {
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
