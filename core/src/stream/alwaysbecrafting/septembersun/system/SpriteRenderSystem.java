package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.flare.GameEngine;
import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.SpriteComponent;

//==============================================================================
public class SpriteRenderSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	private SpriteBatch batcher;

	//--------------------------------------------------------------------------

	public SpriteRenderSystem() {
		requireAll(
				PositionComponent.class,
				SpriteComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override public void onStart( GameEngine engine ) {
		batcher = new SpriteBatch();
	}

	//--------------------------------------------------------------------------

	@Override public void onUpdate( GameEngine engine, float deltaTime ) {
		batcher.begin();

		super.onUpdate( engine, deltaTime );

		batcher.end();
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, float deltaTime ) {
		PositionComponent positionComp = entity.get( PositionComponent.class );

		SpriteComponent spriteComp = entity.get( SpriteComponent.class );

		batcher.draw(
				spriteComp.sprite,
				positionComp.x,
				positionComp.y );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
