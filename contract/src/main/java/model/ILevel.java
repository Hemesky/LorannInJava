package model;

import java.util.Observable;

public interface ILevel {

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    IElement getOnTheLevelXY(int x, int y);

    /**
     * Sets the mobile has changed.
     */
    void setMobileHasChanged();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();

    /**
     * Gets the lorann.
     *
     * @return the lorann
     */
	IMobile getLorann();

    /**
     * Gets the monsters instance.
     *
     * @return the monsters
     */
	IMobile getMonster1();
	IMobile getMonster2();
	IMobile getMonster3();
	IMobile getMonster4();

    /**
     * Get if monsters are instantiate or no.
     *
     * @return the monsters instance
     */
	boolean getMonster4instance();
	boolean getMonster1instance();
	boolean getMonster2instance();
	boolean getMonster3instance();

    /**
     * Get Elements that need to be update during the game
     *
     * @return Elements
     */
	IElement getGate();
	IElement getCrystal();


}
