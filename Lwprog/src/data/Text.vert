#version 330

//layout(std140) uniform;
layout(location = 0) in vec4 position;
layout(location = 1) in vec2 texCoord;

uniform float xOffset;
uniform float yOffset;
uniform float aspect;
uniform float scale;
uniform float worldXoffset;
uniform float worldYoffset;

out vec2 colorCoord;

void main()
{
    vec4 worldposition=vec4(worldXoffset*aspect,worldYoffset,0,0)*scale;
    vec4 cameraposition =vec4(xOffset,yOffset,0,0)*scale;
    gl_Position=vec4(position.x*aspect*scale,position.y*scale,0,1)+cameraposition+worldposition;
    colorCoord = texCoord;
}