package stream.alwaysbecrafting.septembersun.util;

import com.badlogic.gdx.graphics.Texture;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.septembersun.component.input.PlayerControllerComponent;
import stream.alwaysbecrafting.septembersun.component.physics.BoundingBoxComponent;
import stream.alwaysbecrafting.septembersun.component.physics.CollisionComponent;
import stream.alwaysbecrafting.septembersun.component.physics.PhysicalAttributesComponent;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.physics.VelocityComponent;
import stream.alwaysbecrafting.septembersun.component.render.ColorFillComponent;
import stream.alwaysbecrafting.septembersun.component.render.SpriteComponent;

//==============================================================================
public abstract class Entities {
	//--------------------------------------------------------------------------

	public static Entity makePlayerCharacter() {
		return new Entity(
				new PositionComponent( 50, 50 ),
				new BoundingBoxComponent( 0, 0, 16, 16 ),

				new PhysicalAttributesComponent(),
				new VelocityComponent( 1, 0 ),
				new CollisionComponent( 0b111 ),

				new SpriteComponent( new Texture( "fella.png" )),

				new PlayerControllerComponent() );
	}

	//--------------------------------------------------------------------------

	public static Entity makeWall( int x, int y, int w, int h ) {
		return new Entity(
				new BoundingBoxComponent( x, y, w, h ),

				new CollisionComponent( 0b001 ),
				new ColorFillComponent( Colors.Solarized.BASE1 ));
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
