package bomberman;

import bomberman.entities.Item.Win;
import bomberman.entities.enemy.Enemy;
import bomberman.entities.tile.Grass;
import bomberman.entities.tile.Wall;
import bomberman.entities.enemy.Balloon;
import bomberman.entities.enemy.Oneal;
import bomberman.entities.tile.destroyable.Brick;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import bomberman.entities.*;
import bomberman.graphics.Sprite;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombermanGame extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;
    /*private static int countRight = 1;
    private static int countLeft = 0;
    private static int countUp = 0;
    private static int countDown = 1;*/
    //private boolean collision = false;


    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> explosionList = new ArrayList<>();
    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static List<Enemy>enemies = new ArrayList<>();  // danh sach cac Enemy

    private final static File map = new File("map.txt");
    public Bomber bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
    private Balloon balloon = new Balloon(25, 7, Sprite.balloon_left1.getFxImage());
    //private Balloon balloon1 = new Balloon(28, 7, Sprite.balloon_left1.getFxImage());
   // private Balloon balloon2 = new Balloon(25, 9, Sprite.balloon_left1.getFxImage());
    private Oneal oneal = new Oneal(10, 5, Sprite.oneal_left1.getFxImage(), bomberman);
    private Oneal oneal1 = new Oneal(15, 9, Sprite.oneal_left1.getFxImage(), bomberman);
    private Oneal oneal2 = new Oneal(7, 7, Sprite.oneal_left1.getFxImage(), bomberman);

    public boolean checkGameStart = false;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // gọi âm thanh background
        Sound.bomberman.play();


        //tạo Label.// toa do và su kien.
        Label labelStart = new Label("Hello");
        labelStart.setLayoutX(50);
        labelStart.setLayoutY(20);
        labelStart.setOnMouseClicked(mouseEvent -> {
            checkGameStart = true;
            System.out.println(checkGameStart);
        });
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();// cái cần phải vẽ.

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);
        root.getChildren().add(labelStart);
        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        //create menu.
        //enemies.add(balloon);

        //enemies.add(oneal);
        //enemies.add(oneal1);
        //enemies.add(oneal2);

        entities.add(balloon);

        entities.add(oneal);
        entities.add(oneal1);
        entities.add(oneal2);
        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                if(checkGameStart) {
                    render();
                    update();
                    labelStart.setVisible(false);
                }
            }
        };
        timer.start();

        createMap();

        entities.add(bomberman);

        scene.setOnKeyPressed(Event->{
            //bomberman.move(Event);
            bomberman.moving(Event.getCode());
            bomberman.bom(Event);
        });
    }


    //tạo map chưa hoàn thiện, thiếu vật phẩm ẩn.
    public void createMap() {
        try {
            Scanner s = new Scanner(map);
            int width = s.nextInt();
            int lenght = s.nextInt();

            s.nextLine();//bo qua dong dau tien
            //doc 14 dong dau cua file txt.
            for(int i = 0; i < 13; i++) {
                String line = s.nextLine();
                for(int j = 0; j < line.length(); j++) {
                    Entity object = null;
                    if (line.charAt(j) == '#') {
                        object = new Wall(j, i, Sprite.wall.getFxImage());
                    }
                    else if (line.charAt(j) == ' ') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                    }
                    else if (line.charAt(j) == '*') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        if(j == 7 && i == i) {
                            object = new Win(j, i, Sprite.portal.getFxImage());
                            stillObjects.add(object);
                        }
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                    } else {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                    }
                    stillObjects.add(object);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("loi load map");
        }
    }

    public void update() {
        for(int i=0; i<stillObjects.size(); i++) {
            stillObjects.get(i).update();
        }

        for(int i = 0; i < entities.size(); i++)
            entities.get(i).update();

        for(int i = 0; i < explosionList.size(); i++)
            explosionList.get(i).update();


    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));

        for(int i = 0; i < entities.size(); i++)
            entities.get(i).render(gc);

        for(int i = 0; i < explosionList.size(); i++)
            explosionList.get(i).render(gc);
    }

}


