package Game.Classes.Menu;

import Game.Classes.Main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URISyntaxException;

public class MenuOptionsCostumization {

    private AnchorPane costumizationPane;

    private MediaView mediaView;

    private Media media;

    private MediaPlayer mediaPlayer;

    private Button saveButton;

    private ComboBox skinChoice;


    private ObservableList<String> skinList = FXCollections.observableArrayList("Default","Batman","Vampire");


    public MenuOptionsCostumization(String skinName){
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/Game/GraphicalResources/BackgroundResources/ClearBackground.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        this.mediaView = new MediaView();
        this.mediaView.setFitHeight(260);
        this.mediaView.setFitWidth(420);
        this.mediaView.setLayoutX(0);
        this.mediaView.setLayoutY(0);

        this.skinChoice = new ComboBox(skinList);
        this.skinChoice.setPrefHeight(35);
        this.skinChoice.setPrefWidth(420);
        this.skinChoice.setLayoutX(0);
        this.skinChoice.setLayoutY(260);
        this.skinChoice.setStyle("-fx-font: 28px \"Copperplate Gothic Bold\";-fx-text-fill: #73b671;");
        this.skinChoice.setValue(skinName);
        switch (skinName){
            case "Default":
                this.loadMedia("GiphD");
                break;
            case "Batman":
                this.loadMedia("GiphB");
                break;
            case "Vampire":
                this.loadMedia("GiphV");
                break;
        }
        this.skinChoice.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override public ListCell<String> call(ListView<String> param) {
                final ListCell<String> cell = new ListCell<String>() {
                    @Override
                    public void updateItem(String item,boolean empty) {
                        super.updateItem(item, empty);
                        setText(item);
                        setStyle("-fx-font: 28px \"Copperplate Gothic Bold\";-fx-text-fill: #73b671;");
                    }};
                return cell;
            }
        });
        this.skinChoice.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue.toString()){
                case "Default":
                    this.loadMedia("GiphD");
                    break;
                case "Batman":
                    this.loadMedia("GiphB");
                    break;
                case "Vampire":
                    this.loadMedia("GiphV");
                    break;
            }
        });

        this.saveButton = new Button("Save");
        this.saveButton.setFont(new Font("Copperplate Gothic Bold",24));
        this.saveButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");
        this.saveButton.setLayoutX(310);
        this.saveButton.setLayoutY(530);
        this.saveButton.setOnMouseEntered(e -> this.saveButton.setOpacity(0.5d));
        this.saveButton.setOnMouseExited(e -> this.saveButton.setOpacity(1d));


        this.costumizationPane = new AnchorPane(this.mediaView,this.skinChoice,this.saveButton);
        this.costumizationPane.setBackground(new Background(backgroundImage));
    }
    public void loadMedia(String arg){
        if (this.mediaPlayer != null)
            this.mediaPlayer.stop();
        try {
            this.media = new Media(getClass().getResource("/Game/GraphicalResources/VideoResources/"+arg+".mp4").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.mediaPlayer = new MediaPlayer(this.media);
        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mediaView.setMediaPlayer(this.mediaPlayer);
        this.mediaPlayer.play();

    }

    public AnchorPane getCostumizationPane() {
        return costumizationPane;
    }

    public void setCostumizationPane(AnchorPane costumizationPane) {
        this.costumizationPane = costumizationPane;
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

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public ComboBox getSkinChoice() {
        return skinChoice;
    }

    public void setSkinChoice(ComboBox skinChoice) {
        this.skinChoice = skinChoice;
    }

    public ObservableList<String> getSkinList() {
        return skinList;
    }

    public void setSkinList(ObservableList<String> skinList) {
        this.skinList = skinList;
    }
}

