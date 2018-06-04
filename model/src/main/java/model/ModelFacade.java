package model;

import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;

import model.ILevel;
import model.IModelFacade;

public class ModelFacade implements IModelFacade {

	   /** The level. */
 private ILevel  level;

 
 /**
  * Instantiates a new model.
  * this load and stored the level from the DB
  * this load the player and monsters
  *
  * @param idlevel
  *            the idlevel to know the level to load
  *            
  * @throws IOException
  *             Signals that an I/O exception has occurred.
  * @throws SQLException 
  * 			the SQL exception
  */
 public ModelFacade(final int idlevel) throws IOException, SQLException {
     this.setLevel(new Level(idlevel));
 }
 
 /**
  * get level
  * @return level
  */
 @Override
 public final ILevel getLevel() {
     return this.level;
 }

 /**
  * Sets the level.
  *
  * @param level
  * 
  */
 
 public void setLevel(final ILevel level) {
     this.level = level;
 }

}
