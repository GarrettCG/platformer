package data;

public interface Entity {
	void draw();
	void update();
	Location getLocation();
	boolean inUse();
	void setUsed(boolean b);
}
