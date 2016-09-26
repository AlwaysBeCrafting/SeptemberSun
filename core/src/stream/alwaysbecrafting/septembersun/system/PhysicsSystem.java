package stream.alwaysbecrafting.septembersun.system;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
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

	@Override protected void onHandleEntity( Entity entity, float deltaTime ) {
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
