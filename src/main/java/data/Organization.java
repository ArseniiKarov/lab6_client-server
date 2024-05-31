package data;

import java.io.Serial;
import java.io.Serializable;

public class Organization implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private String fullName; //Поле не может быть null
    private int employeesCount; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address officialAddress; //Поле может быть null

    /**
     * Конструктор организации
     * @param fullName полное имя
     * @param employeesCount количество работников
     * @param type тип
     * @param officialAddress официальный адрес
     */

    public Organization(String fullName, int employeesCount, OrganizationType type, Address officialAddress){
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officialAddress = officialAddress;
    }

    public Organization() {

    }

    /**
     * Метод для получения полное имя
     * @return полное имя
     */
    public String getFullName(){
        return fullName;
    }
    /**
     * Метод для получения количество работников
     * @return количество работников
     */
    public int getEmployeesCount(){
        return employeesCount;
    }
    /**
     * Метод для получения типа
     * @return тип
     */
    public OrganizationType getType(){
        return type;
    }
    /**
     * Метод для получения официальный адрес
     * @return официальный адрес
     */
    public Address getOfficialAddress(){
        return officialAddress;
    }

    /**
     * Метод для установки полного имени
     * @param fullName полное имя
     */

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    /**
     * Метод для установки количества работников
     * @param employeesCount количество работников
     */

    public void setEmployeesCount(int employeesCount){
        this.employeesCount = employeesCount;
    }

    /**
     * Метод для установки типа
     * @param type тип
     */
    public void setType(OrganizationType type){
        this.type = type;
    }

    /**
     * Метод для установки официального адреса
     * @param officialAddress официальный адрес
     */
    public void setOfficialAddress(Address officialAddress){
        this.officialAddress = officialAddress;
    }
}
