package Platform;

import Interfaces.SuperActions;

public class AndroidSuperAction implements SuperActions {

    @Override
    public void getSuperAction() {
        System.out.println("You get Android super action");
    }
}
