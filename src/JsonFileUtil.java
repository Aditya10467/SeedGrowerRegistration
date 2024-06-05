import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonFileUtil {

    private static final String FILE_PATH = "data.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Method to read existing data from the JSON file
    private static List<Data> readDataFromFile() {
        List<Data> dataList = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Type listType = new TypeToken<List<Data>>() {}.getType();
                dataList = gson.fromJson(reader, listType);

                // If the file is empty or not properly formatted, initialize dataList as an empty list
                if (dataList == null) {
                    dataList = new ArrayList<>();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return dataList;
    }

    // Method to save or append data to the JSON file
    public static void saveData(Data data) {
        List<Data> dataList = readDataFromFile();
        dataList.add(data);

        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(dataList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Optional: Method to get all data from the JSON file
    public static List<Data> getAllData() {
        return readDataFromFile();
    }
}
