package Game.Classes.Skin;


import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;

public class BackgroundSkin {
    private Image backgroundImage;

    private WritableImage[][] backgroundParts;

    private ArrayList<String> imagePaths;


    public BackgroundSkin(String backgroundImagePath) {
        this.backgroundImage = new Image(getClass().getResource(backgroundImagePath).toString());
        this.backgroundParts = new WritableImage[22][20];
        this.imagePaths = new ArrayList<>();
        for (int i = 0; i < backgroundParts.length; i++) {
            for (int j = 0; j < backgroundParts[i].length; j++) {
                backgroundParts[i][j] = new WritableImage(this.backgroundImage.getPixelReader(),i*40,j*40,40,40);
            }
        }
        imagePaths.add(backgroundImagePath);
    }

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public WritableImage getBackgroundParts(int i,int j){
        return backgroundParts[i][j];

    }
}
