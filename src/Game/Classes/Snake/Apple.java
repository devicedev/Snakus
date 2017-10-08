package Game.Classes.Snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Apple extends Keeper{

    private Image currentImage;

    public Apple(int posX,int posY,GraphicsContext graphicsContext) {
        super(posX,posY,graphicsContext);

    }
    public Apple(int posX,int posY,GraphicsContext graphicsContext,Image currentImage) {
        this(posX,posY,graphicsContext);
        this.currentImage = currentImage;

    }
    public void draw(){
        this.getGraphicsContext().drawImage(this.getCurrentImage(),getPosX()*getSizeX(),getPosY()*getSizeY());
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }
}
