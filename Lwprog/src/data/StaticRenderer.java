package data;

public interface StaticRenderer {
	void draw(float x,float y);
	void draw(Entity e);//just draw what you got with stored info
	//void draw(int x,int y)//draw based on absolute mouse.getx type info
}
