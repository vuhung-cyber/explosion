package bomberman.entities;

import javafx.scene.image.Image;

public abstract class Animated extends Entity{

    protected int _animate = 0;
    protected final int MAX_ANIMATE = 7500; // save animation status

    public Animated(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    protected void animate() {
        if(_animate < MAX_ANIMATE) _animate++; else _animate = 0; // reset animation
    }
}
