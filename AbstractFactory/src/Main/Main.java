package Main;

import Factories.AndroidFactories;
import Factories.IOSFactories;
import Interfaces.Actions;
import Interfaces.Factory;
import Interfaces.Options;
import Interfaces.SuperActions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Application app = new Application();

        String os = scanner.next();
        app.configApp(os);

    }
}
