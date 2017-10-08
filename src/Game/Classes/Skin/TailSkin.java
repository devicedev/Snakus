package Game.Classes.Skin;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class TailSkin {

    private Image tailImageUp;

    private Image tailImageDown;

    private Image tailImageRight;

    private Image tailImageLeft;

    private ArrayList<String> imagePaths;


    public TailSkin(String tailImageUpPath, String tailImageDownPath, String tailImageRightPath, String tailImageLeftPath) {
        this.tailImageUp = new Image(getClass().getResource(tailImageUpPath).toString());
        this.tailImageDown = new Image(getClass().getResource(tailImageDownPath).toString());
        this.tailImageRight = new Image(getClass().getResource(tailImageRightPath).toString());
        this.tailImageLeft = new Image(getClass().getResource(tailImageLeftPath).toString());
        imagePaths = new ArrayList<>();
        imagePaths.add(tailImageUpPath);
        imagePaths.add(tailImageDownPath);
        imagePaths.add(tailImageRightPath);
        imagePaths.add(tailImageLeftPath);
    }

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public Image getTailImageUp() {
        return tailImageUp;
    }

    public void setTailImageUp(Image tailImageUp) {
        this.tailImageUp = tailImageUp;
    }

    public Image getTailImageDown() {
        return tailImageDown;
    }

    public void setTailImageDown(Image tailImageDown) {
        this.tailImageDown = tailImageDown;
    }

    public Image getTailImageRight() {
        return tailImageRight;
    }

    public void setTailImageRight(Image tailImageRight) {
        this.tailImageRight = tailImageRight;
    }

    public Image getTailImageLeft() {
        return tailImageLeft;
    }

    public void setTailImageLeft(Image tailImageLeft) {
        this.tailImageLeft = tailImageLeft;
    }


}
