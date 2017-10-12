package com.example.android_5_4.entity;

/**
 * Created by Emily on 17/10/9.
 */

public class ClassInfo {
    private int head;
    private String name;
    private String phone;
    private boolean hasChecked;
    public ClassInfo(){

    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(boolean hasChecked) {
        this.hasChecked = hasChecked;
    }
}
