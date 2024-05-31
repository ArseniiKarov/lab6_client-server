package manager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExecuteScript {
    public static void execute(String line) throws Exception {
        Request request = new Request(null);
        String filePath = line.split(" ")[1];

        try {
            Scanner scanner = new Scanner(new FileReader(filePath));
            Server client = new Server();
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                request.setMessage(command);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (Exception e) {
            System.out.println("Wrong input data");
        }
    }

    public String getName() {
        return "execute_script_command";
    }

    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме ";
    }
}
