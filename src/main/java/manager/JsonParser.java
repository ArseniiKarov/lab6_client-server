package manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import data.LocalDateTimeTypeAdapter;
import data.Worker;
import data.generators.IdGenerator;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * Класс-парсер файла.
 */
public class JsonParser {
    private static String filename = "collection.json";
    public JsonParser(String filepath){
        filename = filepath;
    }
    /**
     * Метод для чтения из файла
     * @return строка
     * @throws IOException ошибка системы
     */
    public TreeMap<String, Worker> loadFromJson() throws JsonSyntaxException, JsonIOException {
        TreeMap<String, Worker> workers = new TreeMap<>();
        TreeMap<String, Worker> buffer;
        Validator validator = new Validator();
        IdGenerator idGenerator = validator.getIdGenerator();
        try{
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            Type itemsArrayType = new TypeToken<TreeMap<String, Worker>>() {}.getType();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter());
            Gson gson = gsonBuilder.create();
            String data = "";
            while (sc.hasNextLine()){
                data = data.concat(sc.nextLine());
            }
            buffer = gson.fromJson(data, itemsArrayType);
            for (Map.Entry<String, Worker> worker : buffer.entrySet()){
                Worker validatedWorker = validator.getValidatedElement(worker.getValue());
                if (!(validatedWorker == null) && !(idGenerator.getGeneratedIds().contains(validatedWorker.getId()))){
                    workers.put(String.valueOf(validatedWorker.getId()), validatedWorker);
                    idGenerator.addId(validatedWorker);
                }else{
                    System.out.println("Пропущен некорректный элемент. ");
                }
            }
            return workers;
        }catch (JsonIOException | NullPointerException | JsonSyntaxException e){
            System.out.println("Что-то не так с файлом или он пуст. Коллекция не содержит элементов. ");
            return workers;
        }catch (FileNotFoundException e){
            if (!(new File(filename).canRead())){
                System.out.println("Нет прав на чтение данного файла.");
            } else {
                System.out.println("Данный файл не найден.");
            }
            return workers;
        }
    }
    public static void write() throws IOException {
        TreeMap<String, Worker> treeMap = CollectionManager.getMap();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter());
        Gson gson = gsonBuilder.create();
        String data = gson.toJson(treeMap);
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.write(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
