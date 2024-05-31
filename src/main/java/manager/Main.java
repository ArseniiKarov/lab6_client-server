package manager;

import data.Worker;
import errors.NoElementException;
import manager.CollectionManager;
import manager.JsonParser;
import manager.Server;

import java.io.IOException;
import java.net.SocketException;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws NoElementException, IOException {
        CollectionManager cm;
        if (args.length > 0) {
            JsonParser reader = new JsonParser(args[0]);
            TreeMap<String, Worker> workers = reader.loadFromJson();
            cm = new CollectionManager(workers);
            System.out.println("прочитано");
        } else {
            System.out.println("ну ладно");
            cm = new CollectionManager();
        }

        CommandManager commandManager = new CommandManager(); // Создайте экземпляр CommandManager

        int port = 1234; // Здесь используйте порт, который вам нужен
        try {
            Server server = new Server(port, commandManager); // Передайте commandManager в сервер
            server.listen();
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
