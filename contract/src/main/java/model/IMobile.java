package model;

import java.awt.Point;

public interface IMobile {

	
	
	void moveUp();
	void moveDown();
	void moveLeft();
	void moveRight();
	
	void moveUpLeft();
	void moveUpRight();
	
	void moveDownLeft();
	void moveDownRight();
	
	void nothingatm();
	
	int getX();
	int getY();
	
	Boolean isALive(); 
	
	Boolean isKilled(); // PERMEABILITY IS KILLING FOR THE MONSTER!
	
	Boolean hasTouchedCrystal(); // PERMEABILITY IS TOUCHABLE!
	
	Boolean hasTouchedDoor(); // PERMEABILITY IS OPENGATE!
	
	void die(); // Kill the player in order to restart the game.
	
	
	Point getPosition();
	
}
