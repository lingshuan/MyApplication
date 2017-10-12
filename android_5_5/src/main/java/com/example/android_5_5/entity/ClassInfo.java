package com.example.android_5_5.entity;

/**
 * Created by Emily on 17/10/9.
 */

public class ClassInfo {
    private int pictrue;
    private String name;
    private boolean hasChecked;
    public ClassInfo(){

    }

    public int getPictrue() {
        return pictrue;
    }

    public void setPictrue(int Pictrue) {
        this.pictrue = pictrue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(boolean hasChecked) {
        this.hasChecked = hasChecked;
    }
}
