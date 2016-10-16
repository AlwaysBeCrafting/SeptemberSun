package stream.alwaysbecrafting.septembersun.system.physics;

import com.badlogic.gdx.math.Rectangle;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.physics.BoundingBoxComponent;
import stream.alwaysbecrafting.septembersun.component.physics.CollisionComponent;
import stream.alwaysbecrafting.septembersun.data.Collision;

//==============================================================================
public class CollisionDetectionSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	private final Rectangle INTERSECTION = new Rectangle();

	//--------------------------------------------------------------------------

	@Override protected boolean acceptEntity( Entity entity ) {
		return entity.hasAny(
				CollisionComponent.class,
				BoundingBoxComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, double deltaTime ) {
		CollisionComponent collisionComp = entity.get( CollisionComponent.class );
		BoundingBoxComponent bboxComp = entity.get( BoundingBoxComponent.class );

		entity.getEngine().entityStream()
				.filter( other -> other != entity )
				.filter( other -> other.has( CollisionComponent.class ))
				.filter( other -> collisionComp.sharesLayer( other.get( CollisionComponent.class )))

				.filter( other -> other.has( BoundingBoxComponent.class ))
				.filter( other -> other.get( BoundingBoxComponent.class ).intersects( bboxComp, INTERSECTION ))

				.forEach( other -> {
					Collision c = new Collision();
					int centerX = (int)( INTERSECTION.x + ( INTERSECTION.width / 2 ));
					int centerY = (int)( INTERSECTION.y + ( INTERSECTION.height / 2 ));
					c.other = other;
					c.intersection.set( INTERSECTION );
					c.quadrant = getQuadrant( bboxComp.rect, centerX, centerY );
					collisionComp.collisions.add( c );
				} );
	}

	//--------------------------------------------------------------------------

	private byte getQuadrant( Rectangle bounds, int x, int y ) {
		float slope = 1f / bounds.getAspectRatio();
		float centerX = bounds.x + ( bounds.width / 2 );
		float centerY = bounds.y + ( bounds.height / 2 );
		float relativeX = x - centerX;
		float relativeY = y - centerY;

		return (byte)(
				(( relativeY > relativeX *  slope ) ? 0b01 : 0 )
		|       (( relativeY > relativeX * -slope ) ? 0b10 : 0 ));
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
