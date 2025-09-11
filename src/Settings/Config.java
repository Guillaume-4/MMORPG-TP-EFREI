package Settings;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class Config {
    private static Path configPath = Path.of("src/Settings/Config.txt");
    public static void saveConfig(HashMap<String, Boolean> config){
        try{
            List<String> fileLines = Files.readAllLines(configPath);
            StringBuilder sb = new StringBuilder();
            config.forEach((key, value) -> {
                fileLines.stream().filter(line -> line.startsWith(key + "=")).findFirst().ifPresent(line -> {
                    sb.append(key).append("=").append(value).append("\n");
                });
            });
            Files.write(configPath, sb.toString().getBytes());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static HashMap<String, Boolean> loadConfig(){
        HashMap<String, Boolean> config = new HashMap<>();
        try{
            List<String> lines = Files.readAllLines(configPath);
            lines.forEach(line -> {
                String[] parts = line.split("=");
                if(parts.length == 2){
                    config.put(parts[0], Boolean.parseBoolean(parts[1]));
                }
            });

        }catch(Exception e){
            e.printStackTrace();
        }
        return config;
    }
}
