package data.generators;

import data.Worker;

import java.util.ArrayList;

public class IdGenerator {
    private static ArrayList<Long> idList = new ArrayList<>();

    /**
     * Конструктор для списеп id
     */
    public IdGenerator(){
        idList = new ArrayList<>();
    }

    /**
     * Метод для генерирования id
     * @return id
     */
    public static Long generateid(){
        Long id = (long)Math.floor(Math.random() * 386800) + 244;
        while (idList.contains(id)){
            id = (long)Math.floor(Math.random() * 386800) + 244;
        }
        idList.add(id);
        return id;
    }

    /**
     * Метод для проверки на уникальность
     * @param id id
     * @return true
     */
    public static boolean idIsUnique(long id){
        if (idList.contains(id)){
            return false;
        }
        return true;
    }
    public ArrayList<Long> getGeneratedIds(){
        return idList;
    }
    public void addId(Worker worker){
        idList.add(worker.getId());
    }
}
