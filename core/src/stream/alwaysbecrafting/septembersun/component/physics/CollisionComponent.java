package stream.alwaysbecrafting.septembersun.component.physics;

import java.util.LinkedHashSet;
import java.util.Set;

import stream.alwaysbecrafting.flare.Entity;

//==============================================================================
public class CollisionComponent {
	//--------------------------------------------------------------------------

	public Set<Entity> collisions = new LinkedHashSet<>();

	public int layers = 0b1;

	//--------------------------------------------------------------------------

	public CollisionComponent() {}

	//--------------------------------------------------------------------------

	public CollisionComponent( int layers ) {
		this.layers = layers;
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
