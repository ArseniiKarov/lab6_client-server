package data.comparator;


import data.Worker;

import java.util.Comparator;

public class WorkerComparator implements Comparator<Worker> {
    /**
     * Метод для сранивания работников
     * @param h1 the first object to be compared.
     * @param h2 the second object to be compared.
     * @return значение
     */
    @Override
    public int compare(Worker h1, Worker h2){
        return h1.getName().compareTo(h2.getName());
    }
}