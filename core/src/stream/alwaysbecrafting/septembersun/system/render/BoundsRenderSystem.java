package stream.alwaysbecrafting.septembersun.system.render;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.flare.GameEngine;
import stream.alwaysbecrafting.septembersun.component.physics.BoundingBoxComponent;
import stream.alwaysbecrafting.septembersun.component.render.ColorFillComponent;
import stream.alwaysbecrafting.septembersun.util.Colors;

//==============================================================================
public class BoundsRenderSystem extends EntitySystem {
	//--------------------------------------------------------------------------

	private final ShapeRenderer SHAPE = new ShapeRenderer();

	//--------------------------------------------------------------------------

	public BoundsRenderSystem( Matrix4 projection ) {
		SHAPE.setProjectionMatrix( projection );

		requireAll(
				BoundingBoxComponent.class,
				ColorFillComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override public void onUpdate( GameEngine engine, float deltaTime ) {
		SHAPE.begin( ShapeRenderer.ShapeType.Filled );

		super.onUpdate( engine, deltaTime );

		SHAPE.end();
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, float deltaTime ) {
		Rectangle box = entity.get( BoundingBoxComponent.class ).rect;
		int color = entity.get( ColorFillComponent.class ).color;

		SHAPE.setColor(
				Colors.r( color ),
				Colors.g( color ),
				Colors.b( color ),
				Colors.a( color ));

		SHAPE.rect( box.x, box.y, box.width, box.height );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
