package manager;

public class Main {
    public static void main(String[] args) throws Exception {
        Console console = new Console();
        System.out.println("Введите команду 'help', чтобы увидеть все доступные команды");
        console.start(System.in, args);
    }
}