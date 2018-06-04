package model.element.mobile;

import java.awt.Image;
import java.io.IOException;

import model.ILevel;
import model.ISprite;
import model.Permeability;
import model.element.Sprite;

public class Lorann extends Mobile implements ISprite{
	
	/** The Constant SPRITE. */
    private static final ISprite sprite          = new Sprite('@', "lorann_ul.png");

    /** The Constant spriteTurnLeft. */
    private static final ISprite spriteMoveLeft  = new Sprite('@', "lorann_l.png");

    /** The Constant spriteTurnRight. */
    private static final ISprite spriteMoveRight = new Sprite('@', "lorann_r.png");
    
    /** The Constant spriteMoveUp. */
    private static final ISprite spriteMoveUp  = new Sprite('@', "lorann_u.png");

    /** The Constant spriteMoveDown. */
    private static final ISprite spriteMoveDown = new Sprite('@', "lorann_b.png");
    
    /** The Constant spriteMoveDownRight. */
    private static final ISprite spriteMoveDownRight = new Sprite('@', "lorann_br.png");
    
    /** The Constant spriteMoveDownLeft. */
    private static final ISprite spriteMoveDownLeft = new Sprite('@', "lorann_bl.png");
    
    /** The Constant spriteMoveDownRight. */
    private static final ISprite spriteMoveUpRight = new Sprite('@', "lorann_ur.png");
    
    /** The Constant spriteMoveDownLeft. */
    private static final ISprite spriteMoveUpLeft = new Sprite('@', "lorann_ul.png");

    /** The Constant spriteDie. */
    private static final ISprite spriteDie  = new Sprite('@', "noimage.png");
    
    /** Counter for Lorann picture state */
    private int counter = 1;
    
    /** Delay to change the lorann picture less rapidly than the thread is executed */
	private int delay = 1;
	
    /**
     * Instantiates a new Loran.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param level
     *            the level
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Lorann(final int x, final int y, final ILevel level) throws IOException {
        super(x, y, sprite, level, Permeability.BLOCKING);
        sprite.loadImage();
        spriteMoveLeft.loadImage();
        spriteMoveRight.loadImage();
        spriteMoveUp.loadImage();
        spriteMoveDown.loadImage();
        spriteDie.loadImage();
        spriteMoveDownRight.loadImage();
        spriteMoveDownLeft.loadImage();
        spriteMoveUpRight.loadImage();
        spriteMoveUpLeft.loadImage();
    }
    

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteMoveLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteMoveRight);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteMoveUp);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteMoveDown);
    }
    
    @Override
    public final void moveDownRight() {
        super.moveDownRight();
        this.setSprite(spriteMoveDownRight);
    }
    
    @Override
    public final void moveDownLeft() {
        super.moveDownLeft();
        this.setSprite(spriteMoveDownLeft);
    }
    
    @Override
    public final void moveUpRight() {
        super.moveUpRight();
        this.setSprite(spriteMoveUpRight);
    }
    
    @Override
    public final void moveUpLeft() {
        super.moveUpLeft();
        this.setSprite(spriteMoveUpLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
	public final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void nothingatm() {
    	super.nothingatm();
    	if(delay == 6) {
    		delay=0;
	    	switch ( getCounter() ) { //this switch is used to change the player picture when he didn't move
			case 1:
				this.setSprite(spriteMoveLeft); //first picture load, next time we do the while the second will be load
				setCounter(2);
				break;
			case 2:
				this.setSprite(spriteMoveUp); //third picture load, next time we do the while the fourth will be load
				setCounter(3);
	    		break;
			case 3:
				this.setSprite(spriteMoveRight); //first picture load, next time we do the while the second will be load
				setCounter(4);
				break;
			case 4:
				this.setSprite(spriteMoveDown); //third picture load, next time we do the while the fourth will be load
				setCounter(1);
	    		break;
	    	}
    	}
	    	else{
	    		delay++;
	        }
    	}


	@Override
	public void loadImage() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getConsoleImage() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}


	@Override
	public Boolean isALive() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean hasTouchedCrystal() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean hasTouchedDoor() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
}

	

