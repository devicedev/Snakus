package Game.Classes.Menu;

import Game.Classes.Main.Main;
import Game.Classes.Snake.Window;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {


    private Scene scenaMenu;

    private AnchorPane anchorPane;

    private MenuAbout menuAbout;

    private MenuOptions menuOptions;

    private Window window;

    private MenuGameOver menuGameOver;

    private Button startGameButton;

    private Button optionsButton;

    private Button aboutButton;

    private Button exitButton;

    private Button loseButton;


    public Menu(Main main) {
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/Game/GraphicalResources/BackgroundResources/Background.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);

        ArrayList<Button> arrayList = new ArrayList<>();

        startGameButton = new Button("Start");
        startGameButton.setOnMousePressed(e -> {
            this.window = new Window(880,800,main.getMainStage());
            main.prepareGame(this.window);
            main.startGame();

        });
        arrayList.add(startGameButton);

        optionsButton = new Button("Options");
        optionsButton.setOnMousePressed(e -> {
            menuOptions = new MenuOptions(main);
            main.getMainStage().setScene(menuOptions.getScenaMenuOptions());

        });
        arrayList.add(optionsButton);

        aboutButton = new Button("About");
        aboutButton.setOnMousePressed(e -> menuAbout = new MenuAbout(this));
        arrayList.add(aboutButton);

        exitButton = new Button("Exit");
        exitButton.setOnMousePressed(e -> main.getMainStage().close());
        arrayList.add(exitButton);

        loseButton = new Button();
        loseButton.setOnAction(event -> {
            main.getMainStage().setScene(this.getMenuGameOver().getSceneMenuGameOver());
            this.menuGameOver.getRetryButton().setOnMousePressed(e -> {
                main.prepareGame(new Window(880, 800,main.getMainStage()));
                main.startGame();
            });
            this.menuGameOver.getBackToMenuButton().setOnMousePressed(e -> main.getMainStage().setScene(this.getScenaMenu()));
            if (main.getSnake().getScore() > main.getHighScore()) {
                this.menuGameOver.getScoreLabel().setText("New High Score: " + main.getSnake().getScore());
                main.setHighScore(main.getSnake().getScore());
            }
            else {
                menuGameOver.getScoreLabel().setText("Your score is: " + main.getSnake().getScore());
            }
        });

        int i = 246;
        for (Button tempButton : arrayList){
            tempButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #73b671;");
            tempButton.setOnMouseEntered(e-> tempButton.setOpacity(0.5d));
            tempButton.setOnMouseExited(e-> tempButton.setOpacity(1d));
            tempButton.setPrefWidth(300);
            tempButton.setPrefHeight(86);
            tempButton.setFont(new Font("Copperplate Gothic Bold",48));
            tempButton.setLayoutX(200);
            tempButton.setLayoutY(i);
            i+=86;

        }

        this.anchorPane = new AnchorPane(startGameButton,optionsButton,aboutButton,exitButton);

        this.anchorPane.setBackground(new Background(backgroundImage));

        this.scenaMenu = new Scene(anchorPane,700,617);

    }

    public Scene getScenaMenu() {
        return scenaMenu;
    }

    public void setScenaMenu(Scene scenaMenu) {
        this.scenaMenu = scenaMenu;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public Button getStartGameButton() {
        return startGameButton;
    }

    public void setStartGameButton(Button startGameButton) {
        this.startGameButton = startGameButton;
    }

    public Button getOptionsButton() {
        return optionsButton;
    }

    public void setOptionsButton(Button optionsButton) {
        this.optionsButton = optionsButton;
    }

    public Button getAboutButton() {
        return aboutButton;
    }

    public void setAboutButton(Button aboutButton) {
        this.aboutButton = aboutButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public void setExitButton(Button exitButton) {
        this.exitButton = exitButton;
    }

    public MenuAbout getMenuAbout() {
        return menuAbout;
    }

    public void setMenuAbout(MenuAbout menuAbout) {
        this.menuAbout = menuAbout;
    }

    public MenuOptions getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(MenuOptions menuOptions) {
        this.menuOptions = menuOptions;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public MenuGameOver getMenuGameOver() {
        return menuGameOver;
    }

    public void setMenuGameOver(MenuGameOver menuGameOver) {
        this.menuGameOver = menuGameOver;
    }

    public Button getLoseButton() {
        return loseButton;
    }

    public void setLoseButton(Button loseButton) {
        this.loseButton = loseButton;
    }
}
