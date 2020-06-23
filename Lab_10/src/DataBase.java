import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DataBase {
    private Gson gson;

    String fileName = "D:\\Labs_2k_2s\\Java_1sem\\Lab_10\\src\\Users.json";

    public ArrayList<User> GetUsers() throws FileNotFoundException {
        gson = new GsonBuilder().create();

        Path path = new File(fileName).toPath();

        ArrayList<User> rc = null;
        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();

        try (Reader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {
            rc = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (rc == null)
            rc = new ArrayList<>();
        return rc;
    }

    public void PutUser(User user) throws IOException {

        gson = new Gson();
        ArrayList<User> rc = GetUsers();
        rc.add(user);

        try (FileOutputStream fos = new FileOutputStream(fileName);
             OutputStreamWriter isr = new OutputStreamWriter(fos,
                     StandardCharsets.UTF_8)) {
            gson.toJson(rc, isr);
        }
    }
}
