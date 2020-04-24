package com.flappybird.gibor.tomer.flappybird;

import android.util.Log;


import java.util.concurrent.ArrayBlockingQueue;

import processing.core.PApplet;

public class Sketch extends PApplet {
    private static final float WIDTH2BIRD_RATIO = 0.08f;

    private Bird bird;
    private ArrayBlockingQueue<PipeTwin> pipes;
    private static final int SPACING = 800;
    private static int score;
    private static boolean passed;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        orientation(PORTRAIT);
        init();
    }

    public void init(){
        this.bird = new Bird(this,
                width * WIDTH2BIRD_RATIO,
                height / 2 - width * WIDTH2BIRD_RATIO * 2 ,
                width * WIDTH2BIRD_RATIO,
                width * WIDTH2BIRD_RATIO);
        this.pipes = new ArrayBlockingQueue<>(4);
        int cap = pipes.remainingCapacity();
        for(int i = 0; i < cap; i++){
            pipes.add(new PipeTwin(this, width + SPACING * i));
        }
        score = 0;
        passed = false;
    }

    public void draw() {
        background(0);
        if(pipes.peek().collision(bird) || bird.getY() + bird.getH() > height)
            init();
        bird.update();
        bird.draw();
        for (PipeTwin pipe: pipes) {
            pipe.update();
            pipe.draw();
        }
        if(pipes.peek().getX() + pipes.peek().getWidth() < bird.getX()) {
            if(!passed)
                score++;
            passed = true;
        }
        if(pipes.peek().getX() < -20) {
            pipes.poll();
            float lastX = ((PipeTwin)pipes.toArray()[pipes.size() - 1]).getX();
            pipes.add(new PipeTwin(this, lastX + SPACING));
            passed = false;
        }
        fill(255);
        textSize(72);
        text("Score: " + score,width - 400, 100);
    }

    @Override
    public void touchEnded() {
        super.touchEnded();
        bird.jump();
    }
}