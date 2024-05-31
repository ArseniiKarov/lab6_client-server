package data;

import java.io.Serial;
import java.io.Serializable;

public class Location implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private Double x; //Поле не может быть null
    private float y;
    private float z;

    /**
     * Конструктор локации
     * @param x x
     * @param y y
     * @param z z
     */
    public Location(double x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location() {
    }

    /**
     * Метод для получения x
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Метод для получения y
     * @return y
     */
    public float getY() {
        return y;
    }

    /**
     * Метод для получения z
     * @return z
     */
    public float getZ() {
        return z;
    }
    /**
     * Метод для установки x
     * @param x x
     */
    public void setX(double x){
        this.x = x;
    }
    /**
     * Метод для установки y
     * @param y y
     */

    public void setY(float y){
        this.y = y;
    }

    /**
     * Метод для установки z
     * @param z z
     */
    public void setZ(float z){
        this.z = z;
    }
}
