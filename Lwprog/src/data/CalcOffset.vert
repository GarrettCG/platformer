#version 330

layout(location = 0) in vec4 position;
uniform float scaler;
uniform float xOffset;
uniform float yOffset;
uniform float time;
uniform float aspect;
layout (location = 1) in vec4 color;

smooth out vec4 theColor;
void main()
{
    float x=scaler*aspect;//use mouse wheel to control these values
    float y=scaler;
    float z=1;
    mat4 scale =mat4(x,0,0,xOffset*scaler,
                     0,y,0,yOffset*scaler,
                     0,0,z,0,
                     0,0,0,1);

	gl_Position =position*scale;
	theColor = color;
}
