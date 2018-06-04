package model;

import showboard.ISquare;

public interface IElement extends ISquare{

	ISprite getSprite();
	Permeability getPermeability();
	
	
}
