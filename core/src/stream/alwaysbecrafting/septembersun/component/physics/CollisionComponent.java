package stream.alwaysbecrafting.septembersun.component.physics;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import stream.alwaysbecrafting.septembersun.data.Collision;

//==============================================================================
public class CollisionComponent {
	//--------------------------------------------------------------------------

	public Set<Collision> collisions = new LinkedHashSet<>();
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

	public boolean sharesLayer( CollisionComponent otherComp ) {
		return activeLayers.stream()
				.anyMatch( layer -> otherComp.passiveLayers.contains( layer ));
	}

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
