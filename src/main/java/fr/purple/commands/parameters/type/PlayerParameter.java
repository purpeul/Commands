package fr.purple.commands.parameters.type;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.UUID;

public class PlayerParameter extends ParameterType<Player> {

    public PlayerParameter() {
        super(Player.class, "Joueur");
    }

    @Override
    public Object handle(Player obj, Class<?> type) {

        if (type == UUID.class){
            return obj.getUniqueId();

        } else if (type == String.class) {
            return obj.getName();

        } else if (type == PlayerInventory.class){
            return obj.getInventory();

        }else if(type == ItemStack.class){
            return obj.getItemInHand();

        }
        return null;
    }

    @Override
    public Player transformElement(String element) {
        return Bukkit.getPlayer(element);
    }
}
