package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.ashley.core.ComponentMapper;
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

	private final ComponentMapper<PositionComponent> POSITION_MAPPER;
	private final ComponentMapper<SpriteComponent> SPRITE_MAPPER;

	private SpriteBatch batcher;

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

		POSITION_MAPPER = ComponentMapper.getFor( PositionComponent.class );
		SPRITE_MAPPER = ComponentMapper.getFor( SpriteComponent.class );
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
		PositionComponent positionComp = POSITION_MAPPER.get( entity );
		SpriteComponent spriteComp = SPRITE_MAPPER.get( entity );

		batcher.draw(
				spriteComp.sprite,
				positionComp.position.x,
				positionComp.position.y );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
