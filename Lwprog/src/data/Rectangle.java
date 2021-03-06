package data;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_QUADS;

import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STREAM_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

import java.io.Serializable;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import display.FragChangeColor04;

import framework.Framework;

public class Rectangle extends Shape implements Serializable{
	public Rectangle(float width, float height,String texdata){//x and y are coords for centerpoint
		this.texdata=texdata;
		super.vertexs=new float[16];
		super.vertexs[0]=-width/2;
		super.vertexs[1]=height/2;
		super.vertexs[2]=0;
		super.vertexs[3]=1;
		super.vertexs[4]=width/2;
		super.vertexs[5]=height/2;
		super.vertexs[6]=0;
		super.vertexs[7]=1;
		super.vertexs[8]=width/2;
		super.vertexs[9]=-height/2;
		super.vertexs[10]=0;
		super.vertexs[11]=1;
		super.vertexs[12]=-width/2;
		super.vertexs[13]=-height/2;
		super.vertexs[14]=0;
		super.vertexs[15]=1;
		flo=makeBuffer(super.vertexs);
        positionBufferObject = glGenBuffers();	       
		glBindBuffer(GL_ARRAY_BUFFER, positionBufferObject);
	    glBufferData(GL_ARRAY_BUFFER, flo, GL_STREAM_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		uniformAspect=glGetUniformLocation(FragChangeColor04.rl.retrieveProgram("rect"),"aspect");
		uniformScale=glGetUniformLocation(FragChangeColor04.rl.retrieveProgram("rect"),"scale");
		uniformX=glGetUniformLocation(FragChangeColor04.rl.retrieveProgram("rect"),"xOffset");
		uniformY=glGetUniformLocation(FragChangeColor04.rl.retrieveProgram("rect"),"yOffset");
		uniformWx=glGetUniformLocation(FragChangeColor04.rl.retrieveProgram("rect"),"worldXoffset");
		uniformWy=glGetUniformLocation(FragChangeColor04.rl.retrieveProgram("rect"),"worldYoffset");
		glUseProgram(FragChangeColor04.rl.retrieveProgram("rect"));
		glUniform1f(uniformAspect, FragChangeColor04.aspect);
		glUniform1f(uniformScale, FragChangeColor04.scale);
		glUseProgram(0);
	}
	@Override
	public void drawShape(float x, float y){//these are the entity positions so x + IndividualX
		glUseProgram(FragChangeColor04.rl.retrieveProgram("rect"));
		FragChangeColor04.rl.retrieveTexture(texdata);
		glUniform1f(uniformAspect, FragChangeColor04.aspect);
		glUniform1f(uniformScale, FragChangeColor04.scale);
		glUniform1f(uniformX, FragChangeColor04.aspectedposx);
		glUniform1f(uniformY, FragChangeColor04.posy);
		glUniform1f(uniformWx,x);
		glUniform1f(uniformWy,y);
		glBindBuffer(GL_ARRAY_BUFFER, positionBufferObject);
		glEnableVertexAttribArray(0);
		glVertexAttribPointer(0, 4, GL_FLOAT, false, 0, 0);
		
		
		glBindBuffer(GL_ARRAY_BUFFER, FragChangeColor04.rl.retrieveBuffer("ALLBUFFER"));
		glEnableVertexAttribArray(1);
		glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);//defining texcoords
		glDrawArrays(GL_QUADS, 0, 16);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(0);
		glUseProgram(0);
	}
	@Override
	void debugDrawShape(float x, float y) {
		// TODO Auto-generated method stub
		
	}
	private int uniformAspect;
	private int uniformScale, uniformX, uniformY,uniformWx,uniformWy;
	private String texdata;
	private FloatBuffer flo;
	private int positionBufferObject;
	@Override
	void staticDrawShape(float x, float y) {
		glUseProgram(FragChangeColor04.rl.retrieveProgram("rect"));
		FragChangeColor04.rl.retrieveTexture(texdata);
		glUniform1f(uniformAspect, FragChangeColor04.aspect);
		glUniform1f(uniformScale, 1.0f);
		glUniform1f(uniformX, 0f);
		glUniform1f(uniformY, 0f);
		glUniform1f(uniformWx,x);
		glUniform1f(uniformWy,y);
		glBindBuffer(GL_ARRAY_BUFFER, positionBufferObject);
		glEnableVertexAttribArray(0);
		glVertexAttribPointer(0, 4, GL_FLOAT, false, 0, 0);
		
		
		glBindBuffer(GL_ARRAY_BUFFER, FragChangeColor04.rl.retrieveBuffer("ALLBUFFER"));
		glEnableVertexAttribArray(1);
		glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);//defining texcoords
		glDrawArrays(GL_QUADS, 0, 16);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(0);
		glUseProgram(0);
		
	}

}
