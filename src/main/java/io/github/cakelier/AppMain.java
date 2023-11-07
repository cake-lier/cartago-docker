package io.cakelier.github;

import cartago.CartagoEnvironment;
import cartago.CartagoException;
import cartago.utils.BasicLogger;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public final class AppMain {
    private static final String ENVIRONMENT_DEFAULT_NAME = "mas";
    private static final int PORT_DEFAULT_VALUE = 20100;

    private AppMain() { }

    public static void main(final String[] args) throws CartagoException {
        final var config = ConfigFactory.load();
        final var env = CartagoEnvironment.getInstance();
        env.init(
            getString(config, "rootWorkspace", CartagoEnvironment.ROOT_WSP_DEFAULT_NAME),
            getString(config, "environment", ENVIRONMENT_DEFAULT_NAME),
            new BasicLogger()
        );
        env.installInfrastructureLayer("web");
        env.startInfrastructureService(
            "web",
            "0.0.0.0:" + (config.hasPath("port") ? config.getInt("port") : PORT_DEFAULT_VALUE)
        );
    }

    private static String getString(final Config config, final String key, final String orElse) {
        return config.hasPath(key) ? config.getString(key) : orElse;
    }
}
