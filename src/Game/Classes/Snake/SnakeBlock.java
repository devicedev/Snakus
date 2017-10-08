package Game.Classes.Snake;

import Game.Classes.Skin.SnakeSkin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class SnakeBlock extends Keeper {
    private Position pos;

    private Position previousPos;

    private Image currentImage;



    public SnakeBlock(int posX, int posY, GraphicsContext graphicsContext, Position pos){
        super(posX,posY,graphicsContext);
        this.pos = pos;
    }

    public SnakeBlock(SnakeBlock cloneOfTheSnakeBlock){
        this(cloneOfTheSnakeBlock.getPosX(),cloneOfTheSnakeBlock.getPosY(),cloneOfTheSnakeBlock.getGraphicsContext(),cloneOfTheSnakeBlock.getPos());
    }

    public Position getPreviousPos() {
        return previousPos;
    }

    public void setPreviousPos(Position previousPos) {
        this.previousPos = this.pos;
        this.pos = previousPos;
    }



    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void draw(){
        this.getGraphicsContext().drawImage(this.getCurrentImage(),this.getPosX()*getSizeY(),this.getPosY()*getSizeY(),getSizeX(),getSizeY());
    }

    public void updateCurrentImage(SnakeSkin snakeSkin, SnakeBlock beforeBlock, SnakeBlock afterBlock){
        if (beforeBlock == null) {
            switch (this.getPos()) {
                case UP:
                    this.setCurrentImage(snakeSkin.getHeadSkin().getHeadImageUp());
                    break;
                case DOWN:
                    this.setCurrentImage(snakeSkin.getHeadSkin().getHeadImageDown());
                    break;
                case LEFT:
                    this.setCurrentImage(snakeSkin.getHeadSkin().getHeadImageLeft());
                    break;
                case RIGHT:
                    this.setCurrentImage(snakeSkin.getHeadSkin().getHeadImageRight());
                    break;
                case CENTER:
                    this.setCurrentImage(snakeSkin.getHeadSkin().getHeadImageDown());
                    break;
            }
        } else if (afterBlock == null){
            if (beforeBlock.getPosX() == this.getPosX() + 1 && beforeBlock.getPosY() == this.getPosY())
                this.setCurrentImage(snakeSkin.getTailSkin().getTailImageRight());
            else if (beforeBlock.getPosX() == this.getPosX() - 1 && beforeBlock.getPosY() == this.getPosY())
                this.setCurrentImage(snakeSkin.getTailSkin().getTailImageLeft());
            else if (beforeBlock.getPosY() == this.getPosY() - 1 && beforeBlock.getPosX() == this.getPosX())
                this.setCurrentImage(snakeSkin.getTailSkin().getTailImageUp());
            else if (beforeBlock.getPosY() == this.getPosY() + 1 && beforeBlock.getPosX() == this.getPosX())
                this.setCurrentImage(snakeSkin.getTailSkin().getTailImageDown());
        } else {
            if (beforeBlock.getPosX() == this.getPosX() + 1 && afterBlock.getPosY() == this.getPosY() + 1){
                this.setCurrentImage(snakeSkin.getCurveSkin().getCurveImageDownRight());
            } else if (beforeBlock.getPosX() == this.getPosX() - 1 && afterBlock.getPosY() == this.getPosY() + 1){
                this.setCurrentImage(snakeSkin.getCurveSkin().getCurveImageDownLeft());
            } else if (beforeBlock.getPosX() == this.getPosX() + 1 && afterBlock.getPosY() == this.getPosY() - 1) {
                this.setCurrentImage(snakeSkin.getCurveSkin().getCurveImageUpRight());
            } else if (beforeBlock.getPosX() == this.getPosX() - 1 && afterBlock.getPosY() == this.getPosY() - 1){
                this.setCurrentImage(snakeSkin.getCurveSkin().getCurveImageUpLeft());
            } else if (afterBlock.getPosX() == this.getPosX() + 1 && beforeBlock.getPosY() == this.getPosY() + 1){
                this.setCurrentImage(snakeSkin.getCurveSkin().getCurveImageDownRight());
            } else if (afterBlock.getPosX() == this.getPosX() - 1 && beforeBlock.getPosY() == this.getPosY() + 1){
                this.setCurrentImage(snakeSkin.getCurveSkin().getCurveImageDownLeft());
            } else if (afterBlock.getPosX() == this.getPosX() + 1 && beforeBlock.getPosY() == this.getPosY() - 1) {
                this.setCurrentImage(snakeSkin.getCurveSkin().getCurveImageUpRight());
            } else if (afterBlock.getPosX() == this.getPosX() - 1 && beforeBlock.getPosY() == this.getPosY() - 1){
                this.setCurrentImage(snakeSkin.getCurveSkin().getCurveImageUpLeft());
            } else{
                if (beforeBlock.getPosX() == this.getPosX() + 1 && afterBlock.getPosX() == this.getPosX() - 1){
                    this.setCurrentImage(snakeSkin.getStraightSkin().getStraightImageRl());
                } else if (beforeBlock.getPosY() == this.getPosY() + 1 && afterBlock.getPosY() == this.getPosY() - 1){
                    this.setCurrentImage(snakeSkin.getStraightSkin().getStraightImageUd());
                }  else if (afterBlock.getPosX() == this.getPosX() + 1 && beforeBlock.getPosX() == this.getPosX() - 1){
                    this.setCurrentImage(snakeSkin.getStraightSkin().getStraightImageRl());
                } else if (afterBlock.getPosY() == this.getPosY() + 1 && beforeBlock.getPosY() == this.getPosY() - 1){
                    this.setCurrentImage(snakeSkin.getStraightSkin().getStraightImageUd());
                }
            }
        }


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnakeBlock that = (SnakeBlock) o;

        if (pos != that.pos) return false;
        if (previousPos != that.previousPos) return false;
        return currentImage != null ? currentImage.equals(that.currentImage) : that.currentImage == null;
    }

    @Override
    public int hashCode() {
        int result = pos != null ? pos.hashCode() : 0;
        result = 31 * result + (previousPos != null ? previousPos.hashCode() : 0);
        result = 31 * result + (currentImage != null ? currentImage.hashCode() : 0);
        return result;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }
}