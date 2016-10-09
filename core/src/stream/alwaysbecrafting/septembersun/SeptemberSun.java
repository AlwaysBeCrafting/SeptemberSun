package stream.alwaysbecrafting.septembersun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.GameEngine;
import stream.alwaysbecrafting.septembersun.component.physics.PhysicalAttributesComponent;
import stream.alwaysbecrafting.septembersun.component.input.PlayerControllerComponent;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.render.SpriteComponent;
import stream.alwaysbecrafting.septembersun.component.physics.VelocityComponent;
import stream.alwaysbecrafting.septembersun.system.render.BackgroundRenderSystem;
import stream.alwaysbecrafting.septembersun.system.physics.PhysicsSystem;
import stream.alwaysbecrafting.septembersun.system.input.PlayerInputSystem;
import stream.alwaysbecrafting.septembersun.system.render.SpriteRenderSystem;


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


		Texture tex = new Texture( "fella.png" );

		Entity playerCharacter = new Entity(
				new PositionComponent( 20, 20 ),
				new SpriteComponent( tex ),
				new PlayerControllerComponent() );

		Entity physicsCharacter = new Entity(
				new PhysicalAttributesComponent(),
				new PositionComponent( 50, 50 ),
				new VelocityComponent( 1, 0 ),
				new SpriteComponent( tex ));

		engine.add( playerCharacter );
		engine.add( physicsCharacter );
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
