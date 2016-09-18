package stream.alwaysbecrafting.septembersun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SeptemberSun extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("fella.png");
	}

	@Override
	public void render () {
		int base03 = Solarized.BASE03;
		int r = (base03 & 0x00ff0000) >> 16;
		int g = (base03 & 0x0000ff00) >> 8;
		int b = (base03 & 0x000000ff);

		Gdx.gl.glClearColor(
				(1 / 255f) * r,
				(1 / 255f) * g,
				(1 / 255f) * b,
				1
		);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
