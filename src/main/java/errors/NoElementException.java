package errors;

public class NoElementException extends Exception {
    /**
     * Конструктор ошибки отсутсвия элемента
     * @param id id
     */

    public NoElementException(Integer id) {
        super("Нет элемента с данным индексом");
    }
}
