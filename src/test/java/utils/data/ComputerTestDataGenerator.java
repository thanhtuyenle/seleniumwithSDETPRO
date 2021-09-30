package utils.data;

import com.google.gson.Gson;
import testdata.ComputerDataObject;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ComputerTestDataGenerator {
    public static ComputerDataObject[] getTestDataFrom(String jSonFileLocation) {
        ComputerDataObject[] computerDataObjects = new ComputerDataObject[]{};
        try {
            Gson gson = new Gson();
            String currentLocation = System.getProperty("user.dir");
            Reader reader = Files.newBufferedReader(Paths.get(currentLocation + jSonFileLocation));

            computerDataObjects = gson.fromJson(reader, ComputerDataObject[].class);
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return computerDataObjects;
    }

}
