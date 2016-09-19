package stream.alwaysbecrafting.septembersun;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;

import stream.alwaysbecrafting.septembersun.system.RenderSystem;
import stream.alwaysbecrafting.septembersun.system.SpriteRenderSystem;


//==============================================================================
public class SeptemberSun extends ApplicationAdapter {
	//--------------------------------------------------------------------------

	Engine engine;

	//--------------------------------------------------------------------------

	@Override public void create() {
		super.create();

		engine = new Engine();

		engine.addSystem( new RenderSystem() );
		engine.addSystem( SpriteRenderSystem.create() );
	}

	//--------------------------------------------------------------------------

	@Override public void render () {
		super.render();

		engine.update( 0 );
	}

	//--------------------------------------------------------------------------
	
	@Override public void dispose () {
		super.dispose();
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
