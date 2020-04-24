package com.flappybird.gibor.tomer.flappybird;


import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import processing.core.PImage;

public class Bird {
    private Sketch s;
    private float x, y, w, h, dy;


    public Bird(Sketch s, float x, float y, float w, float h) {
        this.s = s;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dy = 0;
    }

    public void draw(){
        s.fill(255, 255, 0);
        s.rect(x, y, w, h);
    }

    public float getW() {
        return w;
    }


    public float getH() {
        return h;
    }

    public float getX() {

        return x;
    }

    public float getY() {
        return y;
    }

    public void update() {
        this.y += this.dy;
        this.dy += 1.5;
        if(this.y < 0)
            this.y = 0;
    }

    public void jump(){
       this.dy = -30;
    }
}
