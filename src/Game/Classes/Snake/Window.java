package Game.Classes.Snake;

import Game.Classes.Main.Main;
import Game.Classes.Skin.BackgroundSkin;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window {


    private Canvas canvas;
    
    private GraphicsContext graphicsContext;

    private AnchorPane mainPane;

    private Scene mainScene;

    private Color backgroundColor;

    private BackgroundSkin backgroundSkin;

    private Stage mainStage;


    public Window(int width,int height,Stage mainStage){
        this.mainStage = mainStage;

        canvas = new Canvas(width,height);

        mainPane = new AnchorPane();

        mainScene = new Scene(mainPane,width,height);

        graphicsContext = canvas.getGraphicsContext2D();

        mainPane.getChildren().addAll(canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public AnchorPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(AnchorPane mainPane) {
        this.mainPane = mainPane;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public BackgroundSkin getBackgroundSkin() {
        return backgroundSkin;
    }

    public void setBackgroundSkin(BackgroundSkin backgroundSkin) {
        this.backgroundSkin = backgroundSkin;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}
