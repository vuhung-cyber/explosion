package bomberman.entities.bomb;
import java.util.List;
import bomberman.BombermanGame;
import bomberman.entities.Entity;
import bomberman.entities.Sound;
import bomberman.entities.tile.Wall;
import bomberman.graphics.Sprite;
import javafx.scene.image.Image;
import java.awt.Rectangle;

public class explosion extends Entity {
    private int left;
    private int right;
    private int top;
    private int down;
    private int power = 1;
    private int size = Sprite.SCALED_SIZE;
    private int direction;
    private int time = 0;

    @Override
    public Rectangle getRec() {
        this.rec = new Rectangle(_x, _y,25,25);
        return this.rec;
    }

    public explosion(int x, int y, Image image, int direction){
        super(x, y);
        this.img = image;
        this.direction = direction;
    }

    public explosion(int x, int y, Image image){
        super(x, y);
        this.img = image;
    }

    public void update(){
        if(time < 20){
            time++;
            setImg();
        }else {
            BombermanGame.explosionList.remove(this);
        }
    }

    public void render_explosion(){
        Right();
        Left();
        Top();
        Down();
        Sound.explosion.play();
        Sound.explosion.seek(Sound.explosion.getStartTime()); // thực hiện trong mỗi lần ấn bom

        creat_explosion();
    }

    private void creat_explosion(){
        BombermanGame.explosionList.add(new explosion(_x, _y, Sprite.explosion_horizontal.getFxImage(),1));
        BombermanGame.explosionList.add(new explosion(_x, _y, Sprite.explosion_vertical.getFxImage(),4));
        for(int i = 0; i < right; i++){
            explosion e = new explosion(_x + size*(i + 1), _y, img);
            if(i == right - 1) {
                e.img = Sprite.explosion_horizontal_right_last.getFxImage();
                e.direction = 2;
            } else{
                e.img = Sprite.explosion_horizontal.getFxImage();
                e.direction = 1;
            }
            BombermanGame.explosionList.add(e);
        }

        for(int i = 0; i < left; i++){
            explosion e = new explosion(_x - size*(i + 1), _y, img);
            if(i == left - 1) {
                e.img = Sprite.explosion_horizontal_left_last.getFxImage();
                e.direction = 3;
            } else{
                e.img = Sprite.explosion_horizontal.getFxImage();
                e.direction = 1;
            }
            BombermanGame.explosionList.add(e);
        }

        for(int i = 0; i < top; i++){
            explosion e = new explosion(_x , _y - size*(i + 1), img);
            if(i == top - 1) {
                e.img = Sprite.explosion_vertical_top_last.getFxImage();
                e.direction = 5;
            } else{
                e.img = Sprite.explosion_vertical.getFxImage();
                e.direction = 4;
            }
            BombermanGame.explosionList.add(e);
        }

        for(int i = 0; i < down; i++){
            explosion e = new explosion(_x, _y + size*(i + 1), img);
            if(i == down - 1) {
                e.img = Sprite.explosion_vertical_down_last.getFxImage();
                e.direction = 6;
            } else{
                e.img = Sprite.explosion_vertical.getFxImage();
                e.direction = 4;
            }
            BombermanGame.explosionList.add(e);
        }
    }
    private void Right() {
        for (int i = 0; i < power; i++) {
            Rectangle ex_right = new Rectangle(_x + size*(i + 1), _y, size, size);
            if (isCollisionsWall(ex_right)) {
                right = i;
                return;
            }
            right = i + 1;
        }
    }

    private void Left() {
        for (int i = 0; i < power; i++) {
            Rectangle ex_left = new Rectangle(_x - size*(i + 1), _y, size, size);
            if (isCollisionsWall(ex_left)) {
                left = i;
                return;
            }
            left = i + 1;
        }
    }

    private void Top() {
        for (int i = 0; i < power; i++) {
            Rectangle ex_top = new Rectangle(_x, _y - size*(i + 1), size, size);
            if (isCollisionsWall(ex_top)) {
                top = i;
                return;
            }
            top = i + 1;
        }
    }

    private void Down() {
        for (int i = 0; i < power; i++) {
            Rectangle ex_right = new Rectangle(_x, _y + size*(i + 1), size, size);
            if (isCollisionsWall(ex_right)) {
                down = i;
                return;
            }
            down = i + 1;
        }
    }
    private static boolean isCollisionsWall(Rectangle r){
        r.setRect(r.x,r.y,25, 25);
        for(Entity e : BombermanGame.stillObjects){
            Rectangle r2 = e.getRec();
            if(r.intersects(r2)){
                if(e instanceof Wall)
                    return true;
            }
        }
        return false;
    }

    private void setImg() {
        switch (direction) {
            case 1:
                img = Sprite.movingSprite(Sprite.explosion_horizontal1
                        ,Sprite.explosion_horizontal2,time,20).getFxImage();
                break;
            case 2:
                img = Sprite.movingSprite(Sprite.explosion_horizontal_right_last1
                        ,Sprite.explosion_horizontal_right_last2,time,20).getFxImage();
                break;
            case 3:
                img = Sprite.movingSprite(Sprite.explosion_horizontal_left_last1
                        ,Sprite.explosion_horizontal_left_last2,time,20).getFxImage();
                break;
            case 4:
                img = Sprite.movingSprite(Sprite.explosion_vertical1
                        ,Sprite.explosion_vertical2,time,20).getFxImage();
                break;
            case 5:
                img = Sprite.movingSprite(Sprite.explosion_vertical_top_last1
                        ,Sprite.explosion_vertical_top_last2,time,20).getFxImage();
                break;
            case 6:
                img = Sprite.movingSprite(Sprite.explosion_vertical_down_last1
                        ,Sprite.explosion_vertical_down_last2,time,20).getFxImage();
                break;
        }
    }
}