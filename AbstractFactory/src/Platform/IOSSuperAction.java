package Platform;

import Interfaces.Actions;
import Interfaces.SuperActions;

public class IOSSuperAction implements SuperActions {
    @Override
    public void getSuperAction() {
        System.out.println("You get IOS super action");
    }
}
