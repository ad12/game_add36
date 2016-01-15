package add.makery.game.model;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 * Sprite is responsible for storing information of the different sprites on the screen
 * such as bullets, the player, the 
 */
public abstract class Sprite {
	protected Node node;
	protected Image image;
    protected double velocityX,velocityY;
    protected double positionX,positionY;
    protected double width,height;
    protected boolean isDead;
    protected int hitPoints;    
    
    public enum SpriteType{
    	PLAYER, ENEMY, BOSS,AMMO
    }
    public enum SpriteSide{
    	GOOD,BAD
    }
    
    protected SpriteType type;
    protected SpriteSide side;
   
    public abstract void update(double time);
    
    public double getPositionX(){
    	return this.positionX;
    }
    
    public double getPositionY(){
    	return this.positionY;
    }
    
    public double getHeight(){
		return this.height;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public SpriteType getSpriteType(){
		return type;
	}
	
	public SpriteSide getSide(){
		return side;
	}
	
	public boolean getIsDead(){
		return isDead;
	}
	
	public int getHitPoints(){
		return hitPoints;
	}
	
	public void setIsDead(boolean dead){
		isDead=dead;
	}
	
	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
	public void setHitPoints(int value){
		this.hitPoints=value;
	}
    
    public void setImage(String filename){
        image = new Image(filename);
        width= image.getWidth();
        height=image.getHeight();
        updateNode();
    }
    
    public void setPosition(double x,double y){
    	positionX=x;
    	positionY=y;
    	updateNode();
    }
    
    public void setVelocity(double x,double y){
    	velocityX=x;
    	velocityY=y;
    }
	
    public abstract void updateNode();
    
    public void addVelocity(double dx,double dy){
    	velocityX+=dx;
    	velocityY+=dy;
    }
    
    public boolean collide(Sprite other) {
    	if (this.type.equals(other.getSpriteType())) return false;
    	if (this.side.equals(other.getSide())) return false;
    	return other.getNode().getBoundsInParent().intersects(this.getNode().getBoundsInParent());
    }
    
	public void implode() {
        velocityX = velocityY = 0;
        FadeTransition ft=new FadeTransition(Duration.millis(1),getNode());
        ft.setFromValue(getNode().getOpacity());
        ft.setToValue(0);
        ft.play();
    }
	
	public void render(GraphicsContext gc){
        gc.drawImage(image, positionX, positionY);
    }
	
}