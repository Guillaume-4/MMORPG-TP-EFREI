package level;

import entities.entity;

public class level {
    private int levelNumber;
    private int rewardGold;


    public void displayLevelInfo() {
        System.out.println("Level " + levelNumber + " - Reward: " + rewardGold + " gold");
    }

    public void playLevel(entity knight,entity enemy) {
        System.out.println("Playing level " + levelNumber + "...");
        boolean isSuccess = knight.fight(enemy);
        if (!isSuccess) {
            System.out.println("You have been defeated!");
            knight.resetHP();
        }else{
            System.out.println("Level " + levelNumber + " completed! You earned " + rewardGold + " gold.");
            knight.resetHP();
            knight.gainGold(rewardGold);
            knight.gainExperience(10 * levelNumber);
            nextLevel(enemy);
        }
    }

    public void nextLevel(entity enemy){
        System.out.println("Congratulations! You've advanced to level " + this.levelNumber + " and earned " + this.rewardGold + " gold!");
        this.levelNumber += 1;
        this.rewardGold += 10; 
        enemy.resetHP();
        enemy.setDefense(enemy.getDefense() * levelNumber);
        enemy.setHealth(enemy.getHealth() * levelNumber);
        enemy.getWeapon().setDamage(enemy.getWeapon().getDamage() * levelNumber);
        enemy.setMaxHealth(enemy.getHealth());
        
    }

    public level(int levelNumber) {
        this.levelNumber = levelNumber;
        this.rewardGold = 10;
    }
    public int getLevelNumber() {
        return levelNumber;
    }
    public int getRewardGold() {
        return rewardGold;
    }
    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
    public void setRewardGold(int rewardGold) {
        this.rewardGold = rewardGold;
    }



}
