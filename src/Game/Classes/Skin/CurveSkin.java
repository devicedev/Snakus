package Game.Classes.Skin;


import javafx.scene.image.Image;

import java.util.ArrayList;

public class CurveSkin {

    private Image curveImageUpLeft;

    private Image curveImageUpRight;

    private Image curveImageDownLeft;

    private Image curveImageDownRight;

    private ArrayList<String> imagePaths;



    public CurveSkin(String curveImageUpLeftPath, String curveImageUpRightPath, String curveImageDownLeftPath, String curveImageDownRightPath) {
        this.curveImageUpLeft = new Image(getClass().getResource(curveImageUpLeftPath).toString());
        this.curveImageUpRight = new Image(getClass().getResource(curveImageUpRightPath).toString());
        this.curveImageDownLeft = new Image(getClass().getResource(curveImageDownLeftPath).toString());
        this.curveImageDownRight = new Image(getClass().getResource(curveImageDownRightPath).toString());
        this.imagePaths = new ArrayList<>();
        this.imagePaths.add(curveImageUpLeftPath);
        this.imagePaths.add(curveImageUpRightPath);
        this.imagePaths.add(curveImageDownLeftPath);
        this.imagePaths.add(curveImageDownRightPath);
    }

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public Image getCurveImageUpLeft() {
        return curveImageUpLeft;
    }

    public void setCurveImageUpLeft(Image curveImageUpLeft) {
        this.curveImageUpLeft = curveImageUpLeft;
    }

    public Image getCurveImageUpRight() {
        return curveImageUpRight;
    }

    public void setCurveImageUpRight(Image curveImageUpRight) {
        this.curveImageUpRight = curveImageUpRight;
    }

    public Image getCurveImageDownLeft() {
        return curveImageDownLeft;
    }

    public void setCurveImageDownLeft(Image curveImageDownLeft) {
        this.curveImageDownLeft = curveImageDownLeft;
    }

    public Image getCurveImageDownRight() {
        return curveImageDownRight;
    }

    public void setCurveImageDownRight(Image curveImageDownRight) {
        this.curveImageDownRight = curveImageDownRight;
    }
}
