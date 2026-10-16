package edu.itc.se.lab01.Task3;

public record Order(int id, String item, int qty) {
    public static final int poison_id = -1;
    public boolean ispoison(){
        return id == poison_id;
    }
}
