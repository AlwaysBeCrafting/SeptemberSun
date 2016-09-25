package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import stream.alwaysbecrafting.ecs.GameEngine;
import stream.alwaysbecrafting.ecs.EntitySystem;
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

	@Override protected void onHandleEntity( GameEngine engine, long entityId, float deltaTime ) {
		PositionComponent positionComp = engine.getComponent(
				entityId,
				PositionComponent.class );

		SpriteComponent spriteComp = engine.getComponent(
				entityId,
				SpriteComponent.class );

		batcher.draw(
				spriteComp.sprite,
				positionComp.x,
				positionComp.y );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
