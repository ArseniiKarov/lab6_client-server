package manager.commands;

import manager.CommandManager;
import manager.Request;

import java.util.Map;

public class Help implements Command {
    /**
     * Метод для выполнения команда
     *
     * @param args аргументы
     * @return
     */
    @Override
    public String execute(Request args)  {
        StringBuilder line = new StringBuilder();
        CommandManager commandManager = new CommandManager();
        Map<String, Command> commandList = commandManager.getCommandList();
        for (String name: commandList.keySet()){
            Command command = commandList.get(name);
            line.append(command.getName()).append(" - ").append(command.getDescription()).append("\n");
        }
        line.append("execute_script").append(" - ").append("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        return line.toString();
    }

    /**
     * Метод для получения имени команды
     * @return именя команды
     */
    @Override
    public String getName() {
        return "help";
    }

    /**
     * Метод для описания команды
     * @return описание
     */
    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }
}
