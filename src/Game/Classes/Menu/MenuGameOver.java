package Game.Classes.Menu;

import Game.Classes.Main.Main;
import Game.Classes.Snake.Window;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.IOException;

public class MenuGameOver {

    private AnchorPane anchorPane;

    private Scene sceneMenuGameOver;

    private Label scoreLabel;

    private Label gameOverLabel;

    private Button backToMenuButton;

    private Button retryButton;


    public MenuGameOver(){
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/Game/GraphicalResources/BackgroundResources/ClearBackground.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        this.scoreLabel = new Label("");
        this.scoreLabel.setStyle("-fx-text-fill: #73b671;");
        this.scoreLabel.setTextAlignment(TextAlignment.CENTER);
        this.scoreLabel.setPrefWidth(550);
        this.scoreLabel.setPrefHeight(90);
        this.scoreLabel.setLayoutX(110);
        this.scoreLabel.setLayoutY(203);
        this.scoreLabel.setFont(new Font("Copperplate Gothic Bold",48));

        this.gameOverLabel = new Label("GAME OVER");
        this.gameOverLabel.setStyle("-fx-text-fill: #73b671;");
        this.gameOverLabel.setPrefWidth(550);
        this.gameOverLabel.setPrefHeight(90);
        this.gameOverLabel.setLayoutX(82);
        this.gameOverLabel.setLayoutY(87);
        this.gameOverLabel.setFont(new Font("Copperplate Gothic Bold",80));

        this.retryButton = new Button("Try Again");
        this.retryButton.setFont(new Font("Copperplate Gothic Bold",40));
        this.retryButton.setPrefWidth(367);
        this.retryButton.setLayoutX(172);
        this.retryButton.setLayoutY(310);
        this.retryButton.setOnMouseEntered(e -> this.retryButton.setOpacity(0.5));
        this.retryButton.setOnMouseExited(e -> this.retryButton.setOpacity(1));
        this.retryButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");


        this.backToMenuButton = new Button("Back To Menu");
        this.backToMenuButton.setFont(new Font("Copperplate Gothic Bold",40));
        this.backToMenuButton.setPrefWidth(367);
        this.backToMenuButton.setLayoutX(172);
        this.backToMenuButton.setLayoutY(386);
        this.backToMenuButton.setOnMouseEntered(e -> this.backToMenuButton.setOpacity(0.5));
        this.backToMenuButton.setOnMouseExited(e -> this.backToMenuButton.setOpacity(1));
        this.backToMenuButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");

        this.anchorPane = new AnchorPane(this.gameOverLabel,this.scoreLabel,this.retryButton,this.backToMenuButton);
        this.anchorPane.setBackground(new Background(backgroundImage));
        this.sceneMenuGameOver = new Scene(anchorPane,720,600);
    }


    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public Scene getSceneMenuGameOver() {
        return sceneMenuGameOver;
    }

    public void setSceneMenuGameOver(Scene sceneMenuGameOver) {
        this.sceneMenuGameOver = sceneMenuGameOver;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public Label getGameOverLabel() {
        return gameOverLabel;
    }

    public void setGameOverLabel(Label gameOverLabel) {
        this.gameOverLabel = gameOverLabel;
    }

    public Button getBackToMenuButton() {
        return backToMenuButton;
    }

    public void setBackToMenuButton(Button backToMenuButton) {
        this.backToMenuButton = backToMenuButton;
    }

    public Button getRetryButton() {
        return retryButton;
    }

    public void setRetryButton(Button retryButton) {
        this.retryButton = retryButton;
    }
}
