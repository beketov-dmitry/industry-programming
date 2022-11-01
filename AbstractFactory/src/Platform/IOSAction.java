package Platform;

import Interfaces.Actions;

public class IOSAction implements Actions {
    @Override
    public void getAction() {
        System.out.println("You get IOS action");
    }
}
