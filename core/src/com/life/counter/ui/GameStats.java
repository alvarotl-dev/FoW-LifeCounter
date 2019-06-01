package com.life.counter.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStats extends HUDElement {

    private int lives;
    private Label livesLabel;

    public GameStats(float x, float y) {

        livesLabel = new Label("", x, y);
        lives = 4000;
        setLives();
    }

    public void setPosition()
    {

        if(lives >= 10000)
            livesLabel.position.x = 50;

        if(lives < 10000 || lives == 1000)
            livesLabel.position.x = 100;

        if(lives < 1000 || lives == 100)
            livesLabel.position.x = 150;

        if(lives < 100)
            livesLabel.position.x = 250;

    }


    public void resetLives(){
        lives = 4000;
        livesLabel.position.x = 100;
    }

    public void setLives() {
        setPosition();

        if(lives<0)
        {
            livesLabel.text = "0";
            lives = 0;
        }

        else
            livesLabel.text = "" + this.lives;
    }

    public void addLives(int multiplier) {
        this.lives += 100 * multiplier;
    }

    public void restLives(int multiplier) {
        this.lives -= 100 * multiplier;
    }

    @Override
    public void render(SpriteBatch batch) {
        livesLabel.render(batch);
    }
}
