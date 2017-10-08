package Game.Classes.Skin;


import javafx.scene.image.Image;

import java.util.ArrayList;

public class StraightSkin {

    private Image straightImageUd;

    private Image straightImageRl;

    private ArrayList<String> imagePaths;


    public StraightSkin(String straightImageUdPath, String straightImageRlPath) {
        this.straightImageUd = new Image(getClass().getResource(straightImageUdPath).toString());
        this.straightImageRl = new Image(getClass().getResource(straightImageRlPath).toString());
        this.imagePaths = new ArrayList<>();
        this.imagePaths.add(straightImageUdPath);
        this.imagePaths.add(straightImageRlPath);
    }

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public Image getStraightImageUd() {
        return straightImageUd;
    }

    public void setStraightImageUd(Image straightImageUd) {
        this.straightImageUd = straightImageUd;
    }

    public Image getStraightImageRl() {
        return straightImageRl;
    }

    public void setStraightImageRl(Image straightImageRl) {
        this.straightImageRl = straightImageRl;
    }
}
