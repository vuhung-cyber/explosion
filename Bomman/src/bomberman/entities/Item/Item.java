package bomberman.entities.Item;

import bomberman.entities.Entity;
import javafx.scene.image.Image;

public abstract class Item extends Entity {

    public Item(int x, int y, Image img) {
        super(x, y, img);
    }
    @Override
    public void update() {

    }

}
