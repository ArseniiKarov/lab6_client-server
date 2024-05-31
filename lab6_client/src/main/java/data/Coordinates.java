package data;

import java.io.Serial;
import java.io.Serializable;

public class Coordinates implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private long x;
    private Long y; //Максимальное значение поля: 581, Поле не может быть null

    /**
     * Конструктор координат
     * @param x x
     * @param y y
     */
    public Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {

    }

    /**
     * Метод для получения x
     * @return x
     */
    public long getX() {
        return x;
    }
    /**
     * Метод для получения y
     * @return y
     */

    public long getY() {
        return y;
    }

    /**
     * Метод для установки x
     * @param x x
     */

    public void setX(long x){
        this.x = x;
    }
    /**
     * Метод для установки y
     * @param y y
     */
    public void setY(long y){
        this.y = y;
    }
    /**
     * Метод для получения вектора
     * @return вектор
     */
    public int getVector(long x, long y){
        return Integer.parseInt(String.valueOf(Math.sqrt(x^2 + y^2)));
    }
}
