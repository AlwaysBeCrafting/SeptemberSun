package stream.alwaysbecrafting.septembersun.component.render;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

//==============================================================================
public class SpriteComponent {
	//--------------------------------------------------------------------------

	public Texture sprite;
	public Vector2 origin;

	//--------------------------------------------------------------------------

	public SpriteComponent( Texture tex ) {
		this( tex, 0, 0 );
	}

	//--------------------------------------------------------------------------

	public SpriteComponent( Texture tex, int originX, int originY ) {
		sprite = tex;
		origin = new Vector2( originX, originY );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
