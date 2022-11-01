package Main;

import Factories.AndroidFactories;
import Factories.IOSFactories;
import Interfaces.Actions;
import Interfaces.Factory;
import Interfaces.Options;
import Interfaces.SuperActions;

public class Application {
      void configApp(String os) {

        Factory factory;
        Actions actions;
        Options options;
        SuperActions superActions;

        if (os.equals("ios")) {
            factory = new IOSFactories();
        } else {
            factory = new AndroidFactories();
        }

        actions = factory.action();
        options = factory.option();
        superActions = factory.saction();

        actions.getAction();
        options.getOption();
        superActions.getSuperAction();
    }
}
