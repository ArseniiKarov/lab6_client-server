package errors;

public class IncorrectInputException extends Exception{
    /**
     * Конструктор ошибки неправильного аргумента
     * @param data
     */
    public IncorrectInputException(String data){
        super("Неправильный аргумент ввода " + data);
    }

}
