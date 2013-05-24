package data;

import java.io.Serializable;


public class StaticEntity implements Entity,Serializable{
	public StaticEntity(TwoDModel tdm,float x,float y){
		worldLocation=new Location(x,y);
		model=tdm;
	}
	public void draw(){
		model.draw(worldLocation.getX(),worldLocation.getY());
	}
	public void update(){
		
	}
	public TwoDModel getModel(){
		return model;
	}
	private TwoDModel model;
	private Location worldLocation;

	private boolean isUsed;
	public Location getLocation(){
		return worldLocation;
	}

	public boolean inUse(){
		return isUsed;
	}
	public void setUsed(boolean b){
		isUsed=b;
	}
}
