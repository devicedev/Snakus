package Game.Classes.Menu;

import Game.Classes.Main.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class MenuOptions {

    private MenuDifficulty menuDifficulty;

    private MenuOptionsCostumization menuOptionsCostumization;


    private VBox vBox;

    private AnchorPane secondPane;

    private AnchorPane root;

    private Scene scenaMenuOptions;



    private ImageView imageView;

    private Button difficultyButton;

    private Button soundButton;

    private Button backButton;

    private Button costumizeButton;

    public MenuOptions(Main main){

        BackgroundImage backgroundImage = new BackgroundImage(new Image("/Game/GraphicalResources/BackgroundResources/ClearBackground.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        ArrayList<Button> arrayList = new ArrayList<>();

        this.difficultyButton = new Button("Dificulty Level");
        this.difficultyButton.setOnMousePressed(e ->{
            this.menuDifficulty = new MenuDifficulty();
            this.secondPane.getChildren().clear();
            this.secondPane.getChildren().add(this.menuDifficulty.getVBox());
            this.menuDifficulty.getSaveButton().setOnMousePressed(el -> main.setSpeed(this.menuDifficulty.getSpeed()));
        });
        arrayList.add(this.difficultyButton);

        this.costumizeButton = new Button("Costumize");
        this.costumizeButton.setOnMousePressed(e ->{
            this.menuOptionsCostumization = new MenuOptionsCostumization(main.getCurrentSkin().getSkinName());
            this.menuOptionsCostumization.getSaveButton().setOnMousePressed(e1 -> {
                switch (this.menuOptionsCostumization.getSkinChoice().getValue().toString()){
                    case "Default":
                        main.loadDefault();
                        break;
                    case "Batman":
                        main.loadBat();
                        break;
                    case "Vampire":
                        main.loadVampire();
                        break;
                }
            });
            this.secondPane.getChildren().clear();
            this.secondPane.getChildren().add(this.menuOptionsCostumization.getCostumizationPane());

        });
        arrayList.add(this.costumizeButton);

        this.soundButton = new Button();
        this.soundButton.setOnMousePressed(e ->{
            if (main.isOnSound()) {
                this.soundButton.setText("Sound Off");
                main.setOnSound(false);
            } else {
                this.soundButton.setText("Sound On");
                main.setOnSound(true);
            }
        });
        this.soundButton.setText("Sound " + (main.isOnSound() ? "On" : "Off"));
        arrayList.add(this.soundButton);

        this.backButton = new Button("Back to menu");
        this.backButton.setOnMousePressed(e -> main.getMainStage().setScene(main.getMenu().getScenaMenu()));
        arrayList.add(this.backButton);

        for (Button tempButton : arrayList){
            tempButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");
            tempButton.setOnMouseEntered(e -> tempButton.setOpacity(0.5d));
            tempButton.setOnMouseExited(e -> tempButton.setOpacity(1d));
            tempButton.setPrefHeight(90);
            tempButton.setPrefWidth(300);
            tempButton.setFont(new Font("Copperplate Gothic Bold",28));

        }
        this.imageView = new ImageView();
        this.imageView.setImage(new Image(getClass().getResource("/Game/GraphicalResources/OutResources/SnakeLogo.png").toString()));
        this.imageView.setFitHeight(230);
        this.imageView.setFitWidth(250);

        VBox.setMargin(this.imageView,new Insets(0,25,10,25));
        this.vBox = new VBox(this.imageView,this.difficultyButton,this.costumizeButton,this.soundButton,this.backButton);
        this.vBox.setAlignment(Pos.BOTTOM_LEFT);
        this.vBox.setPrefWidth(300);
        this.vBox.setPrefHeight(600);

        this.secondPane = new AnchorPane();
        this.secondPane.setLayoutX(300);
        this.secondPane.setPrefHeight(600);
        this.secondPane.setPrefWidth(420);


        this.root = new AnchorPane(this.vBox,this.secondPane);
        this.root.setBackground(new Background(backgroundImage));

        this.scenaMenuOptions = new Scene(this.root,720,600);



    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public AnchorPane getSecondPane() {
        return secondPane;
    }

    public void setSecondPane(AnchorPane secondPane) {
        this.secondPane = secondPane;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Button getDifficultyButton() {
        return difficultyButton;
    }

    public void setDifficultyButton(Button difficultyButton) {
        this.difficultyButton = difficultyButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Button getCostumizeButton() {
        return costumizeButton;
    }

    public void setCostumizeButton(Button costumizeButton) {
        this.costumizeButton = costumizeButton;
    }



    public Button getSoundButton() {
        return soundButton;
    }

    public void setSoundButton(Button soundButton) {
        this.soundButton = soundButton;
    }

    public Scene getScenaMenuOptions() {
        return scenaMenuOptions;
    }

    public void setScenaMenuOptions(Scene scenaMenuOptions) {
        this.scenaMenuOptions = scenaMenuOptions;
    }
}
