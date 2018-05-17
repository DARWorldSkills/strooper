package com.aprendiz.ragp.strooper.models;

public class ColorJ {
    private String palabra;
    private int color;

    public ColorJ() {
    }

    public ColorJ(String palabra, int color) {
        this.palabra = palabra;
        this.color = color;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
