package Game.Classes.Menu;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class MenuDifficulty {

    private VBox vBox;

    private Button saveButton;

    private ImageView imageViewEasy;

    private ImageView imageViewNormal;

    private ImageView imageViewHard;

    private ImageView imageViewInsane;

    private int speed;

    public MenuDifficulty() {
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/Game/GraphicalResources/BackgroundResources/ClearBackground.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        ArrayList<ImageView> imageViewArrayList = new ArrayList<>();

        this.imageViewEasy = new ImageView(new Image(getClass().getResource("/Game/GraphicalResources/DifficultyResources/Easy.png").toString()));
        this.imageViewEasy.setOnMouseClicked(e -> speed = 135);
        imageViewArrayList.add(this.imageViewEasy);

        this.imageViewNormal = new ImageView(new Image(getClass().getResource("/Game/GraphicalResources/DifficultyResources/Normal.png").toString()));
        this.imageViewNormal.setOnMouseClicked(e -> this.speed = 105);
        imageViewArrayList.add(this.imageViewNormal);

        this.imageViewHard = new ImageView(new Image(getClass().getResource("/Game/GraphicalResources/DifficultyResources/Hard.png").toString()));
        this.imageViewHard.setOnMouseClicked(e -> this.speed = 70);
        imageViewArrayList.add(this.imageViewHard);

        this.imageViewInsane = new ImageView(new Image(getClass().getResource("/Game/GraphicalResources/DifficultyResources/Insane.png").toString()));
        this.imageViewInsane.setOnMouseClicked(e -> this.speed = 35);
        imageViewArrayList.add(this.imageViewInsane);

        for (ImageView imageView : imageViewArrayList){
            imageView.setOnMouseEntered(e -> imageView.setOpacity(0.5));
            imageView.setOnMouseExited(e -> imageView.setOpacity(1));
            imageView.setFitWidth(400);
            imageView.setFitHeight(120);
        }


        this.saveButton = new Button("Save");
        this.saveButton.setPrefWidth(282);
        this.saveButton.setPrefHeight(12);
        this.saveButton.setFont(new Font("Copperplate Gothic Bold",26));
        this.saveButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");
        this.saveButton.setOnMouseEntered(e -> this.saveButton.setOpacity(0.5));
        this.saveButton.setOnMouseExited(e -> this.saveButton.setOpacity(1));
        VBox.setMargin(saveButton,new Insets(0,0,0,60));

        this.vBox = new VBox(this.imageViewEasy,this.imageViewNormal,this.imageViewHard,this.imageViewInsane,this.saveButton);
        this.vBox.setPadding(new Insets(10,10,5,10));
        this.vBox.setSpacing(15);
        this.vBox.setBackground(new Background(backgroundImage));

    }

    public VBox getVBox() {
        return vBox;
    }

    public void setVBox(VBox vBox) {
        this.vBox = vBox;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public ImageView getImageViewEasy() {
        return imageViewEasy;
    }

    public void setImageViewEasy(ImageView imageViewEasy) {
        this.imageViewEasy = imageViewEasy;
    }

    public ImageView getImageViewNormal() {
        return imageViewNormal;
    }

    public void setImageViewNormal(ImageView imageViewNormal) {
        this.imageViewNormal = imageViewNormal;
    }

    public ImageView getImageViewHard() {
        return imageViewHard;
    }

    public void setImageViewHard(ImageView imageViewHard) {
        this.imageViewHard = imageViewHard;
    }

    public ImageView getImageViewInsane() {
        return imageViewInsane;
    }

    public void setImageViewInsane(ImageView imageViewInsane) {
        this.imageViewInsane = imageViewInsane;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
