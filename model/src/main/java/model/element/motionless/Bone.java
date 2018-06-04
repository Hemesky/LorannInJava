package model.element.motionless;

import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Bone extends MotionlessElement {
	   /** The Constant SPRITE. */
private static final ISprite SPRITE = new Sprite('O', "bone.png");

	 /**
	  * Instantiates a new bone.
	  */
	 Bone() {
	     super(SPRITE, Permeability.BLOCKING);
	 }
}