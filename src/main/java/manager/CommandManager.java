package manager;

import errors.NoElementException;
import manager.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Command> commandList;

    public CommandManager() {
        commandList = new HashMap<>();
        commandList.put("help", new Help());
        commandList.put("info", new Info());
        commandList.put("show", new Show());
        commandList.put("insert", new Insert());
         /**commandList.put("update_id", new UpdateId());
         commandList.put("remove_key", new RemoveKey());
         */
        commandList.put("clear", new Clear());
        commandList.put("save", new Save());
        commandList.put("exit", new Exit());
        commandList.put("replace_if_greater", new RemoveLower());
        commandList.put("remove_greater_key", new RemoveGreater());
        commandList.put("remove_lower_key", new RemoveLowerKey());
        commandList.put("count_less", new PrintAscending());
    }

    /**
     * Метод для запуска команд
     * @return
     * @throws Exception ошибки
     * @throws NoElementException ошибка отсутствия элемента
     */
    public String startExecuting(Request request) throws Exception {
        String commandName = request.getMessage().split(" ")[0];
        if (!commandList.containsKey(commandName)) {
            return "Unknown command";
        }
        Command command = commandList.get(commandName);
        return command.execute(request);
    }

    /**
     * Метод для получения списка команд
     * @return список команд
     */
    public Map<String, Command> getCommandList() {
        return commandList;
    }
}
