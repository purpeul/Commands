package fr.purple.commands;

import fr.purple.commands.builder.CommandBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ColorCommands {

    private static ColorCommands instance;

    public static ColorCommands getInstance(){
        if(instance == null) {
            try {
                instance = new ColorCommands();
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private final CommandMap commands;

    private ColorCommands() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Server server = Bukkit.getServer();
        Method method = server.getClass().getMethod("getCommandMap");

        this.commands = (CommandMap) method.invoke(server);
    }

    public CommandBuilder register(String name){
        return new CommandBuilder(name, this);
    }

    public CommandMap getCommands() {
        return commands;
    }
}