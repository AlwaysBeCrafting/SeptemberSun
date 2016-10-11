package stream.alwaysbecrafting.septembersun.system.physics;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.physics.PhysicalAttributesComponent;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.physics.VelocityComponent;

//==============================================================================
public class PhysicsSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	private float gravity = 1;

	//--------------------------------------------------------------------------

	@Override protected boolean acceptEntity( Entity entity ) {
		return entity.hasAll(
				PositionComponent.class,
				VelocityComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, double deltaTime ) {
		PhysicalAttributesComponent attribs = entity.get(PhysicalAttributesComponent.class );
		PositionComponent position = entity.get( PositionComponent.class );
		VelocityComponent velocity = entity.get( VelocityComponent.class );

		velocity.v -= ( attribs.weight * gravity );

		velocity.h *= attribs.friction;
		velocity.v *= attribs.friction;

		position.x += velocity.h;
		position.y += velocity.v;
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
