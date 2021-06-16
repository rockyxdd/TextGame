package java.textgame.message;

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
            msgBuilder.append(way + ", ");
        }
        return msgBuilder.toString();
    }

    public String inputErrorMsg() {
        return "Команды не существует!";
    }
}
