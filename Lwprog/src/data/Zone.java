package data;

import java.util.ArrayList;
import java.util.List;


public class Zone {
	public Zone(){
		entityList=new ArrayList<Entity>();
	}
	public void addEntity(Entity e){
		entityList.add(e);
	}
	public void removeEntity(Entity e){
		entityList.remove(e);
	}
	public List<Entity> getEntityList(){
		return entityList;
	}
	
	
	private List<Entity> entityList; 
}
