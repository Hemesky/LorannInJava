package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Purse extends MotionlessElement {
	   /** The Constant SPRITE. */
private static final ISprite SPRITE = new Sprite('$', "purse.png");

	 /**
	  * Instantiates a new purse.
	  */
	 Purse() {
	     super(SPRITE, Permeability.PENETRABLE);
	 }
}
