#version 330

smooth in vec4 theColor;
layout(location = 0) out vec3 color;
out vec4 outputColor;

void main()
{
   outputColor = theColor;
   //color=theColor.xyz;
}
