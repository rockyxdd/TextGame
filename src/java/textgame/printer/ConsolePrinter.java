package java.textgame.printer;

public class ConsolePrinter implements IPrinter{

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
