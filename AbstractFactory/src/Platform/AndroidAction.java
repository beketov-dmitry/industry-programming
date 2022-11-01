package Platform;

import Interfaces.Actions;

public class AndroidAction implements Actions {
    @Override
    public void getAction() {
        System.out.println("You get Android action");
    }
}
