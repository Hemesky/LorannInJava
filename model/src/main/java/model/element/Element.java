package model.element;

import model.ISprite;
import model.Permeability;

public class Element {

	
	private ISprite sprite;
	private Permeability permeability;
	
	
	public Element(final ISprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
		
	}
	
	public final ISprite getSprite() {
		return this.sprite;
		
	}
	
	public final void setSprite (final ISprite sprite2) {
		this.sprite = sprite2;
	}

	public final Permeability getPermeability() {
		return this.permeability;
	}
	
	public void setPermeability(final Permeability permeability)
	{
		this.permeability  = permeability;
		
	}
	
	
	
}
