package fr.purple.commands.commands;

import fr.purple.commands.parameters.ParameterList;
import org.bukkit.command.CommandSender;

@FunctionalInterface
public interface CommandContent {

    void handle(CommandSender sender, ParameterList args);
}
