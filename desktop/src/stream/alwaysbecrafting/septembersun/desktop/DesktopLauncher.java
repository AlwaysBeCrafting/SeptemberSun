package stream.alwaysbecrafting.septembersun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import stream.alwaysbecrafting.septembersun.SeptemberSun;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 320;
		config.height = 180;


		new LwjglApplication(new SeptemberSun(), config);
	}
}
