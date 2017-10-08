package Game.Classes.Main;

import Game.Classes.Menu.Menu;
import Game.Classes.Menu.MenuGameOver;
import Game.Classes.Menu.MenuPause;
import Game.Classes.Skin.*;
import Game.Classes.Snake.Position;
import Game.Classes.Snake.Snake;
import Game.Classes.Snake.SnakeBlock;
import Game.Classes.Snake.Window;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


public class Main extends Application implements Runnable{
    private int WIDTH;
    private int HEIGHT;

    private int gameHeight;
    private int gameWidth;


    private Thread gameThread;


    private Snake snake;

    private SnakeSkin currentSkin;

    private boolean isOnSound;

    private int speed;

    private int highScore;

    private ArrayList<Object> cofigurations = new ArrayList<>();

    private Stage mainStage;

    private Menu menu;

    private static Main main;

    public Main(int WIDTH,int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }
    public Main(){

    }

    @Override
    public void start(Stage primaryStage){
        main = this;
        this.loadConfig();
        this.mainStage = primaryStage;
        this.mainStage.setTitle("Snakus");
        this.mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/Game/GraphicalResources/OutResources/SnakeIcon.png")));
        //calculeaza pozitita medie
        this.mainStage.setX(500);
        this.mainStage.setY(0);
        this.mainStage.setResizable(false);
        this.WIDTH = 700;
        this.HEIGHT = 620;
        this.menu = new Menu(this);
        this.mainStage.setScene(menu.getScenaMenu());
        this.mainStage.show();






    }
    public void prepareGame(Window window){
        this.mainStage.setScene(window.getMainScene());
        this.snake = new Snake(new SnakeBlock(1,1,window.getGraphicsContext(),Position.CENTER),this.currentSkin,window);
        this.snake.getWindow().getMainScene().setOnKeyPressed(event -> {
            snake.getScoreLabel().setText("Score: " + (snake.getSnakeBody().size()-1)/2);
            int speedy = 1;
            if (snake.getSnakeBody().size() > 1) {
                switch (event.getCode()) {
                    case W :
                        if (this.snake.getFirstSnakeBlock().getPos() != Position.DOWN) {
                            this.snake.getFirstSnakeBlock().setPreviousPos(Position.UP);
                            this.snake.move(speedy);
                        }
                        break;
                    case A:
                        if (this.snake.getFirstSnakeBlock().getPos() != Position.RIGHT) {
                            this.snake.getFirstSnakeBlock().setPreviousPos(Position.LEFT);
                            this.snake.move(speedy);
                        }
                        break;
                    case S:
                        if (this.snake.getFirstSnakeBlock().getPos() != Position.UP) {
                            this.snake.getFirstSnakeBlock().setPreviousPos(Position.DOWN);
                            this.snake.move(speedy);
                        }
                        break;
                    case D:
                        if (this.snake.getFirstSnakeBlock().getPos() != Position.LEFT) {
                            this.snake.getFirstSnakeBlock().setPreviousPos(Position.RIGHT);
                            this.snake.move(speedy);
                        }
                        break;
                    case UP:
                        if (this.snake.getFirstSnakeBlock().getPos() != Position.DOWN) {
                            this.snake.getFirstSnakeBlock().setPreviousPos(Position.UP);
                            this.snake.move(speedy);
                        }
                        break;
                    case LEFT:
                        if (this.snake.getFirstSnakeBlock().getPos() != Position.RIGHT) {
                            this.snake.getFirstSnakeBlock().setPreviousPos(Position.LEFT);
                            this.snake.move(speedy);
                        }
                        break;
                    case DOWN:
                        if (this.snake.getFirstSnakeBlock().getPos() != Position.UP) {
                            this.snake.getFirstSnakeBlock().setPreviousPos(Position.DOWN);
                            this.snake.move(speedy);
                        }
                        break;
                    case RIGHT:
                        if (this.snake.getFirstSnakeBlock().getPos() != Position.LEFT) {
                            this.snake.getFirstSnakeBlock().setPreviousPos(Position.RIGHT);
                            this.snake.move(speedy);
                        }
                        break;
                    case ESCAPE:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.CENTER);
                        MenuPause menuPause = new MenuPause(this.snake.getSnakeSkin().getSkinName());
                        menuPause.getBackToMenuButton().setOnMousePressed(e -> {
                            this.mainStage.setScene(this.menu.getScenaMenu());
                            this.gameThread.stop();
                        });
                        menuPause.getResumeButton().setOnMousePressed(e -> {
                            this.snake.getWindow().getMainStage().setScene(this.snake.getWindow().getMainScene());
                            this.snake.getFirstSnakeBlock().setPos(this.snake.getFirstSnakeBlock().getPreviousPos());
                        });
                        this.snake.getWindow().getMainStage().setScene(menuPause.getScenaMenuPause());
                        break;
                }
            } else {
                switch (event.getCode()) {
                    case W :
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.UP);
                        break;
                    case A:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.LEFT);
                        break;
                    case S:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.DOWN);
                        break;
                    case D:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.RIGHT);
                        break;
                    case UP:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.UP);
                        break;
                    case LEFT:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.LEFT);
                        break;
                    case DOWN:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.DOWN);
                        break;
                    case RIGHT:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.RIGHT);
                        break;
                    case ESCAPE:
                        this.snake.getFirstSnakeBlock().setPreviousPos(Position.CENTER);
                        MenuPause menuPause = new MenuPause(this.snake.getSnakeSkin().getSkinName());
                        menuPause.getBackToMenuButton().setOnMousePressed(e -> {
                            this.mainStage.setScene(this.menu.getScenaMenu());
                            this.gameThread.stop();
                        });
                        menuPause.getResumeButton().setOnMousePressed(e -> {
                            this.snake.getWindow().getMainStage().setScene(this.snake.getWindow().getMainScene());
                            this.snake.getFirstSnakeBlock().setPos(this.snake.getFirstSnakeBlock().getPreviousPos());
                        });
                        this.snake.getWindow().getMainStage().setScene(menuPause.getScenaMenuPause());
                        break;
                }
            }
        });
        this.snake.setIsOnSound(this.isOnSound);


    }



    public synchronized void startGame(){
        if (this.gameThread != null)
            this.gameThread.stop();

        this.gameThread = new Thread(this);
        this.gameThread.start();


    }

    @Override
    public void run() {
        while (this.snake.isAlive()) {
            System.out.println("HEELOO");
            this.snake.move(this.speed);
        }

        Platform.runLater(() -> {
            this.menu.setMenuGameOver(new MenuGameOver());
            this.menu.getLoseButton().fire();
        });


    }

    public static void main(String[] args) {
        launch(args);
        main.pushConfig();
    }

    public void loadVampire(){
        ArrayList<ArrayList<String>> root;
        try{
            InputStream inputStream = Main.class.getResourceAsStream("/Game/SnakeSkins/Vampire/Vampire.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            root = (ArrayList<ArrayList<String>>) objectInputStream.readObject();
            HeadSkin headSkin = new HeadSkin(root.get(0).get(0),root.get(0).get(1),root.get(0).get(2),root.get(0).get(3));
            CurveSkin curveSkin = new CurveSkin(root.get(1).get(0),root.get(1).get(1),root.get(1).get(2),root.get(1).get(3));
            StraightSkin straightSkin = new StraightSkin(root.get(2).get(0),root.get(2).get(1));
            TailSkin tailSkin = new TailSkin(root.get(3).get(0),root.get(3).get(1),root.get(3).get(2),root.get(3).get(3));
            AppleSkin appleSkin = new AppleSkin(root.get(4).get(0));
            BackgroundSkin backgroundSkin = new BackgroundSkin(root.get(5).get(0));
            currentSkin = new SnakeSkin(headSkin,curveSkin,straightSkin,tailSkin,appleSkin,backgroundSkin, "Vampire");
            objectInputStream.close();
            inputStream.close();
        }catch (Exception e){
            System.out.println("Ex la loadVampire");
        }

    }
    private void pushVampire(){
        String s1 = "/Game/SnakeSkins/Vampire/Head/HeadUp.png";
        String s2 = "/Game/SnakeSkins/Vampire/Head/HeadDown.png";
        String s3 = "/Game/SnakeSkins/Vampire/Head/HeadRight.png";
        String s4 = "/Game/SnakeSkins/Vampire/Head/HeadLeft.png";
        HeadSkin headSkin = new HeadSkin(s1,s2,s3,s4);

        String s11 = "/Game/SnakeSkins/Vampire/Curve/CurveUpLeft.png";
        String s22 = "/Game/SnakeSkins/Vampire/Curve/CurveUpRight.png";
        String s33 = "/Game/SnakeSkins/Vampire/Curve/CurveDownLeft.png";
        String s44 = "/Game/SnakeSkins/Vampire/Curve/CurveDownRight.png";
        CurveSkin curveSkin = new CurveSkin(s11,s22,s33,s44);

        String s111 = "/Game/SnakeSkins/Vampire/Body/BodyUd.png";
        String s222 = "/Game/SnakeSkins/Vampire/Body/BodyRl.png";
        StraightSkin straightSkin = new StraightSkin(s111,s222);

        String s1111 = "/Game/SnakeSkins/Vampire/Tail/TailUp.png";
        String s2222 = "/Game/SnakeSkins/Vampire/Tail/TailDown.png";
        String s3333 = "/Game/SnakeSkins/Vampire/Tail/TailRight.png";
        String s4444 = "/Game/SnakeSkins/Vampire/Tail/TailLeft.png";
        TailSkin tailSkin = new TailSkin(s1111,s2222,s3333,s4444);

        String s5 = "/Game/SnakeSkins/Vampire/Apple/Apple.png";
        AppleSkin appleSkin = new AppleSkin(s5);

        BackgroundSkin backgroundSkin = new BackgroundSkin("/Game/SnakeSkins/Vampire/Background/Background.png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Vampire.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ArrayList<ArrayList<String>> root = new ArrayList<>();
            root.add(headSkin.getImagePaths());
            root.add(curveSkin.getImagePaths());
            root.add(straightSkin.getImagePaths());
            root.add(tailSkin.getImagePaths());
            root.add(appleSkin.getImagePaths());
            root.add(backgroundSkin.getImagePaths());
            objectOutputStream.writeObject(root);
            objectOutputStream.flush();
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            System.out.println("ex la pushVampire");
        }

    }

    private  void loadConfig() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./Configurations/Config.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            cofigurations = (ArrayList<Object>) objectInputStream.readObject();
        }catch (Exception ex){
            cofigurations = new ArrayList<>();
            cofigurations.add("Default");
            cofigurations.add(true);
            cofigurations.add("Normal");
            cofigurations.add(1);
        }
            String skin = (String) cofigurations.get(0);
            Boolean isOnSound = (Boolean) cofigurations.get(1);
            String difficultyLevel = (String) cofigurations.get(2);
            Integer highScore = (Integer) cofigurations.get(3);
            if (skin != null) {
                if (skin.equals("Batman"))
                    loadBat();
                else if (skin.equals("Default"))
                    loadDefault();
                else if (skin.equals("Vampire"))
                    loadVampire();
            } else
                loadDefault();
            if (difficultyLevel != null)
                switch (difficultyLevel) {
                    case "Easy":
                        speed = 135;
                        break;
                    case "Normal":
                        speed = 105;
                        break;
                    case "Hard":
                        speed = 70;
                        break;
                    case "Impossible":
                        speed = 35;
                        break;
                }
            else
                speed = 135;
            if (isOnSound != null)
                this.isOnSound = isOnSound;
            else
                this.isOnSound = true;
            if (highScore != null)
                this.highScore = highScore;
            else
                this.highScore = 1;
    }

    public void pushConfig(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./Configurations/Config.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            cofigurations = new ArrayList<>();
            cofigurations.add(currentSkin.getSkinName());
            cofigurations.add(isOnSound);
            switch (speed) {
                case 135:
                    cofigurations.add("Easy");
                    break;
                case 105:
                    cofigurations.add("Normal");
                    break;
                case 70:
                    cofigurations.add("Hard");
                    break;
                case 35:
                    cofigurations.add("Insane");
                    break;
                default:
                    cofigurations.add("Easy");
                    break;
            }
            cofigurations.add(highScore);
            objectOutputStream.writeObject(cofigurations);
            objectOutputStream.flush();
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
            } catch (Exception e){
            }

    }
    public void loadBat(){
        ArrayList<ArrayList<String>> root;
        try{
            InputStream inputStream = Main.class.getResourceAsStream("/Game/SnakeSkins/BatMan/BatMan.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            root = (ArrayList<ArrayList<String>>) objectInputStream.readObject();
            HeadSkin headSkin = new HeadSkin(root.get(0).get(0),root.get(0).get(1),root.get(0).get(2),root.get(0).get(3));
            CurveSkin curveSkin = new CurveSkin(root.get(1).get(0),root.get(1).get(1),root.get(1).get(2),root.get(1).get(3));
            StraightSkin straightSkin = new StraightSkin(root.get(2).get(0),root.get(2).get(1));
            TailSkin tailSkin = new TailSkin(root.get(3).get(0),root.get(3).get(1),root.get(3).get(2),root.get(3).get(3));
            AppleSkin appleSkin = new AppleSkin(root.get(4).get(0),root.get(4).get(1),root.get(4).get(2),root.get(4).get(3));
            BackgroundSkin backgroundSkin = new BackgroundSkin(root.get(5).get(0));
            currentSkin = new SnakeSkin(headSkin,curveSkin,straightSkin,tailSkin,appleSkin,backgroundSkin, "Batman");
            objectInputStream.close();
            inputStream.close();
        }catch (Exception e){
            System.out.println("Ex la loadbat");
        }
    }
    public void loadDefault(){

        try {
            ArrayList<ArrayList<String>> root;
            InputStream inputStream = Main.class.getResourceAsStream("/Game/SnakeSkins/Default/Default.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            root = (ArrayList<ArrayList<String>>) objectInputStream.readObject();
            HeadSkin headSkin = new HeadSkin(root.get(0).get(0),root.get(0).get(1),root.get(0).get(2),root.get(0).get(3));
            CurveSkin curveSkin = new CurveSkin(root.get(1).get(0),root.get(1).get(1),root.get(1).get(2),root.get(1).get(3));
            StraightSkin straightSkin = new StraightSkin(root.get(2).get(0),root.get(2).get(1));
            TailSkin tailSkin = new TailSkin(root.get(3).get(0),root.get(3).get(1),root.get(3).get(2),root.get(3).get(3));
            AppleSkin appleSkin = new AppleSkin(root.get(4).get(0));
            BackgroundSkin backgroundSkin = new BackgroundSkin(root.get(5).get(0));
            currentSkin = new SnakeSkin(headSkin,curveSkin,straightSkin,tailSkin,appleSkin,backgroundSkin, "Default");
            objectInputStream.close();
            inputStream.close();
        } catch (Exception e) {
        }
    }


    public void pushBat(){
        String s1 = "/Game/SnakeSkins/BatMan/Head/HeadUp.png";
        String s2 = "/Game/SnakeSkins/BatMan/Head/HeadDown.png";
        String s3 = "/Game/SnakeSkins/BatMan/Head/HeadRight.png";
        String s4 = "/Game/SnakeSkins/BatMan/Head/HeadLeft.png";
        HeadSkin headSkin = new HeadSkin(s1,s2,s3,s4);

        String s11 = "/Game/SnakeSkins/BatMan/Curve/CurveUpLeft.png";
        String s22 = "/Game/SnakeSkins/BatMan/Curve/CurveUpRight.png";
        String s33 = "/Game/SnakeSkins/BatMan/Curve/CurveDownLeft.png";
        String s44 = "/Game/SnakeSkins/BatMan/Curve/CurveDownRight.png";
        CurveSkin curveSkin = new CurveSkin(s11,s22,s33,s44);

        String s111 = "/Game/SnakeSkins/BatMan/Body/BodyUd.png";
        String s222 = "/Game/SnakeSkins/BatMan/Body/BodyRl.png";
        StraightSkin straightSkin = new StraightSkin(s111,s222);

        String s1111 = "/Game/SnakeSkins/BatMan/Tail/TailUp.png";
        String s2222 = "/Game/SnakeSkins/BatMan/Tail/TailDown.png";
        String s3333 = "/Game/SnakeSkins/BatMan/Tail/TailRight.png";
        String s4444 = "/Game/SnakeSkins/BatMan/Tail/TailLeft.png";
        TailSkin tailSkin = new TailSkin(s1111,s2222,s3333,s4444);

        String s5 = "/Game/SnakeSkins/BatMan/Apple/Bane Head.png";
        String s6 = "/Game/SnakeSkins/BatMan/Apple/HarleyHead.png";
        String s7 = "/Game/SnakeSkins/BatMan/Apple/Joker Head.png";
        String s8 = "/Game/SnakeSkins/BatMan/Apple/Joker Head 2.png";
        AppleSkin appleSkin = new AppleSkin(s5,s6,s7,s8);

        BackgroundSkin backgroundSkin = new BackgroundSkin("/Game/SnakeSkins/BatMan/Background/Background.png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("BatMan.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ArrayList<ArrayList<String>> root = new ArrayList<>();
            root.add(headSkin.getImagePaths());
            root.add(curveSkin.getImagePaths());
            root.add(straightSkin.getImagePaths());
            root.add(tailSkin.getImagePaths());
            root.add(appleSkin.getImagePaths());
            root.add(backgroundSkin.getImagePaths());
            objectOutputStream.writeObject(root);
            objectOutputStream.flush();
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            System.out.println("ex la pushBat");
        }
    }

    public static void pushDefault(){
        String s2 = "/Game/SnakeSkins/Default/Head/HeadUp.png";
        String s1 = "/Game/SnakeSkins/Default/Head/HeadDown.png";
        String s4 = "/Game/SnakeSkins/Default/Head/HeadRight.png";
        String s3 = "/Game/SnakeSkins/Default/Head/HeadLeft.png";
        HeadSkin headSkin = new HeadSkin(s1,s2,s3,s4);

        String s11 = "/Game/SnakeSkins/Default/Curve/CurveUpLeft.png";
        String s22 = "/Game/SnakeSkins/Default/Curve/CurveUpRight.png";
        String s33 = "/Game/SnakeSkins/Default/Curve/CurveDownLeft.png";
        String s44 = "/Game/SnakeSkins/Default/Curve/CurveDownRight.png";
        CurveSkin curveSkin = new CurveSkin(s11,s22,s33,s44);

        String s111 = "/Game/SnakeSkins/Default/Body/BodyUd.png";
        String s222 = "/Game/SnakeSkins/Default/Body/BodyRl.png";
        StraightSkin straightSkin = new StraightSkin(s111,s222);

        String s1111 = "/Game/SnakeSkins/Default/Tail/TailUp.png";
        String s2222 = "/Game/SnakeSkins/Default/Tail/TailDown.png";
        String s3333 = "/Game/SnakeSkins/Default/Tail/TailRight.png";
        String s4444 = "/Game/SnakeSkins/Default/Tail/TailLeft.png";
        TailSkin tailSkin = new TailSkin(s1111,s2222,s3333,s4444);

        String s5 = "/Game/SnakeSkins/Default/Apple/Apple.png";
        AppleSkin appleSkin = new AppleSkin(s5);

        BackgroundSkin backgroundSkin = new BackgroundSkin("/Game/SnakeSkins/Default/Background/Background.png");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Default.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ArrayList<ArrayList<String>> root = new ArrayList<>();
            root.add(headSkin.getImagePaths());
            root.add(curveSkin.getImagePaths());
            root.add(straightSkin.getImagePaths());
            root.add(tailSkin.getImagePaths());
            root.add(appleSkin.getImagePaths());
            root.add(backgroundSkin.getImagePaths());
            objectOutputStream.writeObject(root);
            objectOutputStream.flush();
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            System.out.println("ex la pushBat");
        }


    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public SnakeSkin getCurrentSkin() {
        return currentSkin;
    }

    public void setCurrentSkin(SnakeSkin currentSkin) {
        this.currentSkin = currentSkin;
    }

    public boolean isOnSound() {
        return isOnSound;
    }

    public void setOnSound(boolean onSound) {
        isOnSound = onSound;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public ArrayList<Object> getCofigurations() {
        return cofigurations;
    }

    public void setCofigurations(ArrayList<Object> cofigurations) {
        this.cofigurations = cofigurations;
    }

    public Snake getSnake() {
        return snake;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
