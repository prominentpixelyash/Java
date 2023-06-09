package com.prominentpixel.extras;

public class Prominent {

    public static class pixel{
        public static <String> void println(String message){
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Prominent.pixel.println("Hello ProminentPixel");
    }

}
