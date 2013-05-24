#version 330

in vec2 colorCoord;

uniform sampler2D colorTexture;

out vec4 outputColor;

void main()
{
//vec4 outputColor = texture(colorTexture, colorCoord);
//if (outputColor.w < 1)
//    gl_FragColor = vec4(1,0,0,1);
//else 
//    gl_FragColor = vec4(0,1,0,1);
  outputColor = texture(colorTexture, colorCoord);
}