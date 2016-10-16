package stream.alwaysbecrafting.septembersun.component.physics;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

//==============================================================================
public class BoundingBoxComponent {
	//--------------------------------------------------------------------------

	public Rectangle rect;
	public Vector2 origin;

	//--------------------------------------------------------------------------

	public BoundingBoxComponent( int x, int y, int w, int h ) {
		this( x, y, w, h, 0, 0 );
	}

	//--------------------------------------------------------------------------

	public BoundingBoxComponent( int x, int y, int w, int h, int originX, int originY ) {
		rect = new Rectangle( x, y, w, h );
		origin = new Vector2( originX, originY );
	}

	//--------------------------------------------------------------------------

	public boolean intersects( BoundingBoxComponent otherComp, Rectangle intersection ) {
		return Intersector.intersectRectangles( rect, otherComp.rect, intersection );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
