package com.prominentpixel.serialization;

import java.util.Objects;

public class Juniors extends  Student{

    private int jrId;
    private String tag;

    public Juniors() {
    }

    public Juniors(int jrId, String tag) {
        this.jrId = jrId;
        this.tag = tag;
    }

    public int getJrId() {
        return jrId;
    }

    public void setJrId(int jrId) {
        this.jrId = jrId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Juniors juniors = (Juniors) o;
        return jrId == juniors.jrId && Objects.equals(tag, juniors.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jrId, tag);
    }

    @Override
    public String toString() {
        return "Juniors{" +
                "jrId=" + jrId +
                ", tag='" + tag + '\'' +
                '}';
    }
}
