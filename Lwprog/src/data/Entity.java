package data;

public interface Entity {
	void draw();
	void update();
	Location getLocation();
	void setLocation(Location l);
	boolean inUse();
	void setUsed(boolean b);
}
