package data;

import data.generators.IdGenerator;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Worker implements Comparable<Worker>, Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float salary; //Значение поля должно быть больше 0
    private LocalDateTime startDate; //Поле не может быть null
    private LocalDateTime endDate; //Поле может быть null
    private Position position; //Поле не может быть null
    private Organization organization; //Поле может быть null


    /**
     * Конструктор для создания работника
     * @param data данные
     * @throws Exception ошибка
     */
    public Worker(String[] data) throws Exception{
        //Validator.moreThanZeroLong(data[1]);
        Validator.stringNotEmpty(data[1]);
        Validator.isLong(data[2]);
        Validator.correctPositionY(data[3]);
        Validator.correctPositionX(data[4]);
        Validator.moreThanZero(data[5]);


        this.id = Long.parseLong(String.valueOf(IdGenerator.generateid()));
        this.name = data[2];
        this.coordinates = new Coordinates(Long.parseLong(data[3]), Long.valueOf(data[4]));
        this.creationDate = LocalDateTime.now();
        this.salary = Float.parseFloat(data[5]);
        this.startDate = LocalDateTime.now();
        this.endDate= LocalDateTime.now();
        this.position = Position.valueOf(data[6]);
        this.organization = new Organization(data[7], Integer.parseInt(data[8]), OrganizationType.valueOf(data[9]), new Address(data[10], data[11], new Location(Double.parseDouble(data[12]), Float.parseFloat(data[13]), Float.parseFloat(data[14]))));

    }

    /**
     * Конструктор для создания работника
     */
    public Worker(){
        this.id = IdGenerator.generateid();
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDateTime.now();
        this.salary = 0;
        this.startDate = LocalDateTime.now();
        this.endDate= LocalDateTime.now();
        this.position = null;
        this.organization = null;
    }

    /**
     * Конструктор для создания работника
     * @param id id
     */

    public Worker(long id){
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDateTime.now();
        this.salary = 0;
        this.startDate = LocalDateTime.now();
        this.endDate= LocalDateTime.now();
        this.position = null;
        this.organization = null;
    }


    /**
     * Метод для описния работника
     * @return описание
     */
    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinate_x=" + coordinates.getX() +
                ", coordinate_y=" + coordinates.getY() +
                ", creation_date=" + creationDate +
                ", salary=" + salary+
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", position='" + position +
                ", organization full name= " + organization.getFullName() +
                ", organization employeesCount=" + organization.getEmployeesCount() +
                ", organizationType=" + organization.getType()+
                ", organizationOfficialAddress=" + organization.getOfficialAddress()+
                '}';
    }


    /**
     * Метод для получения id
     * @return id
     */
    public long getId() {
        return id;
    }
    /**
     * Метод для получения имени
     * @return имя
     */
    public String getName() {
        return name;
    }
    /**
     * Метод для получения координат
     * @return координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Метод для получения даты создания
     * @return дата создания
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Метод для получения зарплаты
     * @return заплату
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Метод для получения даты начала
     * @return дата начала
     */
    public LocalDateTime getStartDate(){
        return startDate;
    }
    /**
     * Метод для получения даты конца
     * @return дата конца
     */

    public LocalDateTime getEndDate(){
        return endDate;
    }
    /**
     * Метод для получения позиции
     * @return позиция
     */

    public Position getPosition(){
        return position;
    }
    /**
     * Метод для получения полного имени
     * @return полное имя
     */
    public String getOrganizationFullName() {
        return organization.getFullName();
    }
    /**
     * Метод для получения количества работников
     * @return количество работников
     */
    public Integer getEmployeesCount() {
        return organization.getEmployeesCount();
    }
    /**
     * Метод для получения типа
     * @return тип
     */
    public OrganizationType getOrganizationType(){
        return organization.getType();
    }
    /**
     * Метод для получения официального адресса
     * @return официальный адресс
     */
    public Address getOfficalAddress(){
        return organization.getOfficialAddress();
    }

    /**
     * Метод для установки id
     * @param id id
     */

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Метод для установки имени
     * @param name имя
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для установки координат
     * @param coordinates координаты
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Метод для установки даты создания
     * @param creationDate дата создания
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Метод для установки зазплаты
     * @param salary заплата
     */
    public void setSalary(float salary){
        this.salary = salary;
    }

    /**
     * Метод для установки даты начала
     * @param startDate дата начала
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Метод для установки даты конца
     * @param endDate дата конца
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Метод для установки позиции
     * @param position позиции
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Метод для установки организации
     * @param organization организация
     */
    public void setOrganization(Organization organization){
        this.organization = organization;
    }

    /**
     * Метод для сравнения работников
     * @param worker работник
     * @return значениа
     */
    @Override
    public int compareTo(Worker worker){
        return this.organization.getEmployeesCount() - worker.organization.getEmployeesCount();
    }
}