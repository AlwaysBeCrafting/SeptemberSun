package stream.alwaysbecrafting.septembersun;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Matrix4;

import stream.alwaysbecrafting.flare.GameEngine;
import stream.alwaysbecrafting.septembersun.system.input.PlayerInputSystem;
import stream.alwaysbecrafting.septembersun.system.physics.BoundingBoxPositioningSystem;
import stream.alwaysbecrafting.septembersun.system.physics.CollisionDetectionSystem;
import stream.alwaysbecrafting.septembersun.system.physics.GravitySystem;
import stream.alwaysbecrafting.septembersun.system.physics.MovementSystem;
import stream.alwaysbecrafting.septembersun.system.physics.SolidCollisionHandlerSystem;
import stream.alwaysbecrafting.septembersun.system.render.BackgroundRenderSystem;
import stream.alwaysbecrafting.septembersun.system.render.BoundsRenderSystem;
import stream.alwaysbecrafting.septembersun.system.render.SpriteRenderSystem;
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
		engine.add( new GravitySystem() );
		engine.add( new MovementSystem() );
		engine.add( new BoundingBoxPositioningSystem() );

		engine.add( new CollisionDetectionSystem() );
		engine.add( new SolidCollisionHandlerSystem() );

		engine.add( new SpriteRenderSystem( projection ));
		engine.add( new BoundsRenderSystem( projection ));


		engine.add( Entities.makePlayerCharacter() );
		engine.add( Entities.makeWall( 0, 0, 320, 40 ));
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
