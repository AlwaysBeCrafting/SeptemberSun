package stream.alwaysbecrafting.septembersun.system.physics;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.physics.CollisionComponent;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.physics.VelocityComponent;

import static stream.alwaysbecrafting.septembersun.data.Collision.BOTTOM;
import static stream.alwaysbecrafting.septembersun.data.Collision.LEFT;
import static stream.alwaysbecrafting.septembersun.data.Collision.RIGHT;
import static stream.alwaysbecrafting.septembersun.data.Collision.TOP;

//==============================================================================
public class SolidCollisionHandlerSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	@Override protected boolean acceptEntity( Entity entity ) {
		return entity.hasAll(
				PositionComponent.class,
				VelocityComponent.class,
				CollisionComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, double deltaTime ) {
		PositionComponent positionComp = entity.get( PositionComponent.class );
		VelocityComponent velocityComp = entity.get( VelocityComponent.class );
		CollisionComponent collisionComp = entity.get( CollisionComponent.class );

		collisionComp.collisions.forEach( collision -> {
			if ( collision.quadrant == LEFT ) {
				positionComp.x += collision.intersection.width;
				velocityComp.h = 0;
			}
			if ( collision.quadrant == TOP ) {
				positionComp.y -= collision.intersection.height;
				velocityComp.v = 0;
			}
			if ( collision.quadrant == RIGHT ) {
				positionComp.x -= collision.intersection.width;
				velocityComp.h = 0;
			}
			if ( collision.quadrant == BOTTOM ) {
				positionComp.y += collision.intersection.height;
				velocityComp.v = 0;
			}
		} );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
