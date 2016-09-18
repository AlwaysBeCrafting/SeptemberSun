package stream.alwaysbecrafting.septembersun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import stream.alwaysbecrafting.septembersun.util.Colors;

import static stream.alwaysbecrafting.septembersun.util.Colors.Solarized.BASE03;


//==============================================================================
public class SeptemberSun extends ApplicationAdapter {
	//--------------------------------------------------------------------------

	SpriteBatch batch;
	Texture img;

	//--------------------------------------------------------------------------

	@Override public void create () {
		batch = new SpriteBatch();
		img = new Texture( "fella.png" );
	}

	//--------------------------------------------------------------------------

	@Override public void render () {
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
	
	@Override public void dispose () {
		batch.dispose();
		img.dispose();
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
