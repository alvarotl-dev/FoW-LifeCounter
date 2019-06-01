package com.life.counter.gameobject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {

    public Vector2 position;
    public Vector2 dimension;

    Vector2 speed;
    private Rectangle bounds;

    GameObject() {
        position = new Vector2(0, 0);
        dimension = new Vector2(1, 1);
        speed = new Vector2(0, 0);
        bounds = new Rectangle();
    }

    public Rectangle getBounds() {
        bounds.set(position.x, position.y, dimension.x, dimension.y);
        return bounds;
    }

    public Vector2 getCenter() {
        return new Vector2(this.position.x + this.dimension.x / 2, this.position.y + this.dimension.y / 2);
    }

    public abstract void render(SpriteBatch batch);

    public abstract void update(float elapsedTime);


}
	
