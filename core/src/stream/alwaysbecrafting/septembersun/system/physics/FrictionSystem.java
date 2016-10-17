package stream.alwaysbecrafting.septembersun.system.physics;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.physics.FrictionComponent;
import stream.alwaysbecrafting.septembersun.component.physics.VelocityComponent;

//==============================================================================
public class FrictionSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	@Override protected boolean acceptEntity( Entity entity ) {
		return entity.hasAll(
				VelocityComponent.class,
				FrictionComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, double deltaTime ) {
		VelocityComponent veloComp = entity.get( VelocityComponent.class );
		FrictionComponent frictionComp = entity.get( FrictionComponent.class );

		veloComp.h *= frictionComp.hMultiplier;
		veloComp.v *= frictionComp.vMultiplier;
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
