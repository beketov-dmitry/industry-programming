package Factories;

import Interfaces.Actions;
import Interfaces.Factory;
import Interfaces.Options;
import Interfaces.SuperActions;
import Platform.IOSAction;
import Platform.IOSOptions;
import Platform.IOSSuperAction;

public class IOSFactories implements Factory {
    @Override
    public Actions action() {
        return new IOSAction();
    }

    @Override
    public Options option() {
        return new IOSOptions();
    }

    @Override
    public SuperActions saction() {
        return new IOSSuperAction();
    }
}
