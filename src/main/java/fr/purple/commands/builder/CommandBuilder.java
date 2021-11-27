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

    public BasicCommandBuilder asBasic(){
        return new BasicCommandBuilder(name, command -> {
            commands.register(name, command);
        });
    }
}
