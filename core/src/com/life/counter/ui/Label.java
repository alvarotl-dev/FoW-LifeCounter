package com.life.counter.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.life.counter.Assets;

public class Label extends HUDElement {

    public String text;

    public Label(String text, float x, float y) {
        this.text = text;
        this.position = new Vector2(x, y);
    }

    @Override
    public void render(SpriteBatch batch) {
        Assets.getInstance().GameFont.draw(batch, text, position.x, position.y);
    }
}
