package manager.commands;
import data.Worker;
import data.generators.WorkerGenerator;
import manager.CollectionManager;
import manager.Request;

public class Insert implements Command {
    /**
     * Метод для выполнения команды
     *
     * @param request запрос, содержащий аргументы
     * @return результат выполнения команды
     */
    @Override
    public String execute(Request request) {
        String[] args = request.getMessage().split(" ");
        if (args.length < 2) {
            return "Worker добавлен с ключом: ";
        } else {
            // Используем полученные данные для создания Worker
            String[] workerData = request.getAdditionalData();
            Worker worker = WorkerGenerator.createWorkerFromData(workerData);
            CollectionManager.add(args[1], worker);
            return "Worker добавлен с ключом: " + args[1];
        }
    }

    /**
     * Метод для получения имени команды
     *
     * @return имя команды
     */
    @Override
    public String getName() {
        return "insert";
    }

    /**
     * Метод для описания команды
     *
     * @return описание команды
     */
    @Override
    public String getDescription() {
        return "добавить новый элемент с заданным ключом";
    }
}