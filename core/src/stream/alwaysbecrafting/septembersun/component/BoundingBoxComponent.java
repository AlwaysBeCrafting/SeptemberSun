package stream.alwaysbecrafting.septembersun.component;

import com.badlogic.gdx.math.Rectangle;

//==============================================================================
public class BoundingBoxComponent {
	//--------------------------------------------------------------------------

	public Rectangle rect;

	//--------------------------------------------------------------------------

	public BoundingBoxComponent( int x, int y, int w, int h ) {
		rect = new Rectangle( x, y, w, h );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
