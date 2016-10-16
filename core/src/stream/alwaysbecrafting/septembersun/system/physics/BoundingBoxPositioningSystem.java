package stream.alwaysbecrafting.septembersun.system.physics;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.physics.BoundingBoxComponent;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;

//==============================================================================
public class BoundingBoxPositioningSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	@Override protected boolean acceptEntity( Entity entity ) {
		return entity.hasAll(
				BoundingBoxComponent.class,
				PositionComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, double deltaTime ) {
		BoundingBoxComponent bboxComp = entity.get( BoundingBoxComponent.class );
		PositionComponent positionComp = entity.get( PositionComponent.class );

		bboxComp.rect.setPosition(
				positionComp.x - bboxComp.origin.x,
				positionComp.y - bboxComp.origin.y );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
