package stream.alwaysbecrafting.septembersun;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Matrix4;

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


		Matrix4 projection = new Matrix4();
		projection.setToOrtho2D( 0, 0, 320, 180 );


		engine = new GameEngine();

		engine.add( new BackgroundRenderSystem() );
		engine.add( new PlayerInputSystem() );
		engine.add( new PhysicsSystem() );
		engine.add( new SpriteRenderSystem( projection ));


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
