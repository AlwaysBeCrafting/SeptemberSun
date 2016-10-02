package stream.alwaysbecrafting.septembersun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import stream.alwaysbecrafting.septembersun.SeptemberSun;

public class DesktopLauncher {
	public static void main( String[] arg ) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;


		new LwjglApplication( new SeptemberSun(), config );
	}
}
