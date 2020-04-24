package com.flappybird.gibor.tomer.flappybird;

public class Pipe {
    private float x, y, length, width;
    private Sketch s;
    private static final float SPEED = 5;

    public Pipe(Sketch s, float x, float y, float length){
        this.s = s;
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = 50;
    }

    public void draw(){
        s.fill(0, 255, 0);
        s.rect(x, y, width, length);
    }

    public void update(){
        this.x -= SPEED;
    }

    public float getLength() {
        return this.length;
    }

    public float getX(){
        return this.x;
    }
    public boolean collision(Bird bird){
        return (bird.getX() + bird.getW() > this.x) && (bird.getX() < this.x + width)
                && (bird.getY() + bird.getH() > this.y) && (bird.getY() < this.y + this.length);
    }

    public float getWidth() {
        return width;
    }
}
