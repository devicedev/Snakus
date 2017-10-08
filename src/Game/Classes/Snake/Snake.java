package Game.Classes.Snake;

import Game.Classes.Skin.SnakeSkin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Random;

public class Snake{

    private ArrayList<SnakeBlock> snakeBody;

    private SnakeSkin snakeSkin;

    private Apple target;

    private GraphicsContext graphicsContext;

    private SnakeBlock firstSnakeBlock;

    private MediaPlayer mediaPlayerEat;

    private MediaPlayer mediaPlayerFail;

    private Media eatSound;

    private Media failSound;

    private Window window;

    private Label scoreLabel;

    private boolean isAlive;

    private boolean isOnSound;

    private int score;




    public Snake(SnakeBlock firstSnakeBlock,Window window){
        this.window = window;

        this.firstSnakeBlock = firstSnakeBlock;

        this.isAlive = true;

        snakeBody = new ArrayList<>();

        this.graphicsContext = firstSnakeBlock.getGraphicsContext();

        createTarget();

        snakeBody.add(firstSnakeBlock);

        scoreLabel = new Label();
        scoreLabel.setLayoutX(10);
        scoreLabel.setLayoutY(10);
        scoreLabel.setFont(new Font("Copperplate Gothic Bold",40));
        scoreLabel.setTextFill(Color.WHITE);

        window.getMainPane().getChildren().add(scoreLabel);

        scoreLabel.setText("Score: 0");

    }

    public Snake(SnakeBlock firstSnakeBlock,SnakeSkin snakeSkin,Window window){
        this(firstSnakeBlock,window);
        this.snakeSkin = snakeSkin;
        target.setCurrentImage(snakeSkin.getAppleSkin().getAppleImages().get(new Random().nextInt(snakeSkin.getAppleSkin().getAppleImages().size())));
        this.graphicsContext.drawImage(this.snakeSkin.getBackgroundSkin().getBackgroundImage(),0,0);
    }


    public void move(long speed){
        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeBody.get(i).haveEqualPositions(firstSnakeBlock)) {
                if (isOnSound) {
                    mediaPlayerFail.stop();
                    mediaPlayerFail.play();
                }
                isAlive = false;
                score = (snakeBody.size()-1)/2;
                return;
            }
        }
        if (firstSnakeBlock.getPosX() > window.getMainScene().getWidth() / firstSnakeBlock.getDefaultSize() - 2 || firstSnakeBlock.getPosX() < 1 || firstSnakeBlock.getPosY() > window.getMainScene().getHeight() / firstSnakeBlock.getDefaultSize() - 2 || firstSnakeBlock.getPosY() < 1) {
            if (isOnSound) {
                mediaPlayerFail.stop();
                mediaPlayerFail.play();
            }
            isAlive = false;
            score = (snakeBody.size()-1)/2;
            return;
        } else if (firstSnakeBlock.haveEqualPositions(target)) {
            grow(2);
            createTarget();
            target.setCurrentImage(snakeSkin.getAppleSkin().getAppleImages().get(new Random().nextInt(snakeSkin.getAppleSkin().getAppleImages().size())));
            if (isOnSound) {
                mediaPlayerEat.stop();
                eatSound = new Media(getClass().getResource("/Game/AudioResources/EatSound.m4a").toString());
                mediaPlayerEat = new MediaPlayer(eatSound);
                mediaPlayerEat.play();
            }

        }

        updateLocation();


        if (speed != 1) {
            clearScene();
            drawSnake();
            target.draw();
        }



        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
        }


    }

    public void grow(int numberOfBlocks){
        for (int i = 0; i < numberOfBlocks; i++) {
            SnakeBlock lastSnakeBlock = snakeBody.get(snakeBody.size() - 1);
            switch (lastSnakeBlock.getPos()){
                case UP:
                    snakeBody.add(new SnakeBlock(lastSnakeBlock.getPosX(), lastSnakeBlock.getPosY() + 1, graphicsContext,lastSnakeBlock.getPos()));
                    break;
                case DOWN:
                    snakeBody.add(new SnakeBlock(lastSnakeBlock.getPosX(),lastSnakeBlock.getPosY() - 1, graphicsContext,lastSnakeBlock.getPos()));
                    break;
                case LEFT:
                    snakeBody.add(new SnakeBlock(lastSnakeBlock.getPosX() + 1, lastSnakeBlock.getPosY(), graphicsContext,lastSnakeBlock.getPos()));
                    break;
                case RIGHT:
                    snakeBody.add(new SnakeBlock(lastSnakeBlock.getPosX() - 1, lastSnakeBlock.getPosY(), graphicsContext,lastSnakeBlock.getPos()));
                    break;
            }
        }

    }
    public void updateLocation(){
        ArrayList<SnakeBlock> helper = new ArrayList<>();
        switch (firstSnakeBlock.getPos()) {
            case UP:
                helper.add(new SnakeBlock(firstSnakeBlock));
                firstSnakeBlock.setPosY(firstSnakeBlock.getPosY() - 1);
                rebuildBody(helper);
                break;
            case DOWN:
                helper.add(new SnakeBlock(firstSnakeBlock));
                firstSnakeBlock.setPosY(firstSnakeBlock.getPosY() + 1);
                rebuildBody(helper);
                break;
            case LEFT:
                helper.add(new SnakeBlock(firstSnakeBlock));
                firstSnakeBlock.setPosX(firstSnakeBlock.getPosX() - 1);
                rebuildBody(helper);
                break;
            case RIGHT:
                helper.add(new SnakeBlock(firstSnakeBlock));
                firstSnakeBlock.setPosX(firstSnakeBlock.getPosX() + 1);
                rebuildBody(helper);
                break;

        }
        helper.clear();

    }

    private void clearScene() {
        this.graphicsContext.drawImage(snakeSkin.getBackgroundSkin().getBackgroundImage(),0,0);

    }




    public void createTarget(){
        int x,y;
        Apple checkApple;
        while (true){
            boolean doMatch = true;
            x = new Random().nextInt(20 - 2) + 2;
            y = new Random().nextInt(18 - 2) + 2;
            checkApple = new Apple(x, y, graphicsContext);
            for (int i = 0; i < snakeBody.size(); i++)
                if (snakeBody.get(i).haveEqualPositions(checkApple)) {
                    doMatch = false;
            }
            if (doMatch) {
                break;
            }
        }
        target = checkApple;
    }
    public void drawSnake(){
        snakeBody.get(0).updateCurrentImage(snakeSkin,null,null);
        for (int i = 1; i < snakeBody.size() - 1; i++)
            snakeBody.get(i).updateCurrentImage(snakeSkin, snakeBody.get(i - 1), snakeBody.get(i + 1));
        if (snakeBody.size() > 1)
            snakeBody.get(snakeBody.size() - 1).updateCurrentImage(snakeSkin,snakeBody.get(snakeBody.size() - 2),null);
        for (SnakeBlock tempBlock : snakeBody)
            tempBlock.draw();

    }
    public void rebuildBody(ArrayList<SnakeBlock> helper){
        for (int i = 1; i < snakeBody.size(); i++) {
            helper.add(new SnakeBlock(snakeBody.get(i)));
            snakeBody.get(i).setPosY(helper.get(i - 1).getPosY());
            snakeBody.get(i).setPosX(helper.get(i - 1).getPosX());
            snakeBody.get(i).setPreviousPos(helper.get(i - 1).getPos());
        }
    }

    public void setIsOnSound(Boolean isOnSound) {
        if (isOnSound) {
            eatSound = new Media(getClass().getResource("/Game/AudioResources/EatSound.m4a").toString());
            failSound = new Media(getClass().getResource("/Game/AudioResources/FailSound.m4a").toString());
            mediaPlayerEat = new MediaPlayer(eatSound);
            mediaPlayerFail = new MediaPlayer(failSound);
            this.isOnSound = isOnSound;
        }else {
            eatSound = null;
            failSound = null;
            mediaPlayerFail = null;
            mediaPlayerEat = null;
            this.isOnSound = isOnSound;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSnakeBody(ArrayList<SnakeBlock> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public SnakeSkin getSnakeSkin() {
        return snakeSkin;
    }

    public void setSnakeSkin(SnakeSkin snakeSkin) {
        this.snakeSkin = snakeSkin;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public SnakeBlock getFirstSnakeBlock() {
        return firstSnakeBlock;
    }

    public ArrayList<SnakeBlock> getSnakeBody() {
        return snakeBody;
    }

    public Apple getTarget() {
        return target;
    }

    public void setTarget(Apple target) {
        this.target = target;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void setFirstSnakeBlock(SnakeBlock firstSnakeBlock) {
        this.firstSnakeBlock = firstSnakeBlock;
    }

    public MediaPlayer getMediaPlayerEat() {
        return mediaPlayerEat;
    }

    public void setMediaPlayerEat(MediaPlayer mediaPlayerEat) {
        this.mediaPlayerEat = mediaPlayerEat;
    }

    public MediaPlayer getMediaPlayerFail() {
        return mediaPlayerFail;
    }

    public void setMediaPlayerFail(MediaPlayer mediaPlayerFail) {
        this.mediaPlayerFail = mediaPlayerFail;
    }

    public Media getEatSound() {
        return eatSound;
    }

    public void setEatSound(Media eatSound) {
        this.eatSound = eatSound;
    }

    public Media getFailSound() {
        return failSound;
    }

    public void setFailSound(Media failSound) {
        this.failSound = failSound;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public boolean isOnSound() {
        return isOnSound;
    }

    public void setOnSound(boolean onSound) {
        isOnSound = onSound;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
