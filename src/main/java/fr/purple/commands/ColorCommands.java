package fr.purple.commands;

import fr.purple.commands.builder.CommandBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ColorCommands {

    private static ColorCommands instance;

    public static ColorCommands getInstance(){
        if(instance == null) {
            try {
                instance = new ColorCommands();
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private final CommandMap commands;

    private ColorCommands() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        bukkitCommandMap.setAccessible(true);

        this.commands = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
    }

    public CommandBuilder register(String name){
        return new CommandBuilder(name, this);
    }

    public CommandMap getCommands() {
        return commands;
    }
}