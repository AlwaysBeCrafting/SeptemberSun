package stream.alwaysbecrafting.septembersun.system;

import stream.alwaysbecrafting.ecs.EntitySystem;
import stream.alwaysbecrafting.ecs.GameEngine;
import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.VelocityComponent;

//==============================================================================
public class PhysicsSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	public PhysicsSystem() {
		requireAll(
				PositionComponent.class,
				VelocityComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( GameEngine engine, long entityId, float deltaTime ) {
		PositionComponent position = engine.getComponent( entityId, PositionComponent.class );
		VelocityComponent velocity = engine.getComponent( entityId, VelocityComponent.class );

		position.x += velocity.h;
		position.y += velocity.v;
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
