package data;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STREAM_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public abstract class Shape {//a shape is either a triange rectangle circle or polygon although i'll probably forgo the polygon for now
	//rectenv is an example of this
	abstract void drawShape(float x,float y);
	abstract void staticDrawShape(float x,float y);
	abstract void debugDrawShape(float x,float y);
	public FloatBuffer makeBuffer(float[] vertPositions) {
		FloatBuffer vertexPositionsBuffer = BufferUtils.createFloatBuffer(vertPositions.length);
		vertexPositionsBuffer.put(vertPositions);
		vertexPositionsBuffer.flip();
		return vertexPositionsBuffer;
/*
        positionBufferObject = glGenBuffers();	       
		glBindBuffer(GL_ARRAY_BUFFER, positionBufferObject);
	    glBufferData(GL_ARRAY_BUFFER, vertexPositionsBuffer, GL_STREAM_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);*/
	}
	protected float vertexs[];
	//rotected float individualXoffset;
	//protected float individualYoffset;
}
