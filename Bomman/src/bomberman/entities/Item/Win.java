package bomberman.entities.Item;


import bomberman.BombermanGame;
import bomberman.entities.Entity;
import bomberman.entities.Move;
import bomberman.entities.tile.Tile;
import javafx.scene.image.Image;

import static bomberman.BombermanGame.entities;

public class Win extends Item {

    public Win(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if(Move.collisionEndGame(this.getRec(), entities.get(entities.size()-1).getRec())) {
            if(entities.size() == 1) {
                System.out.println("win");
            }
        }
    }
}

