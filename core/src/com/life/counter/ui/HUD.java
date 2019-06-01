package com.life.counter.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;


public class HUD {

    ArrayList<TextButton> buttons;
    ArrayList<HUDElement> labels;

    public HUD() {
        buttons = new ArrayList<TextButton>();
        labels = new ArrayList<HUDElement>();
    }

    public void add(TextButton go) {
        buttons.add(go);
    }

    public void add(HUDElement label) {
        labels.add(label);
    }

    public void render(SpriteBatch batch) {
        for (HUDElement he : buttons) {
            he.render(batch);
        }
        for (HUDElement he : labels) {
            he.render(batch);
        }
    }

    public boolean click(float x, float y) {

        for (TextButton b : buttons) {
            if (b.contains(x, y)) {
                b.click();
                return true;
            }
        }
        return false;
    }
}
