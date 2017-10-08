package Game.Classes.Snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Keeper {
    private int posX;
    private int posY;

    private Color theObjectColor;

    private GraphicsContext graphicsContext;

    private byte defaultSize = 40;

    private byte sizeX = defaultSize;
    private byte sizeY = defaultSize;


    public Keeper(int posX, int posY, Color theObjectColor, GraphicsContext graphicsContext) {
        this(posX,posY,graphicsContext);
        this.theObjectColor = theObjectColor;
    }
    public Keeper(int posX,int posY,GraphicsContext graphicsContext){
        this.posX = posX;
        this.posY = posY;
        this.graphicsContext = graphicsContext;
    }

    public byte getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(byte defaultSize) {
        this.defaultSize = defaultSize;
        this.sizeX = defaultSize;
        this.sizeY = defaultSize;
    }

    public boolean haveEqualPositions(Keeper testKeeper){
        if (this.posX == testKeeper.getPosX() && this.posY == testKeeper.getPosY())
            return true;
        else
            return false;

    }

    public void draw(){
        graphicsContext.setFill(theObjectColor);

        graphicsContext.fillRect(posX*sizeX,posY*sizeY,sizeX,sizeY);
    }
    public void draw(Color theObjectColor){
        setTheObjectColor(theObjectColor);

        graphicsContext.setFill(theObjectColor);

        graphicsContext.fillRect(posX*sizeX,posY*sizeY,sizeX,sizeY);
    }

    public Keeper(Keeper cloneOfTheKeeper){
        this(cloneOfTheKeeper.getPosX(),cloneOfTheKeeper.getPosY(),cloneOfTheKeeper.getTheObjectColor(),cloneOfTheKeeper.getGraphicsContext());

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getTheObjectColor() {
        return theObjectColor;
    }

    public void setTheObjectColor(Color theObjectColor) {
        this.theObjectColor = theObjectColor;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public byte getSizeX() {
        return sizeX;
    }

    public void setSizeX(byte sizeX) {
        this.sizeX = sizeX;
    }

    public byte getSizeY() {
        return sizeY;
    }

    public void setSizeY(byte sizeY) {
        this.sizeY = sizeY;
    }

    @Override
    public String toString(){
        return this.getPosX()+" "+this.getPosY();
    }

}
