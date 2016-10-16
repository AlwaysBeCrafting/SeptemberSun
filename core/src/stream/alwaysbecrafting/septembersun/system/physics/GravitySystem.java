package stream.alwaysbecrafting.septembersun.system.physics;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.physics.GravityComponent;
import stream.alwaysbecrafting.septembersun.component.physics.VelocityComponent;

//==============================================================================
public class GravitySystem extends EntitySystem {
	//--------------------------------------------------------------------------

	@Override protected boolean acceptEntity( Entity entity ) {
		return entity.hasAll(
				VelocityComponent.class,
				GravityComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, double deltaTime ) {
		VelocityComponent velocityComp = entity.get( VelocityComponent.class );
		GravityComponent gravityComp = entity.get( GravityComponent.class );

		velocityComp.v -= gravityComp.strength;
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
