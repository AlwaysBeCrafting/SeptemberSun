package stream.alwaysbecrafting.septembersun;

import com.badlogic.gdx.ApplicationAdapter;

import stream.alwaysbecrafting.flare.GameEngine;
import stream.alwaysbecrafting.septembersun.system.BackgroundRenderSystem;
import stream.alwaysbecrafting.septembersun.system.PhysicsSystem;
import stream.alwaysbecrafting.septembersun.system.PlayerInputSystem;
import stream.alwaysbecrafting.septembersun.system.SpriteRenderSystem;
import stream.alwaysbecrafting.septembersun.util.Entities;


//==============================================================================
public class SeptemberSun extends ApplicationAdapter {
	//--------------------------------------------------------------------------

	GameEngine engine;

	//--------------------------------------------------------------------------

	@Override public void create() {
		super.create();

		engine = new GameEngine();

		engine.add( new BackgroundRenderSystem() );
		engine.add( new PlayerInputSystem() );
		engine.add( new PhysicsSystem() );
		engine.add( new SpriteRenderSystem() );


		engine.add( Entities.makePlayerCharacter() );
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
