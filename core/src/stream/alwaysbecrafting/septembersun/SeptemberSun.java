package stream.alwaysbecrafting.septembersun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

import stream.alwaysbecrafting.ecs.GameEngine;
import stream.alwaysbecrafting.septembersun.component.PlayerControllerComponent;
import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.SpriteComponent;
import stream.alwaysbecrafting.septembersun.system.BackgroundRenderSystem;
import stream.alwaysbecrafting.septembersun.system.PlayerInputSystem;
import stream.alwaysbecrafting.septembersun.system.SpriteRenderSystem;


//==============================================================================
public class SeptemberSun extends ApplicationAdapter {
	//--------------------------------------------------------------------------

	GameEngine engine;

	//--------------------------------------------------------------------------

	@Override public void create() {
		super.create();

		engine = new GameEngine();

		engine.add( new BackgroundRenderSystem() );
		engine.add( new SpriteRenderSystem() );
		engine.add( new PlayerInputSystem() );


		Texture tex = new Texture( "fella.png" );

		engine.createEntity(
				new PositionComponent( 20, 20 ),
				new SpriteComponent( tex ),
				new PlayerControllerComponent() );
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
