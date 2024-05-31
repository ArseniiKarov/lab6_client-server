package manager;

import data.Worker;
import data.generators.WorkerGenerator;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    private DatagramSocket socket;
    private InetAddress address;
    int port;
    private byte[] buffer = new byte[5000]; // Буфер для хранения входящих данных
    private CommandManager commandManager;

    public Server(int port, CommandManager commandManager) throws SocketException {
        socket = new DatagramSocket(port);
        this.commandManager = commandManager;
    }

    public void listen() throws Exception {
        while (true) {
            Request request = getRequest();
            System.out.println("Получено сообщение от клиента: " + request.getMessage()); // Отладочное сообщение

            // обработка полученного запроса
            String message = commandManager.startExecuting(request);
            request.setMessage(message);

            System.out.println("Обработано сообщение: " + message); // Отладочное сообщение

            // Отправка ответа
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(request);
            objectOutputStream.close();
            DatagramPacket sendPacket = new DatagramPacket(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, address, port);

            socket.send(sendPacket);
            System.out.println("Отправлено сообщение клиенту: " + request.getMessage()); // Отладочное сообщение
        }
    }

    public Request getRequest() throws IOException, ClassNotFoundException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet); // Получение пакета от клиента

        address = packet.getAddress();
        port = packet.getPort();

        // Извлечение данных из пакета
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Request request = (Request) objectInputStream.readObject();
        objectInputStream.close();

        return request;
    }
    private String handleInsert(Request request) {
        String[] args = request.getMessage().split(" ");
        if (args[0].equals("insert") || args.length < 2) {
            return "Введите ключ после 'insert'";
        } else {
            String[] workerData = request.getAdditionalData();
            if (workerData == null || workerData.length < 13) {
                return "Недостаточно данных для создания Worker";
            }

            Worker worker = WorkerGenerator.createWorkerFromData(workerData);
            CollectionManager.add(args[1], worker);
            return "Worker добавлен с ключом: " + args[1];
        }
    }


    public void close() {
        socket.close();
    }
}
