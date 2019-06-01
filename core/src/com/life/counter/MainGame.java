package com.life.counter;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.life.counter.ui.GameStats;
import com.life.counter.ui.HUD;
import com.life.counter.ui.TextButton;

public class MainGame extends InputAdapter implements ApplicationListener {

    OrthographicCamera camera1;
    OrthographicCamera hudCamera;

    HUD hud;

    SpriteBatch batch;

    GameStats gameStats;

    @Override
    public void create() {


        camera1 = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        hudCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        batch = new SpriteBatch();

        createHUD();

        Gdx.input.setInputProcessor(this);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }

    private void createHUD() {
        hud = new HUD();
        gameStats = new GameStats(100, 350);
        hud.add(gameStats);


        TextButton b1 = new TextButton("+1", 10, 10, 40, 40) {
            @Override
            public void click() {
                gameStats.addLives(1);
                gameStats.setLives();
            }
        };

        TextButton b2 = new TextButton("-1",60, 10, 40, 40) {
            @Override
            public void click() {
                gameStats.restLives(1);
                gameStats.setLives();

            }
        };

        TextButton b3 = new TextButton("+5",110, 10, 50, 40) {
            @Override
            public void click() {
                gameStats.addLives(5);
                gameStats.setLives();
            }
        };

        TextButton b4 = new TextButton("-5",170, 10, 50, 40) {
            @Override
            public void click() {
                gameStats.restLives(5);
                gameStats.setLives();
            }
        };

        TextButton b5 = new TextButton("+10",230, 10, 80, 40) {
            @Override
            public void click() {
                gameStats.addLives(10);
                gameStats.setLives();
            }
        };

        TextButton b6 = new TextButton("-10",320, 10, 80, 40) {
            @Override
            public void click() {
                gameStats.restLives(10);
                gameStats.setLives();
            }
        };

        TextButton b7 = new TextButton("RESET",470, 10, 140, 40) {
            @Override
            public void click() {
                gameStats.resetLives();
                gameStats.setLives();
            }
        };


        hud.add(b1);
        hud.add(b2);
        hud.add(b3);
        hud.add(b4);
        hud.add(b5);
        hud.add(b6);
        hud.add(b7);

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0f, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //render HUD
        batch.setProjectionMatrix(hudCamera.combined);
        batch.begin();
        hud.render(batch);
        batch.end();

    }

    public void resize(int width, int height) {

        System.out.println("Resize to:" + width + "x" + height);

        camera1.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
        camera1.update();

        hudCamera.viewportWidth = width;
        hudCamera.viewportHeight = height;

        //0,0 in the lower left corner
        hudCamera.position.x = width / 2;
        hudCamera.position.y = height / 2;
        hudCamera.update();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    //those are created outside the method, to avoid Garbage generation!
    // they exist during the whole execution of the game
    Vector3 pointHUD;
    Vector3 pointGame;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        //screen touched, corresponds to a HUD button?
        pointHUD = new Vector3(screenX, screenY, 0);

        //check if the click is for the HUD
        hudCamera.unproject(pointHUD);
        if (!hud.click(pointHUD.x, pointHUD.y)) {

            //the click is not for the HUD, check if it is for the cards!
            pointGame = new Vector3(screenX, screenY, 0);
            camera1.unproject(pointGame);
        }
        return true;
    }
}
