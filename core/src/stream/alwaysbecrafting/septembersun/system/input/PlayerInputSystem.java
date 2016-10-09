package stream.alwaysbecrafting.septembersun.system.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.HashSet;
import java.util.Set;

import stream.alwaysbecrafting.flare.Entity;
import stream.alwaysbecrafting.flare.EntitySystem;
import stream.alwaysbecrafting.flare.GameEngine;
import stream.alwaysbecrafting.septembersun.component.input.PlayerControllerComponent;
import stream.alwaysbecrafting.septembersun.component.physics.PositionComponent;
import stream.alwaysbecrafting.septembersun.util.Log;

//==============================================================================
public class PlayerInputSystem extends EntitySystem implements InputProcessor {
	//--------------------------------------------------------------------------

	private final Set<Integer> KEYS_PRESSED  = new HashSet<>();
	private final Set<Integer> KEYS_RELEASED = new HashSet<>();

	//--------------------------------------------------------------------------

	public PlayerInputSystem() {
		requireAll(
				PlayerControllerComponent.class,
				PositionComponent.class );
	}

	//--------------------------------------------------------------------------

	@Override public void onStart( GameEngine engine ) {
		super.onStart( engine );
		Gdx.input.setInputProcessor( this );
	}

	//--------------------------------------------------------------------------

	@Override public void onUpdate( GameEngine engine, float deltaTime ) {
		super.onUpdate( engine, deltaTime );

		KEYS_PRESSED.clear();
		KEYS_RELEASED.clear();
	}

	//--------------------------------------------------------------------------

	@Override protected void onHandleEntity( Entity entity, float deltaTime ) {
		PlayerControllerComponent controllerComp = entity.get( PlayerControllerComponent.class );
		PositionComponent positionComp = entity.get( PositionComponent.class );

		if ( KEYS_PRESSED.contains( controllerComp.btn_down )) {
			positionComp.y -= 20;
		}

		if ( KEYS_PRESSED.contains( controllerComp.btn_up )) {
			positionComp.y += 20;
		}


		if ( KEYS_PRESSED.contains( controllerComp.btn_left )) {
			positionComp.x -= 20;
		}

		if ( KEYS_PRESSED.contains( controllerComp.btn_right )) {
			positionComp.x += 20;
		}
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
