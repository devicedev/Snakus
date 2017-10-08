package Game.Classes.Skin;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class HeadSkin {
    private Image headImageUp;

    private Image headImageDown;

    private Image headImageRight;

    private Image headImageLeft;

    private ArrayList<String> imagePaths;

    public HeadSkin(String headImageUpPath, String headImageDownPath, String headImageRightPath, String headImageLeftPath) {
        this.headImageUp = new Image(getClass().getResource(headImageUpPath).toString());
        this.headImageDown = new Image(getClass().getResource(headImageDownPath).toString());
        this.headImageRight = new Image(getClass().getResource(headImageRightPath).toString());
        this.headImageLeft = new Image(getClass().getResource(headImageLeftPath).toString());
        this.imagePaths = new ArrayList<>();
        this.imagePaths.add(headImageUpPath);
        this.imagePaths.add(headImageDownPath);
        this.imagePaths.add(headImageRightPath);
        this.imagePaths.add(headImageLeftPath);

    }

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public Image getHeadImageUp() {
        return headImageUp;
    }

    public void setHeadImageUp(Image headImageUp) {
        this.headImageUp = headImageUp;
    }

    public Image getHeadImageDown() {
        return headImageDown;
    }

    public void setHeadImageDown(Image headImageDown) {
        this.headImageDown = headImageDown;
    }

    public Image getHeadImageRight() {
        return headImageRight;
    }

    public void setHeadImageRight(Image headImageRight) {
        this.headImageRight = headImageRight;
    }

    public Image getHeadImageLeft() {
        return headImageLeft;
    }

    public void setHeadImageLeft(Image headImageLeft) {
        this.headImageLeft = headImageLeft;
    }
}
