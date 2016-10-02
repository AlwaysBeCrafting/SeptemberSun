package stream.alwaysbecrafting.septembersun.util;

import com.badlogic.gdx.graphics.Texture;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.septembersun.component.PhysicalAttributesComponent;
import stream.alwaysbecrafting.septembersun.component.PlayerControllerComponent;
import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.component.SpriteComponent;
import stream.alwaysbecrafting.septembersun.component.VelocityComponent;

//==============================================================================
public abstract class Entities {
	//--------------------------------------------------------------------------

	public static Entity makePlayerCharacter() {
		return new Entity(
				new PositionComponent( 50, 50 ),

				new PhysicalAttributesComponent(),
				new VelocityComponent( 1, 0 ),

				new SpriteComponent( new Texture( "fella.png" )),

				new PlayerControllerComponent() );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
