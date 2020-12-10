package bomberman.entities;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import bomberman.graphics.Sprite;

import java.awt.*;

//Class Thực Thể bao gồm tất cả các vật trong game:Bomber, Grass, Wall.
public abstract class Entity {

    protected int _x;
    protected int _y;
    protected Image img;//hình ảnh.
    protected Rectangle rec;
    protected boolean _remove = false;


    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this._x = xUnit * Sprite.SCALED_SIZE;
        this._y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    protected Entity(int x, int y) {
        this._x = x;
        this._y = y;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, _x, _y);
    }

    public int get_x() {
        return this._x;
    }

    public int get_y() {
        return this._y;
    }

    public Rectangle getRec() {
        this.rec = new Rectangle(_x, _y,32,32);
        return rec;
    }

    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public abstract void update();

    public boolean isRemove() {
        return _remove;
    }

    public void remove() {
        _remove = true;
    }

}
