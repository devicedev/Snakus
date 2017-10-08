package Game.Classes.Skin;

import javafx.scene.image.Image;

import java.util.ArrayList;


public class AppleSkin {

    private ArrayList<Image> appleImages;

    private ArrayList<String> imagePaths;

    public AppleSkin(String... appleImagesPaths){
        appleImages = new ArrayList<>();
        imagePaths = new ArrayList<>();
        for (String appleImagePath : appleImagesPaths) {
            this.appleImages.add(new Image(getClass().getResource(appleImagePath).toString()));
            this.imagePaths.add(appleImagePath);
        }
    }

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public ArrayList<Image> getAppleImages() {
        return appleImages;
    }

    public void setAppleImages(ArrayList<Image> appleImages) {
        this.appleImages = appleImages;
    }
}
