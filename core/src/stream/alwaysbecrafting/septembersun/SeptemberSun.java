package stream.alwaysbecrafting.septembersun;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.SpriteComponent;
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


		Texture tex = new Texture( "fella.png" );

		Entity e = new Entity();

		e.add( new PositionComponent() );
		e.add( new SpriteComponent( tex ));

		engine.addEntity( e );
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
