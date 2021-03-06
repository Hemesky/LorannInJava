package model;

import java.io.IOException;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;


import model.dao.StoredProcedureDAO;
import model.element.mobile.Lorann;
import model.element.mobile.Monster1;
import model.element.mobile.Monster2;
import model.element.mobile.Monster3;
import model.element.mobile.Monster4;
import model.element.motionless.MotionlessElementFactory;

import model.dao.StoredProcedureDAO;

public class Level extends Observable implements ILevel {
    /** The width. */
    public int          width = 24;

    /** The height. */
    public int          height = 12;

    /** The on the level. */
    private IElement[][] onTheLevel;
    
    /** The lorann. */
    private IMobile lorann;
    
    /** The monster of type 1. */
    private IMobile monster1;
    private boolean monster1instance;
    
    /** The monster of type 1. */
    private IMobile monster2;
    private boolean monster2instance;

	/** The monster of type 1. */
    private IMobile monster3;
    private boolean monster3instance;
    
    /** The monster of type 1. */
    private IMobile monster4;
    private boolean monster4instance;
   
    /** The gate */
    private IElement gate;
    
    /** The crystal */
    private IElement crystal;
    
    /**
     * Instantiates a new level with the content of the db.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException 
     */
    Level(final int idlevel) throws IOException, SQLException {       
    	super();
        this.loadLevel(idlevel);
    }

    /**
     * Loads the level stored all motion less position, instantiate all mobile element.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException 
     */
    private void loadLevel(final int idlevel) throws IOException, SQLException {

        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()]; //create a 24/12 board and set all compartement to null 
        
    	for (int n=0; n<height; n++) //now set all compartment to the default square 'blacktile' (background)
    	{
    		for (int i=0; i < width;i++)
    		{
    			this.setOnTheLevelXY(MotionlessElementFactory.getFromFileSymbol(' '), i, n);
    		}
    	}
 
    	//this will stored the result return by the stored procedure
        ResultSet result = StoredProcedureDAO.getLevelCompById(idlevel); //
    	
        while(result.next()) { //while there is element for this level then we overwrite the default background
        	
        	switch (result.getString(StoredProcedureDAO.getColumnSprite()).charAt(0)) {
        	
        	case '@'://if character correspond to lorann (@) then we create lorann
        		setLorann(new Lorann(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
        		break;
        	case '1'://if character correspond to monster1 (1) then we create monster1
            	setMonster1(new Monster1(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            	setMonster1instance(true);
            	break;
        	case '2'://if character correspond to monster2 (2) then we create monster2
            	setMonster2(new Monster2(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            	setMonster2instance(true);
            	break;
        	case '3'://if character correspond to monster3 (3) then we create monster3
            	setMonster3(new Monster3(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            	setMonster3instance(true);
            	break;
        	case '4'://if character correspond to monster4 (4) then we create monster4
            	setMonster4(new Monster4(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            	setMonster4instance(true);
            	break;
        	case 'H'://if character correspond to the door we put the door in the variable gate
        		this.setOnTheLevelXY(MotionlessElementFactory.getFromFileSymbol(
                		result.getString(StoredProcedureDAO.getColumnSprite()).charAt(0)),result.getInt(StoredProcedureDAO.getColumnX()),result.getInt(StoredProcedureDAO.getColumnY()));
        		setGate(this.getOnTheLevelXY(result.getInt(StoredProcedureDAO.getColumnX()),result.getInt(StoredProcedureDAO.getColumnY())));
            	break; 
        	case 'X'://if character correspond to the crystal we put it in the variable crystall
        		this.setOnTheLevelXY(MotionlessElementFactory.getFromFileSymbol(
                		result.getString(StoredProcedureDAO.getColumnSprite()).charAt(0)),result.getInt(StoredProcedureDAO.getColumnX()),result.getInt(StoredProcedureDAO.getColumnY()));
        		setCrystal(this.getOnTheLevelXY(result.getInt(StoredProcedureDAO.getColumnX()),result.getInt(StoredProcedureDAO.getColumnY())));
            	break;
            default:
        	this.setOnTheLevelXY(MotionlessElementFactory.getFromFileSymbol(
            		result.getString(StoredProcedureDAO.getColumnSprite()).charAt(0)),result.getInt(StoredProcedureDAO.getColumnX()),result.getInt(StoredProcedureDAO.getColumnY()));
            break;
            }
        }
        result.close();
    }
   
    
    /**
     * get the width
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * get the height
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * get element by XY
     */
    @Override
    public final IElement getOnTheLevelXY(final int x, final int y) {
        return this.onTheLevel[x][y];
    }

    /**
     * Sets the on the level XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private void setOnTheLevelXY(final IElement element, final int x, final int y) {
        this.onTheLevel[x][y] = element;
    }

    /**
     * Notify view of change
     */
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Get the observable
     */
    @Override
    public Observable getObservable() {
        return this;
    }

    
    /**
     * All getters and setter for element of the map that need to be update during the game
     */
	public IMobile getLorann() {
		return lorann;
	}

	public void setLorann(IMobile lorann) {
		this.lorann = lorann;
	}

	public IMobile getMonster1() {
		return monster1;
	}

	public void setMonster1(IMobile monster1) {
		this.monster1 = monster1;
	}
	
    public IMobile getMonster2() {
		return monster2;
	}

	public void setMonster2(IMobile monster2) {
		this.monster2 = monster2;
	}

	public IMobile getMonster3() {
		return monster3;
	}

	public void setMonster3(IMobile monster3) {
		this.monster3 = monster3;
	}

	public IMobile getMonster4() {
		return monster4;
	}
	
	public void setMonster4(IMobile monster4) {
		this.monster4 = monster4;
	}

	public boolean getMonster1instance() {
		return monster1instance;
	}

	public void setMonster1instance(boolean monster1instance) {
		this.monster1instance = monster1instance;
	}

	public boolean getMonster2instance() {
		return monster2instance;
	}

	public void setMonster2instance(boolean monster2instance) {
		this.monster2instance = monster2instance;
	}

	public boolean getMonster3instance() {
		return monster3instance;
	}

	public void setMonster3instance(boolean monster3instance) {
		this.monster3instance = monster3instance;
	}

	public boolean getMonster4instance() {
		return monster4instance;
	}

	public void setMonster4instance(boolean monster4instance) {
		this.monster4instance = monster4instance;
	}

	public IElement getGate() {
		return gate;
	}

	public void setGate(IElement gate) {
		this.gate = gate;
	}

	public IElement getCrystal() {
		return crystal;
	}

	public void setCrystal(IElement crystal) {
		this.crystal = crystal;
	}

}