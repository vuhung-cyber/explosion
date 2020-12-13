package bomberman.entities.tile.destroyable;

import bomberman.BombermanGame;
import bomberman.entities.Entity;
import bomberman.entities.tile.Grass;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

import java.awt.*;

import static bomberman.BombermanGame.explosionList;
import static bomberman.BombermanGame.stillObjects;


public class Brick extends Destroyable {

    int count = 0;
    public Brick(int x, int y, Image img) {
        super(x,y,img);
    }

    @Override
    public void update() {
        if(!collisionFlame(this.getRec())) {
            stillObjects.remove(this);
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
