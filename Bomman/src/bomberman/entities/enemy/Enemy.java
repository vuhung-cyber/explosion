package bomberman.entities.enemy;

import bomberman.entities.Move;
import javafx.scene.image.Image;


public abstract class Enemy extends Move {

    public Enemy(int x, int y, Image img) {
        super(x, y, img);
    }

}
