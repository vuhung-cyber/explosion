package bomberman.entities.bomb;

import bomberman.entities.Entity;
import bomberman.entities.Move;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

public class Bomb extends Move {
    boolean check = false;
    int dem = 0;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update(){
        img = Sprite.movingSprite(Sprite.bomb_1,Sprite.bomb_2, dem++, 10).getFxImage();

    }


}
