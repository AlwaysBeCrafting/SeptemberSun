package stream.alwaysbecrafting.septembersun.system.physics;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.physics.CollisionComponent;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;
import stream.alwaysbecrafting.septembersun.util.Log;

//==============================================================================
public class SolidCollisionHandlerSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	@Override protected boolean acceptEntity( Entity entity ) {
		return entity.hasAll(
				PositionComponent.class,
				CollisionComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, double deltaTime ) {
		PositionComponent positionComp = entity.get( PositionComponent.class );
		CollisionComponent collisionComp = entity.get( CollisionComponent.class );

		collisionComp.collisions.forEach( collision -> {
			Log.d( "A collision has occured!" );
		} );

		collisionComp.collisions.clear();
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
