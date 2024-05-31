package manager.commands;

import manager.CollectionManager;
import manager.Request;

public class Info implements Command{
    /**
     * Метод для выполнения команда
     *
     * @param arg аргументы
     * @return
     */
    @Override
    public String execute(Request arg) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Data type - " + CollectionManager.getMap().getClass().getName());
        stringBuilder.append("Count of persons - " + CollectionManager.getMap().size());
        stringBuilder.append("Init date - " + CollectionManager.getDate());

        return stringBuilder.toString();
    }

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    @Override
    public String getName() {
        return "info";
    }

    /**
     * Метод для описания команды
     * @return описание
     */
    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

}
