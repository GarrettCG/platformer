package data;

public class UIEntity implements Entity{

	public UIEntity(Location l,TwoDModel tdm){
		location=l;
		model=tdm;
	}
	@Override
	public void draw() {
		model.staticDraw(location.getX(), location.getY());
	}

	@Override
	public void update() {
		
	}

	@Override
	public Location getLocation() {
		return location;
	}
	public void setLocation(float x,float y){
		location=new Location(x,y);
	}
	@Override
	public boolean inUse() {
		return isUsed;
	}

	@Override
	public void setUsed(boolean b) {
		isUsed=true;		
	}
	private boolean isUsed;
	private Location location;
	private TwoDModel model;
}
