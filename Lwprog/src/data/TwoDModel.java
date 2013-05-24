package data;


import java.util.ArrayList;


public class TwoDModel {
	public TwoDModel(ArrayList<Shape> S){
		shapes=S;
	}
	public TwoDModel(Shape s,float x,float y){
		shapes=new ArrayList<Shape>();
		shapes.add(s);
		individualX=new ArrayList<Float>();
		individualY=new ArrayList<Float>();
		individualX.add(x);
		individualY.add(y);
	}
	public void draw(float x, float y){
		for(int i=0;i<shapes.size();i++){
			shapes.get(i).drawShape(x+individualX.get(i),y+individualY.get(i));
		}
	}
	public void staticDraw(float x, float y){
		for(int i=0;i<shapes.size();i++){
			shapes.get(i).staticDrawShape(x+individualX.get(i),y+individualY.get(i));
		}
	}
	private ArrayList<Shape> shapes;
	private ArrayList<Float> individualX;
	private ArrayList<Float> individualY;

}

