package stream.alwaysbecrafting.septembersun.system.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.flare.GameEngine;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.render.SpriteComponent;

//==============================================================================
public class SpriteRenderSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	private SpriteBatch batcher = new SpriteBatch();

	//--------------------------------------------------------------------------

	public SpriteRenderSystem( Matrix4 projection ) {
		batcher.setProjectionMatrix( projection );
		requireAll(
				PositionComponent.class,
				SpriteComponent.class );
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
