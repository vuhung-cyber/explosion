package bomberman.entities.bomb;

import bomberman.BombermanGame;
import bomberman.entities.Entity;
import bomberman.entities.Move;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

public class Bomb extends Entity {
    boolean check = false;
    int dem = 0;
    explosion explosion = new explosion(_x, _y , Sprite.bomb_1.getFxImage());
    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    public Bomb(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(){
        if(dem < 50)
            img = Sprite.movingSprite(Sprite.bomb_1,Sprite.bomb_2, dem++, 50).getFxImage();
        else {
            explosion.render_explosion();
            BombermanGame.entities.remove(this);
        }
    }


}
