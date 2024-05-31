package manager.commands;

import data.Worker;
import data.comparator.WorkerComparator;
import data.generators.WorkerGenerator;
import errors.NoElementException;
import manager.CollectionManager;
import manager.Request;

import java.util.ArrayList;
import java.util.TreeMap;

public class RemoveLower implements Command {
    /**
     * Метод для выполнения команда
     *
     * @param args аргументы
     * @return
     * @throws NoElementException ошибка отсутствия элемента
     * @throws Exception          ошибка
     */
    @Override
    public String execute(Request args) throws NoElementException, Exception {
        Worker worker = WorkerGenerator.createWorker(0L);
        TreeMap<String, Worker> map = CollectionManager.getMap();
        WorkerComparator c1 = new WorkerComparator();
        ArrayList<String> keySet = new ArrayList<>();
        for (String key : map.keySet()) {
            if (c1.compare(worker, map.get(key)) > 0) {
                keySet.add(key);
            } else if (c1.compare(worker, map.get(key)) == 0);
        }
        int k = keySet.size();
        for (String key : keySet) {
            CollectionManager.remove(key);
        }
        if (k == CollectionManager.getMap().size()){
            System.out.println("Ничего не поменялось");
        }
        return null;
    }

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    @Override
    public String getName() {
        return "remove_lower";
    }

    /**
     * Метод для описания команды
     * @return описание
     */
    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}