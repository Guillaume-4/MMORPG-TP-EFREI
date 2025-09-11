package Settings;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import Entities.Knight;

public class Save {
    private Path savePath = Path.of("src/Settings/Save.txt");
    private HashMap<String, String> saveData = new HashMap<>();
    public void saveGame(Knight knight){
        
        try{
            this.saveData.put("character", knight.getName());
            this.saveData.put("health", String.valueOf(knight.getHealth()));
            this.saveData.put("level", String.valueOf(knight.getLevel()));
            this.saveData.put("experience", String.valueOf(knight.getExperience()));
            this.saveData.put("weaponName", knight.getWeapon().getName());
            this.saveData.put("weaponDamage", String.valueOf(knight.getWeapon().getDamage()));
            this.saveData.put("weaponRarity", String.valueOf(knight.getWeapon().getRarity()));
            this.saveData.put("gold", String.valueOf(knight.getGold()));
            StringBuilder sb = new StringBuilder();
            this.saveData.forEach((key, value) -> sb.append(key).append("=").append(value).append("\n"));
            Files.write(savePath, sb.toString().getBytes());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public HashMap<String, String> loadGame(){
        try{
            List<String> lines = Files.readAllLines(savePath, StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    this.saveData.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Impossible de charger la sauvegarde : " + e.getMessage());
        }
        return saveData;
    }

    public int getIntOrDefault(HashMap<String, String> map, String key, int defaultValue) {
        String value = map.get(key);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

}
