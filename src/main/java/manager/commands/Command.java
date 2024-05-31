package manager.commands;

import errors.NoElementException;
import manager.Request;

public interface Command {
    /**
     * Метод для выполнения команда
     *
     * @param args аргументы
     * @return
     * @throws NoElementException ошибка отсутствия элемента
     * @throws Exception          ошибка
     */
    public String execute(Request args) throws NoElementException, Exception;

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    public String getName();

    /**
     * Метод для описания команды
     * @return описание
     */
    public String getDescription();
}