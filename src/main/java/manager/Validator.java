package manager;

import data.OrganizationType;
import data.Worker;
import data.generators.IdGenerator;
import errors.IncorrectInputException;

public class Validator {
    IdGenerator idGenerator = new IdGenerator();
    public Worker getValidatedElement(Worker worker){
        if (worker.getId() < 0 || worker.getName() == null || worker.getName().isBlank() || worker.getCoordinates() == null || worker.getCoordinates().getY() > 581 || worker.getSalary() < 0 || worker.getStartDate() == null || worker.getEndDate() == null || worker.getPosition() == null || worker.getOrganizationType() == null){
            return null;
        }else{
            if (worker.getId() == 0){
                worker.setId(IdGenerator.generateid());
            }
            return worker;
        }
    }

    /**
     * Метод для проверки значений больше нуля
     * @param args аргумент
     * @throws IncorrectInputException ошибка неправильного значения
     */

    public static void moreThanZero(String args) throws IncorrectInputException {
        try {
            long num = Long.parseLong(args);
            if (num < 0) {
                throw new IncorrectInputException(args + " less then zero");
            }
        } catch (Exception e) {
            throw new IncorrectInputException(args);
        }
    }


    /**
     * Метод для проверки координаты y
     * @param args аргумент
     * @throws IncorrectInputException ошибка неправильного значения
     */
    public static void correctPositionY(String args) throws IncorrectInputException, NullPointerException {
        try {
            long y = Long.parseLong(args);
            if (y > 581 ){
                throw new IncorrectInputException("pos Y: " + args);
            }
        } catch (Exception e) {
            throw new IncorrectInputException("pos Y incorrent : " + args);
        }
    }

    /**
     * Метод для проверки координаты x
     * @param args аргумент
     * @throws IncorrectInputException ошибка неправильного значения
     */
    public static void correctPositionX(String args) throws IncorrectInputException, NullPointerException {
        try {
            Long.parseLong(args);
        } catch (Exception e) {
            throw new IncorrectInputException("pos X incorrent : " + args);
        }
    }


    /**
     * Метод для проверки координаты y
     * @param args аргумент
     */

    public static boolean isInt(String args) throws IncorrectInputException {
        try{
            Integer.parseInt(args);
            return true;
        }catch (Exception e){
            throw new IncorrectInputException(args + " is not int");
        }
    }
    /**
     * Метод для проверки типа данных
     * @param args аргумент
     * @throws IncorrectInputException ошибка неправильного значения
     */
    public static void isDouble(String args) throws IncorrectInputException {
        try{
            Double.parseDouble(args);
        }catch (Exception e){
            throw new IncorrectInputException(args + " is not double");
        }
    }

    /**
     * Метод для проверки типа данных
     * @param args аргумент
     * @throws IncorrectInputException ошибка неправильного значения
     */
    public static void isLong(String args) throws IncorrectInputException {
        try{
            Long.parseLong(args);
        }catch (Exception e){
            throw new IncorrectInputException(args + " is not long");
        }
    }
    /**
     * Метод для проверки типа данных
     * @param args аргумент
     * @throws IncorrectInputException ошибка неправильного значения
     */

    public static void isFloat(String args) throws IncorrectInputException {
        try{
            Float.parseFloat(args);
        }catch (Exception e){
            throw new IncorrectInputException(args + " is not float");
        }
    }

    /**
     * Метод для проверки типа организации
     * @param args аргумент
     * @throws IncorrectInputException ошибка неправильного значения
     */

    public static void correctOrganizationType(String args) throws IncorrectInputException {
        try {
            OrganizationType.valueOf(args);
        } catch (Exception e) {
            throw new IncorrectInputException("OrganizationType");
        }
    }

    /**
     * Метод для проверки непустой строки
     * @param args аргумент
     * @throws IncorrectInputException ошибка неправильного значения
     */

    public static void stringNotEmpty(String args) throws IncorrectInputException{
        if (args.isEmpty() || args.trim().isEmpty()) {
            throw new IncorrectInputException("string is empty");
        }
    }
    public IdGenerator getIdGenerator(){
        return idGenerator;
    }

}
