package model.element.motionless;

public abstract class MotionlessElementFactory {
	
    /** The Constant Bone. */
    private static final Bone bone = new Bone();

    /** The Constant HozizontalBone. */
    private static final HorizontalBone horizontalBone = new HorizontalBone();

    /** The Constant VerticalBone. */
    private static final VerticalBone verticalBone = new VerticalBone();
    
    /** The Constant Bone. */
    private static final Purse purse = new Purse();
    
    /** The Constant Crystal. */
    private static final Crystal crystal = new Crystal();
    
    /** The Constant Gate. */
    private static final Gate gate = new Gate();
    
    /** The Constant Tile (black background). */
    private static final Tile tile = new Tile();
	
    private static MotionlessElement[]       motionlessElements  = {
            bone,
            horizontalBone,
            verticalBone,
            purse,
            crystal,
            gate,
            tile,
            };
    
    /**
     * Creates a new bone MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createBone() {
        return bone;
    }
    
    /**
     * Creates a new horizontal bone MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createHorizontalBone() {
        return horizontalBone;
    }
    
    /**
     * Creates a new vertical bone MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createVerticalBone() {
        return verticalBone;
    }
    
    /**
     * Creates a new purse MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createPurse() {
        return purse;
    }
    
    /**
     * Creates a new crystal MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createCrystal() {
        return crystal;
    }
    
    /**
     * Creates a new gate MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createGate() {
        return gate;
    }
    
    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
    	
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return tile;
    }
}
