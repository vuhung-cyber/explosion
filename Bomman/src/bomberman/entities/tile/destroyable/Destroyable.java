package bomberman.entities.tile.destroyable;

import bomberman.entities.tile.Tile;
import javafx.scene.image.Image;

// doi tuong co the pha huu
public class Destroyable extends Tile {

    private final int MAX_ANIMATE = 7500;
    private int _animate = 0;
    protected boolean _destroyed = false;
    protected int _timeToDisappear = 20;

    public Destroyable(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if (_destroyed) {
            if(_animate < MAX_ANIMATE) _animate++;
            else _animate = 0;

            if(_timeToDisappear > 0) _timeToDisappear--;
            else remove();
        }
    }

    public void destroy() {
        _destroyed = true;
    }
}
