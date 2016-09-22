package stream.alwaysbecrafting.septembersun.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.HashSet;
import java.util.Set;

import stream.alwaysbecrafting.ecs.GameEngine;
import stream.alwaysbecrafting.ecs.system.EntitySystem;
import stream.alwaysbecrafting.septembersun.component.PlayerControllerComponent;
import stream.alwaysbecrafting.septembersun.component.PositionComponent;
import stream.alwaysbecrafting.septembersun.util.Log;

//==============================================================================
public class PlayerInputSystem extends EntitySystem implements InputProcessor {
	//--------------------------------------------------------------------------

	private final Set<Integer> KEYS_PRESSED  = new HashSet<>();
	private final Set<Integer> KEYS_RELEASED = new HashSet<>();

	//--------------------------------------------------------------------------

	public PlayerInputSystem() {
		includeAll(
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

	@Override protected void onHandleEntity( GameEngine engine, long entityId, float deltaTime ) {
		PlayerControllerComponent controllerComp = engine.getComponent( entityId, PlayerControllerComponent.class );
		PositionComponent positionComp = engine.getComponent( entityId, PositionComponent.class );

		if ( KEYS_PRESSED.contains( controllerComp.btn_down )) {
			positionComp.position.add( 0, -20 );
		}

		if ( KEYS_PRESSED.contains( controllerComp.btn_up )) {
			positionComp.position.add( 0, 20 );
		}


		if ( KEYS_PRESSED.contains( controllerComp.btn_left )) {
			positionComp.position.add( -20, 0 );
		}

		if ( KEYS_PRESSED.contains( controllerComp.btn_right )) {
			positionComp.position.add( 20, 0 );
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
