package data;


import java.util.ArrayList;
import java.util.List;




public class World {
	public World(int rows,int cols){
		zonegrid=new ArrayList<List<Zone>>();
		for(int i=0;i<rows;i++){
			zonegrid.add(new ArrayList<Zone>());
		}
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				zonegrid.get(i).add(new Zone());
			}	
		}
	}
	public void addEntity(Entity e){
		int r=(int)e.getLocation().getY()/50;
		int c=(int)e.getLocation().getX()/50;
		zonegrid.get(r).get(c).addEntity(e);
	}
	public List<Entity> getNineZones(int row, int col){
		List<Entity> entitylist=new ArrayList<Entity>();
		int edgerow=1,edgecol=1;
		if(row<=0){
			edgerow=0;
			row=0;
		}
		if(col<=0){
			edgecol=0;
			col=0;
		}
		for(int i=row-edgerow;i<row+2;i++){
			for(int j=col-edgecol;j<col+2;j++){
				entitylist.addAll(zonegrid.get(i).get(j).getEntityList());
			}
		}
		return entitylist;
	}
	public World(String filename){
		
	}
	public void exampleInit(){//kind of a unit test
		
	}
	
	private List<List<Zone>> zonegrid;
	
}
