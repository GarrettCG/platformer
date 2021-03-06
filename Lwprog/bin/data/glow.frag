#version 330 core

in vec2 UV;

//out vec4 color;

uniform sampler2D renderedTexture;
uniform float time;

// some const, tweak for best look
const float sampleDist = 1.0;
const float sampleStrength = 2.2; 

void main(){
   float samples[4] =
   float[](0.01,0.02,0.03,0.04);

    vec2 dir =  0.5-UV; 
    float dist = sqrt(dir.x*dir.x + dir.y*dir.y); 
    // normalize the direction (reuse the distance)
    dir = dir/dist; 
	// this is the original colour of this fragment
    // using only this would result in a nonblurred version
    vec4 color = texture2D(renderedTexture,UV); 
    vec4 sum = color;
	    for (int i = 0; i < 10; i++)
    {
      sum += texture2D( renderedTexture, UV + dir * samples[i] * sampleDist );
    }
    sum *= 1.0/11.0;
    float t = dist * sampleStrength;
    t = clamp( t ,0.0,1.0);
    //color = vec4(texture( renderedTexture, UV + 0.0005*vec2( sin(time+500*UV.x),cos(time+500*UV.y)) ).xyz,1) ;
	//color=texture( renderedTexture, UV);
	gl_FragColor = mix( color, sum, t );
}