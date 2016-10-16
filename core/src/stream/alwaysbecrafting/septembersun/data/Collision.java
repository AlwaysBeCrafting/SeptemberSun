package stream.alwaysbecrafting.septembersun.data;

import com.badlogic.gdx.math.Rectangle;

import stream.alwaysbecrafting.flare.Entity;

//==============================================================================
public class Collision {
	//--------------------------------------------------------------------------

	public static final byte BOTTOM = 0;
	public static final byte LEFT   = 1;
	public static final byte RIGHT  = 2;
	public static final byte TOP    = 3;


	public Entity other;
	public Rectangle intersection = new Rectangle();
	public byte quadrant;

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
