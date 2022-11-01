package Factories;

import Interfaces.Actions;
import Interfaces.Factory;
import Interfaces.Options;
import Interfaces.SuperActions;
import Platform.AndroidAction;
import Platform.AndroidOption;
import Platform.AndroidSuperAction;

public class AndroidFactories implements Factory {

    @Override
    public Actions action() {
        return new AndroidAction();
    }

    @Override
    public Options option() {
        return new AndroidOption();
    }

    @Override
    public SuperActions saction() {
        return new AndroidSuperAction();
    }
}
