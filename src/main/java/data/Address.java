package data;

import java.io.Serial;
import java.io.Serializable;

public class Address implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private String street; //Строка не может быть пустой, Поле может быть null
    private String zipCode; //Длина строки должна быть не меньше 7, Поле не может быть null
    private Location town; //Поле не может быть null

    /**
     * Конструктор адресса
     * @param street улица
     * @param zipCode индекс
     * @param town город
     */
    public Address(String street, String zipCode, Location town){
        this.street = street;
        this.zipCode = zipCode;
        this.town = town;
    }

    public Address() {

    }

    /**
     * Метод для получения улицы
     * @return улица
     */
    public String getStreet(){
        return street;
    }
    /**
     * Метод для получения индекса
     * @return индекс
     */
    public String getZipCode(){
        return zipCode;
    }
    /**
     * Метод для получения города
     * @return город
     */
    public Location getTown(){
        return town;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String code) {
        this.zipCode = code;
    }

    public void setTown(Location town) {
        this.town = town;
    }
}
