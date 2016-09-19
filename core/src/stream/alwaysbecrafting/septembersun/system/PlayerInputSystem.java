package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.HashSet;
import java.util.Set;

import stream.alwaysbecrafting.septembersun.component.PlayerControllerComponent;
import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.util.Log;

//==============================================================================
public class PlayerInputSystem extends IteratingSystem implements InputProcessor {
	//--------------------------------------------------------------------------

	private final Set<Integer> KEYS_PRESSED  = new HashSet<>();
	private final Set<Integer> KEYS_RELEASED = new HashSet<>();

	//--------------------------------------------------------------------------

	public static PlayerInputSystem create() {
		Family family = Family
				.all(
						PlayerControllerComponent.class,
						PositionComponent.class )
				.get();

		return new PlayerInputSystem( family );
	}

	//--------------------------------------------------------------------------

	private PlayerInputSystem( Family family ) {
		super( family );
	}

	//--------------------------------------------------------------------------

	@Override public void addedToEngine( Engine e ) {
		super.addedToEngine( e );
		Gdx.input.setInputProcessor( this );
	}

	//--------------------------------------------------------------------------

	@Override public void update( float deltaTime ) {
		super.update( deltaTime );
		KEYS_PRESSED.clear();
		KEYS_RELEASED.clear();
	}

	//--------------------------------------------------------------------------

	@Override protected void processEntity( Entity entity, float deltaTime ) {
	}

	//--------------------------------------------------------------------------

	@Override public boolean keyDown( int keycode ) {
		KEYS_PRESSED.add( keycode );
		Log.d( "KeyP: " + keycode );

		return true;
	}

	//--------------------------------------------------------------------------

	@Override public boolean keyUp( int keycode ) {
		KEYS_RELEASED.add( keycode );
		Log.d( "KeyR: " + keycode );

		return true;
	}

	//--------------------------------------------------------------------------

	@Override public boolean keyTyped( char character ) { return false; }
	@Override public boolean touchDown( int screenX, int screenY, int pointer, int button ) { return false; }
	@Override public boolean touchUp( int screenX, int screenY, int pointer, int button ) { return false; }
	@Override public boolean touchDragged( int screenX, int screenY, int pointer ) { return false; }
	@Override public boolean mouseMoved( int screenX, int screenY ) { return false; }
	@Override public boolean scrolled( int amount ) { return false; }

	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
