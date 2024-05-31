package manager;

import data.Worker;
import data.generators.WorkerGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.net.SocketException;
import java.net.UnknownHostException;
public class Console {
    private Request request;

    public void start(InputStream inputStream, String[] args) throws Exception {
        while (true) {
            System.out.print("Введите команду: ");
            Scanner scanner = new Scanner(inputStream);
            String input;
            try {
                input = scanner.nextLine();
                request = new Request(input);
                Server client = new Server();

                if ( input.equals("remove_greater") || input.equals("remove_lower")) {
                    Worker worker = WorkerGenerator.createWorker(0L);
                    request.setWorker(worker);
                    String answer = client.sendEcho(request);
                    System.out.println(answer);

                } else if (input.split(" ")[0].equals("update")) {
                    String anwser = client.sendEcho(request);

                    if (anwser.equals("wrong id")) {
                        System.out.println(anwser);
                        continue;
                    } else {
                        System.out.println("New Worker");
                        request.setWorker(WorkerGenerator.createWorker(0L));

                    }
                } else if (input.equals("exit")) {

                    if (input.split(" ")[0].equals("execute_script")) {
                        ExecuteScript.execute(request.getMessage());
                    } else {
                        String echo = client.sendEcho(request);
                        System.out.println("Echo from server: \n" + echo);
                        client.close();
                    }

                }
                else {
                    String echo = client.sendEcho(request);
                    System.out.println("info from server: " + echo);
                    client.close();
                }
            } catch (SocketException e) {
                System.out.println("SocketException: \n" + e.getMessage());
            } catch (UnknownHostException e) {
                System.out.println("UnknownHostException: \n" + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
