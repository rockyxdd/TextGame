package java.textgame.message;

import java.textgame.skill.ISkill;
import java.util.List;

public class Message {

    public String greetings() {
        return "Привет, незнакомец!" +
                "Ты попал в текстовую рпг TEXTGAME228PRG!" +
                "Выбери свой никнейм: ";
    }

    public String rules(String playerName) {
        return "В игре есть 3 пути на выбор: лево, право и прямо." +
                "В каждой из комнат, тебя " + playerName + ", ждет монстр!" +
                "Победи их всех!";
    }

    public String ways(List<String> ways) {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append("Выбери свой путь: ");
        for (String way : ways) {
            msgBuilder.append(way).append(", ");
        }
        return msgBuilder.toString();
    }

    public String inputErrorMsg() {
        return "Команды не существует!";
    }

    public String playerLost() {
        return "Ты проиграл";
    }

    public String monsterLost(String name) {
        return "Монстр " + name + " повержен!";
    }

    public String playerSkills(List<ISkill> skills) {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append("Выбери способность: ");
        for (ISkill skill : skills) {
            msgBuilder.append(skill.getName()).append(", ");
        }
        return msgBuilder.toString();
    }

    public String win() {
        return "You win!!!!!";
    }

    public String playerHeal(String skillName, int healPoints) {
        return "Игрок исцелен способность " + skillName + "на " + healPoints;
    }

    public String playerDamage(String skillName, int damagePoints) {
        return "Игрок наносит урон способностью " + skillName + "на " + damagePoints;
    }

    public String playerHealth(int health) {
        return "Запас здоровья игрока - " + health;
    }

    public String monsterHealth(int health) {
        return "Запас здоровья монстра - " + health;
    }

    public String monsterDamage(String skillName, int damagePoints) {
        return "Монстр наносит урон способностью " + skillName + "на " + damagePoints;
    }

}
