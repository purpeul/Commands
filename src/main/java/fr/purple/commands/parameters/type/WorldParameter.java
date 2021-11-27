package fr.purple.commands.parameters.type;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.Entity;

import java.io.File;
import java.rmi.server.UID;
import java.util.List;

public class WorldParameter extends ParameterType<World> {

    public WorldParameter() {
        super(World.class, "Monde");
    }

    @Override
    public Object handle(World obj, Class<?> type) {

        if(type == UID.class){
            return obj.getUID();

        }else if(type == String.class){
            return obj.getName();

        }else if(type == File.class){
            return obj.getWorldFolder();

        }else if(type == WorldType.class){
            return obj.getWorldType();

        }else if(type == Difficulty.class){
            return obj.getDifficulty();

        }else if(type == List.class && type.getTypeParameters().length > 0 && type.getTypeParameters()[0].getGenericDeclaration() == Entity.class){
            return obj.getEntities();

        }

        return null;
    }

    @Override
    public World transformElement(String element) {
        return Bukkit.getWorld(element);
    }
}
