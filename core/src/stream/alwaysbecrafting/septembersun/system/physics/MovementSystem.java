package stream.alwaysbecrafting.septembersun.system.physics;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.physics.VelocityComponent;

//==============================================================================
public class MovementSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	@Override protected boolean acceptEntity( Entity entity ) {
		return entity.hasAll(
				VelocityComponent.class,
				PositionComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, double deltaTime ) {
		VelocityComponent velocityComp = entity.get( VelocityComponent.class );
		PositionComponent positionComp = entity.get( PositionComponent.class );

		positionComp.x += velocityComp.h;
		positionComp.y += velocityComp.v;
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
