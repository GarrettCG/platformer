package data;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import display.StringRenderer;
import framework.Framework;

import texturestuff.AsyncExecution;
import texturestuff.Texture;
import texturestuff.TextureManager;
//make sure to store this file in a private variable that never gets dereferenced
public class ResourceLoader {
	public ResourceLoader(){
		floatBufferList=new HashMap<String,FloatBuffer>();
		textureList=new HashMap<String,Texture>();
		programList=new HashMap<String,Integer>();
		bufferList=new HashMap<String,Integer>();
		async = new AsyncExecution();
		tm = new TextureManager(async);
	}
	public FloatBuffer retrieveFloatBuffer(String key) throws IOException{
		if(floatBufferList.containsKey(key)){
			return floatBufferList.get(key);
		}else{
			throw new IOException("key is not in the floatbuffer");
		}
	}
	public void addFloatBuffer(String key,FloatBuffer fb){
		floatBufferList.put(key, fb);
	}
	public Texture retrieveTexture(String key){
		if(textureList.containsKey(key)){
			//may need to bind texture here too using somehting like this
			textureList.get(key).bind();
			return textureList.get(key);
		}else{
			//set up texture then return it
			try {
				Texture.setUseCoreProfile(true); // this depends on your selected OpenGL profile
				Texture t=tm.getTexture(new URL("file:///home/skel/eclipse/lwjgl/Lwprog/src/texturestuff/"+key+".png"));
				t.bind();
				textureList.put(key, t);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return textureList.get(key);
		}
	}
	public Integer retrieveProgram(String key){
		if(programList.containsKey(key)){
			return programList.get(key);
		}else if (key.equals("rect")){
			//make rectangle program
			ArrayList<Integer> textshaderList = new ArrayList<>();
			textshaderList.add(Framework.loadShader(GL_VERTEX_SHADER, 	"Text.vert"));
			textshaderList.add(Framework.loadShader(GL_FRAGMENT_SHADER, "Text.frag"));
			int rectProgram = Framework.createProgram(textshaderList);
			programList.put(key, rectProgram);
		}else if (key.equals("tri")){
			//make triangle program
		}else if (key.equals("circ")){
			//make circle program
		}else{
			//throw new IOException("not a proper key for program:)"+key);
			System.out.println("not a proper key for program:)"+key);
		}
		return programList.get(key);
	}
	public Integer retrieveBuffer(String key){
		if(bufferList.containsKey(key)){
			return bufferList.get(key);
		}else{
			System.out.println("invalid key for bufferlist:"+key);
			return bufferList.get(key);
		}
	}
	public void addBuffer(String key,Integer b){
		bufferList.put(key, b);
	}
	private Map <String,FloatBuffer>floatBufferList;
	private Map <String,Texture>textureList;
	private Map <String,Integer>programList;
	private Map <String,Integer>bufferList;
	public AsyncExecution async;
	public TextureManager tm;
}
