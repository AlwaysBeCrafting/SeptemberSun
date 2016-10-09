package stream.alwaysbecrafting.septembersun.component.physics;

import java.util.LinkedHashSet;
import java.util.Set;

import stream.alwaysbecrafting.flare.Entity;

//==============================================================================
public class CollisionComponent {
	//--------------------------------------------------------------------------

	public Set<Entity> collisions = new LinkedHashSet<>();

	public int activeLayers = 0b0;
	public int passiveLayers = 0b1;

	//--------------------------------------------------------------------------

	public CollisionComponent() {}

	//--------------------------------------------------------------------------

	public CollisionComponent( int activeLayers, int passiveLayers ) {
		this.activeLayers = activeLayers;
		this.passiveLayers = passiveLayers;
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
