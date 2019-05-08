package neoredun;

public class Main {
    public static void main (String[] args) {
        ui view = new ui();
        SaveRead model = new SaveRead();
        Controller controller = new Controller(view, model);

    }
}
