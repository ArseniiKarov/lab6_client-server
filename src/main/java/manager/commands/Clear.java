package manager.commands;

import data.Worker;
import errors.UnknownElementException;
import manager.CollectionManager;
import manager.Request;

import java.util.TreeMap;

public class Clear implements Command{
    /**
     * Метод для выполнения команда
     *
     * @param arg аргументы
     * @return
     * @throws UnknownElementException ошибка неизвестного элемента
     */
    @Override
    public String execute(Request arg) throws UnknownElementException {
        TreeMap<String, Worker> map = CollectionManager.getMap();
        map.clear();
        CollectionManager.setMap(map);
        return "Clear...";
    }

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    @Override
    public String getName() {
        return "clear";
    }

    /**
     * Метод для описания команды
     * @return описание
     */
    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
