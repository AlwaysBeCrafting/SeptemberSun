package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.SpriteComponent;

//==============================================================================
public class SpriteRenderSystem extends IteratingSystem {
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

	@Override protected void processEntity( Entity entity, float deltaTime ) {
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
