package stream.alwaysbecrafting.septembersun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

import stream.alwaysbecrafting.ecs.GameEngine;
import stream.alwaysbecrafting.septembersun.component.PlayerControllerComponent;
import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.SpriteComponent;
import stream.alwaysbecrafting.septembersun.component.VelocityComponent;
import stream.alwaysbecrafting.septembersun.system.BackgroundRenderSystem;
import stream.alwaysbecrafting.septembersun.system.PhysicsSystem;
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
		engine.add( new PlayerInputSystem() );
		engine.add( new PhysicsSystem() );
		engine.add( new SpriteRenderSystem() );


		Texture tex = new Texture( "fella.png" );

		engine.createEntity(
				new PositionComponent( 20, 20 ),
				new SpriteComponent( tex ),
				new PlayerControllerComponent() );

		engine.createEntity(
				new PositionComponent( 50, 50 ),
				new VelocityComponent( 1, 0 ),
				new SpriteComponent( tex ));
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
