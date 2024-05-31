package manager.commands;

import manager.JsonParser;
import manager.Request;

import java.io.IOException;


public class Save implements Command {
    /**
     * Метод для выполнения команда
     *
     * @param arg аргументы
     * @return
     * @throws IOException ошибка системы
     */
    @Override
    public String execute(Request arg) throws IOException {
        JsonParser.write();
        return "Сохранено";
    }

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    @Override
    public String getName() {
        return "save";
    }

    /**
     * Метод для описания команды
     * @return описание
     */
    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }
}