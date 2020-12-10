package bomberman.entities;

import bomberman.entities.tile.destroyable.Destroyable;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.LinkedList;

public class Layer extends Entity {

    protected LinkedList<Entity> _entities = new LinkedList<>();

    public Layer(int x, int y, Image img) {
        super(x, y, img);
    }

    /**public Layer(int x, int y, Entity ... entities) {
        _x = x;
        _y = y;

        for (int i = 0; i < entities.length; i++) {
            _entities.add(entities[i]);
        }
    }*/

    @Override
    public void update() {
        clearRemoved();
    }

    private void clearRemoved() {
        Entity top = getTopEntity();

        if (top.isRemove()) _entities.removeLast();
    }

    public Entity getTopEntity() {
        return _entities.getLast();
    }

}
