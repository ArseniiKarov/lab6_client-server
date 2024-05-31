package manager.commands;

import data.Worker;
import errors.IncorrectInputException;
import manager.CollectionManager;
import manager.Request;

import java.util.Scanner;
import java.util.TreeMap;

public class RemoveLowerKey implements Command {
    /**
     * Метод для выполнения команда
     *
     * @param arg аргументы
     * @return
     * @throws IncorrectInputException ошибка неправильного значения
     */
    @Override
    public String execute(Request arg) throws IncorrectInputException {
        TreeMap<String, Worker> map = CollectionManager.getMap();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите желаемый ключ: ");
        String[] WorkerKey = in.nextLine().split(" ");
        for (String key : map.keySet()) {
            if (key.compareTo(WorkerKey[0]) < 0){
                map.remove(key);
            }
        }
        CollectionManager.setMap(map);
        return null;
    }

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    @Override
    public String getName() {
        return "remove_lower_key";
    }

    /**
     * Метод для описания команды
     * @return описание
     */
    @Override
    public String getDescription() {
        return "удалить из  коллекции все элементы ключ которых меньше, чем заданный";
    }
}
