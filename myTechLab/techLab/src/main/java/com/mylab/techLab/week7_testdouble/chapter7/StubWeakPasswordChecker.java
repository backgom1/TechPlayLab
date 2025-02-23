package com.mylab.techLab.week7_testdouble.chapter7;

public class StubWeakPasswordChecker implements WeakPasswordChecker {

    private boolean weak;

    public void setWeak(boolean b) {
        this.weak = b;
    }

    @Override
    public boolean checkPassword(String password) {
        return weak;
    }
}
