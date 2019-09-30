package com.kremek;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

public class KremekGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	private TiledMap map;
	private OrthoCachedTiledMapRenderer renderer;
	private OrthographicCamera camera;

	int camera_xpos;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		TmxMapLoader loader = new TmxMapLoader();
		map = loader.load("maps/kremek1.tmx");

		renderer = new OrthoCachedTiledMapRenderer(map);

		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		camera.viewportHeight = Gdx.graphics.getHeight();
		camera.viewportWidth = Gdx.graphics.getWidth();
		//camera.translate(camera.viewportWidth/2, camera.viewportHeight/2);
		camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2,0);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.position.set(camera_xpos, camera.viewportHeight/2,0);
		if(camera_xpos > camera.viewportWidth) camera_xpos = 0;
		camera_xpos += 8;
		camera.update();
		renderer.setView(camera);
		renderer.render();

//		batch.begin();
//		batch.draw(img, 0, 0, 1200, 1200);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
