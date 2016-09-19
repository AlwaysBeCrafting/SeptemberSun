package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import stream.alwaysbecrafting.septembersun.util.Colors;

import static stream.alwaysbecrafting.septembersun.util.Colors.Solarized.BASE03;

//==============================================================================
public class BackgroundRenderSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	@Override public void update( float deltaTime ) {
		super.update( deltaTime );

		Gdx.gl.glClearColor(
				Colors.r( BASE03 ),
				Colors.g( BASE03 ),
				Colors.b( BASE03 ),
				Colors.a( BASE03 ));

		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------