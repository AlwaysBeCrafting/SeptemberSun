package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import stream.alwaysbecrafting.septembersun.util.Colors;

import static stream.alwaysbecrafting.septembersun.util.Colors.Solarized.BASE03;

//==============================================================================
public class RenderSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	private SpriteBatch batch;
	private Texture img;

	//--------------------------------------------------------------------------

	@Override public void addedToEngine( Engine e ) {
		batch = new SpriteBatch();
		img = new Texture( "fella.png" );
	}

	//--------------------------------------------------------------------------

	@Override public void update( float deltaTime ) {
		super.update( deltaTime );

		Gdx.gl.glClearColor(
				Colors.r( BASE03 ),
				Colors.g( BASE03 ),
				Colors.b( BASE03 ),
				Colors.a( BASE03 ));

		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
		batch.begin();
		batch.draw( img, 0, 0 );
		batch.end();
	}

	//--------------------------------------------------------------------------

	@Override public void removedFromEngine( Engine e ) {
		batch.dispose();
		img.dispose();
	}

}
//------------------------------------------------------------------------------