package stream.alwaysbecrafting.septembersun.system;

import stream.alwaysbecrafting.ecs.EntitySystem;
import stream.alwaysbecrafting.ecs.GameEngine;
import stream.alwaysbecrafting.septembersun.component.PhysicalAttributesComponent;
import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.VelocityComponent;

//==============================================================================
public class PhysicsSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	private float gravity = 1;

	//--------------------------------------------------------------------------

	public PhysicsSystem() {
		requireAll(
				PositionComponent.class,
				VelocityComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( GameEngine engine, long entityId, float deltaTime ) {
		PhysicalAttributesComponent attribs = engine.getComponent( entityId, PhysicalAttributesComponent.class );
		PositionComponent position = engine.getComponent( entityId, PositionComponent.class );
		VelocityComponent velocity = engine.getComponent( entityId, VelocityComponent.class );

		velocity.v -= ( attribs.weight * gravity );

		velocity.h *= attribs.friction;
		velocity.v *= attribs.friction;

		position.x += velocity.h;
		position.y += velocity.v;
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
