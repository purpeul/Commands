package fr.purple.commands.builder;

import fr.purple.commands.ColorCommands;
import org.bukkit.command.CommandMap;

public final class CommandBuilder {

    private final String name;
    private final CommandMap commands;

    public CommandBuilder(String name, ColorCommands ccmd) {
        this.name = name;
        this.commands = ccmd.getCommands();
    }

    public BasicBuilder asBasic(){
        return new BasicBuilder(name, command -> {
            commands.register(name, command);
        });
    }

    public ComplexBuilder asComplex(){
        return new ComplexBuilder(name, command -> {
            commands.register(name, command);
        });
    }
}
