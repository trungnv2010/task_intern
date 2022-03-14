package com.example.DecoratorPattern;

public abstract class AcountDecorator implements Acount {
    protected Acount acount;
    public AcountDecorator(Acount acount){
        this.acount = acount;
    }
    public void draw(){
        acount.draw();
    }
}