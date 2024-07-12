package com.java.string.scjp;

public final class Immutable {
    private final int i;

    public Immutable(int i) {
        this.i = i;
    }

    public Immutable modify(int i) {
        if (this.i == i) {
            return this;
        } else {
            return new Immutable(i);
        }
    }

    public int getI() {
        return i;
    }
}
