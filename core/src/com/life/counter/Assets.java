package com.life.counter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Assets {

    public Texture box;
    public Texture coin;
    public Texture button;
    public BitmapFont HUDfont;
    public BitmapFont GameFont;
    public Texture cloud;

    private static Assets instance;


    private Assets() {

        button = createButtonTexture();
        HUDfont = new BitmapFont();
        HUDfont.getData().setScale(2);


        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("TWBOZ.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 210;
        GameFont = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!


    }


    private Texture createButtonTexture() {
        Pixmap pm = new Pixmap(10, 10, Pixmap.Format.RGBA8888);
        pm.setColor(0.1f, 0.1f, 0.1f, 1);
        pm.drawRectangle(0, 0, 10, 10);
        pm.setColor(0.5f, 0f, 0, 1);
        pm.fillRectangle(1, 1, 8, 8);
        return new Texture(pm);
    }


    public static Assets getInstance() {

        if (instance == null)
            instance = new Assets();

        return instance;

    }
}
