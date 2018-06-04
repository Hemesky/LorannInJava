package model;

import java.util.Observable;

public interface ILevel {
	
	int getWidtth();
	int getHeight();
	
	
	void setMobileHasChanged();
	
	IElement getOnTheLevelXY (int x, int y);
	
	Observable getObservable();
	
	
	IMobile getLorann();
	
	IMobile getMonster1();
	IMobile getMonster2();
	IMobile getMonster3();
	IMobile getMonster4();
	
	boolean isMonster1instanced();
	boolean isMonster2instanced();
	boolean isMonster3instanced();
	boolean isMonster4instanced();
	
	IElement getGate();
	IElement getCrystal();
	

}
