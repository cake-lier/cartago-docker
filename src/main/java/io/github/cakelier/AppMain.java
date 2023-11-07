package io.github.cakelier;

import cartago.CartagoEnvironment;
import cartago.CartagoException;
import cartago.utils.BasicLogger;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public final class AppMain {
    private AppMain() { }

    public static void main(final String[] args) throws CartagoException, ParseException {
        final var parser = new DefaultParser().parse(
            new Options()
                .addOption(new Option("e", "env-name", true, "The environment name"))
                .addOption(new Option("r", "root-name", true, "The root workspace name"))
                .addOption(new Option("p", "port", true, "The port on which the service is exposed")),
            args
        );
        final var env = CartagoEnvironment.getInstance();
        env.init(parser.getOptionValue("r"), parser.getOptionValue("e"), new BasicLogger());
        env.installInfrastructureLayer("web");
        env.startInfrastructureService("web", "0.0.0.0:" + parser.getOptionValue("p"));
    }
}
