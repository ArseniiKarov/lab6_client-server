package errors;

public class UnknownElementException extends Exception {
    /**
     * Констркутор ошибки неизвестного элемента
     */
    public UnknownElementException() {
        super("Неизвестный элемент");
    }

    /**
     * Констркутор ошибки неизвестного элемента
     * @param key ключ
     */
    public UnknownElementException(String key) {
        super("неизвестный элемент с ключом " + key);
    }
}