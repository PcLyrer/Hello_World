package com.lxstudy;

/**
 * @author Lexie
 * @version 1.0
 */

public class Car {
    public String brand = "BWM";
    public int price = 300000;
    public String color = "White";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
