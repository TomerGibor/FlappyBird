package com.flappybird.gibor.tomer.flappybird;

import java.util.Random;

public class PipeTwin {
    private Pipe pipe1, pipe2;
    private Sketch s;
    private float gap;
    private Random r;

    public PipeTwin(Sketch s, float x) {
        this.s = s;
        this.r = new Random();
        this.pipe1 = new Pipe(s, x, 0, this.r.nextFloat() * s.height / 2f + 200f);
        this.gap = 600;
        float p1len = pipe1.getLength();
        this.pipe2 = new Pipe(s, x, gap + p1len, s.height - gap - p1len);
    }

    public void draw(){
        this.pipe1.draw();
        this.pipe2.draw();
    }

    public void update(){
        this.pipe1.update();
        this.pipe2.update();
    }

    public float getX(){
        return pipe1.getX();
    }
    public boolean collision(Bird bird){
        return pipe1.collision(bird) || pipe2.collision(bird);
    }

    public float getWidth() {
        return pipe1.getWidth();
    }
}
