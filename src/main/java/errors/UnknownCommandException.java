package errors;

public class UnknownCommandException extends Exception{
    /**
     * Консьруктор ошибки неизвестной комвнды
     * @param commandName название команды
     */
    public UnknownCommandException(String commandName) {
        super("Неизвестная команда: " + commandName);
    }
}
