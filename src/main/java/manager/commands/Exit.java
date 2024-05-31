package manager.commands;

import manager.Request;

public class Exit implements Command{
    /**
     * Метод для выполнения команда
     *
     * @param arg аргументы
     * @return
     */
    @Override
    public String execute(Request arg) {
        System.exit(1);
        return null;
    }

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    @Override
    public String getName() {
        return "exit";
    }

    /**
     * Метод для описания команды
     * @return описание
     */
    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }
}
