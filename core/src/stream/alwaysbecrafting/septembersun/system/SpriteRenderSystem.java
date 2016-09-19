package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.SpriteComponent;

//==============================================================================
public class SpriteRenderSystem extends IteratingSystem {
	//--------------------------------------------------------------------------

	SpriteBatch batcher;

	//--------------------------------------------------------------------------

	public static SpriteRenderSystem create() {
		Family family = Family.all(
				PositionComponent.class,
				SpriteComponent.class )
				.get();

		return new SpriteRenderSystem( family );
	}

	//--------------------------------------------------------------------------

	private SpriteRenderSystem( Family family ) {
		super( family );
	}

	//--------------------------------------------------------------------------

	@Override public void addedToEngine( Engine e ) {
		super.addedToEngine( e );
		batcher = new SpriteBatch();
	}

	//--------------------------------------------------------------------------

	@Override public void update( float deltaTime ) {
		batcher.begin();

		super.update( deltaTime );

		batcher.end();
	}

	//--------------------------------------------------------------------------

	@Override protected void processEntity( Entity entity, float deltaTime ) {
		// batcher.draw( texture, x, y );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
