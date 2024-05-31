package manager.commands;

import data.Worker;
import manager.CollectionManager;
import manager.Request;

import java.util.TreeMap;

public class Show implements Command {
    /**
     * Метод для выполнения команда
     *
     * @param arg аргументы
     * @return
     */
    @Override
    public String execute(Request arg)  {
        TreeMap<String, Worker> workers = CollectionManager.getMap();
        StringBuilder stringBuilder = new StringBuilder();
        if (workers.isEmpty()) {
            return "Коллекция пуста :(";
        } else {
            for (Worker worker : workers.values()) {
                stringBuilder.append(worker).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    @Override
    public String getName() {
        return "show";
    }

    /**
     * Метод для описания команды
     * @return описание
     */
    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}