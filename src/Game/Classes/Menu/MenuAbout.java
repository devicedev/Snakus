package Game.Classes.Menu;

import Game.Classes.Main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAbout {

    private Stage popupStage;

    private Scene sceneMenuAbout;

    private AnchorPane anchorPane;

    private Button backButton;

    private Label label;



    public MenuAbout(Menu menu) {
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/Game/GraphicalResources/BackgroundResources/ClearBackground.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        this.label = new Label("Author: Castravet Radu-Mihai        Main Designer: Dumitru Ispas    Version: Snakus Aplha Test 1.1 Donations: Qiwi +37369934224     Have Fun!");
        this.label.setStyle("-fx-text-fill: #73b671;");
        this.label.setTextAlignment(TextAlignment.CENTER);
        this.label.setPrefWidth(665);
        this.label.setPrefHeight(252);
        this.label.setLayoutX(18);
        this.label.setLayoutY(41);
        this.label.setFont(new Font("Copperplate Gothic Bold",35));
        this.label.setWrapText(true);



        this.backButton = new Button("Back");
        this.backButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");
        this.backButton.setFont(new Font("Copperplate Gothic Bold",30));
        this.backButton.setLayoutX(287);
        this.backButton.setLayoutY(312);
        this.backButton.setOnMouseEntered(e -> this.backButton.setOpacity(0.5d));
        this.backButton.setOnMouseExited(e -> this.backButton.setOpacity(1d));
        this.backButton.setOnMousePressed(e -> this.popupStage.close());

        this.anchorPane = new AnchorPane(this.label,this.backButton);
        this.anchorPane.setBackground(new Background(backgroundImage));

        this.sceneMenuAbout = new Scene(this.anchorPane,menu.getScenaMenu().getWidth(),menu.getScenaMenu().getHeight()/1.65);

        this.popupStage = new Stage();
        this.popupStage.setScene(this.sceneMenuAbout);
        this.popupStage.initModality(Modality.APPLICATION_MODAL);
        this.popupStage.initOwner(menu.getScenaMenu().getWindow());
        this.popupStage.setX(menu.getScenaMenu().getWindow().getX());
        this.popupStage.setY(menu.getScenaMenu().getWindow().getY() + 150);
        this.popupStage.setTitle("Snakus");
        this.popupStage.getIcons().add(new Image(getClass().getResourceAsStream("/Game/GraphicalResources/OutResources/SnakeIcon.png")));
        this.popupStage.setResizable(false);
        this.popupStage.show();

    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public Stage getPopupStage() {
        return popupStage;
    }

    public void setPopupStage(Stage popupStage) {
        this.popupStage = popupStage;
    }

    public Scene getSceneMenuAbout() {
        return sceneMenuAbout;
    }

    public void setSceneMenuAbout(Scene sceneMenuAbout) {
        this.sceneMenuAbout = sceneMenuAbout;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
}
