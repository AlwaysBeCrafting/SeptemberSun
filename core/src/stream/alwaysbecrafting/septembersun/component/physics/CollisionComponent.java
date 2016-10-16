package stream.alwaysbecrafting.septembersun.component.physics;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import stream.alwaysbecrafting.flare.Entity;

//==============================================================================
public class CollisionComponent {
	//--------------------------------------------------------------------------

	public Set<Entity> collisions = new LinkedHashSet<>();
	public Set<String> activeLayers = new HashSet<>();
	public Set<String> passiveLayers = new HashSet<>();

	//--------------------------------------------------------------------------

	public CollisionComponent() {}

	//--------------------------------------------------------------------------

	public CollisionComponent( String[] activeLayers, String[] passiveLayers ) {
		Collections.addAll( this.activeLayers, activeLayers );
		Collections.addAll( this.passiveLayers, passiveLayers );
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
