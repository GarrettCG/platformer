#version 330 core

// Input vertex data, different for all executions of this shader.
layout(location = 0) in vec4 vertexPosition_modelspace;

// Output data ; will be interpolated for each fragment.
out vec2 UV;

void main(){
	gl_Position =  vec4(vertexPosition_modelspace.xy,vertexPosition_modelspace.zw);
	UV = (vertexPosition_modelspace.xy+vec2(1,1))/2.0;
}
