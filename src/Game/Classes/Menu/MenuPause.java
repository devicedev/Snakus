package Game.Classes.Menu;


import Game.Classes.Main.Main;
import Game.Classes.Snake.Snake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URISyntaxException;

public class MenuPause {
    private Scene scenaMenuPause;

    private AnchorPane anchorPane;

    private Button backToMenuButton;

    private Button resumeButton;


    private MediaView mediaView;

    private Media media;

    private MediaPlayer mediaPlayer;



    public MenuPause(String skinName) {
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/Game/GraphicalResources/BackgroundResources/ClearBackground.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        this.resumeButton = new Button("Resume");
        this.resumeButton.setPrefWidth(440);
        this.resumeButton.setLayoutX(130);
        this.resumeButton.setLayoutY(330);
        this.resumeButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");
        this.resumeButton.setFont(new Font("Copperplate Gothic Bold",48));
        this.resumeButton.setOnMouseEntered(e -> this.resumeButton.setOpacity(0.5d));
        this.resumeButton.setOnMouseExited(e -> this.resumeButton.setOpacity(1d));


        this.backToMenuButton = new Button("Back To Menu");
        this.backToMenuButton.setPrefWidth(440);
        this.backToMenuButton.setLayoutX(130);
        this.backToMenuButton.setLayoutY(450);
        this.backToMenuButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");
        this.backToMenuButton.setFont(new Font("Copperplate Gothic Bold",48));
        this.backToMenuButton.setOnMouseEntered(e -> this.backToMenuButton.setOpacity(0.5d));
        this.backToMenuButton.setOnMouseExited(e -> this.backToMenuButton.setOpacity(1d));

        try {
            switch (skinName){
            case "Default":
                this.media = new Media(getClass().getResource("/Game/GraphicalResources/VideoResources/GiphDN.mp4").toURI().toString());
                break;
            case "Batman":
                this.media = new Media(getClass().getResource("/Game/GraphicalResources/VideoResources/GiphBN.mp4").toURI().toString());
                break;
            case "Vampire":
                this.media = new Media(getClass().getResource("/Game/GraphicalResources/VideoResources/GiphVN.mp4").toURI().toString());
                break;
            case "Pacman":
                this.media = new Media(getClass().getResource("/Game/GraphicalResources/VideoResources/GiphPN.mp4").toURI().toString());
                break;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.mediaPlayer = new MediaPlayer(this.media);
        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mediaView = new MediaView(this.mediaPlayer);
        this.mediaView.setFitWidth(540);
        this.mediaView.setFitHeight(260);
        this.mediaView.setLayoutX(80);
        this.mediaView.setLayoutY(50);
        this.mediaView.setMediaPlayer(this.mediaPlayer);
        this.mediaPlayer.play();


        this.anchorPane = new AnchorPane(this.resumeButton,this.backToMenuButton,this.mediaView);
        this.anchorPane.setBackground(new Background(backgroundImage));

        this.scenaMenuPause = new Scene(this.anchorPane,700,620);


    }

    public Scene getScenaMenuPause() {
        return scenaMenuPause;
    }
    public void setScenaMenuPause(Scene scenaMenuPause) {
        this.scenaMenuPause = scenaMenuPause;
    }
    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
    public Button getBackToMenuButton() {
        return backToMenuButton;
    }
    public void setBackToMenuButton(Button backToMenuButton) {
        this.backToMenuButton = backToMenuButton;
    }
    public Button getResumeButton() {
        return resumeButton;
    }
    public void setResumeButton(Button resumeButton) {
        this.resumeButton = resumeButton;
    }
    public MediaView getMediaView() {
        return mediaView;
    }
    public void setMediaView(MediaView mediaView) {
        this.mediaView = mediaView;
    }
    public Media getMedia() {
        return media;
    }
    public void setMedia(Media media) {
        this.media = media;
    }
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}