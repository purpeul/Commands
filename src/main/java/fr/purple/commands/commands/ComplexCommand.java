package fr.purple.commands.commands;

import fr.purple.commands.parameters.Parameter;
import fr.purple.commands.parameters.ParameterList;
import fr.purple.commands.utils.Pair;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComplexCommand extends Command {

    private List<Subcommand> subcommands;

    public ComplexCommand(String name, List<Subcommand> subcommands) {
        super(name);
        this.subcommands = subcommands;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {

        if(strings.length == 0){
            sender.sendMessage(getErrorMessage(1));
            return false;
        }

        Optional<Subcommand> optional =  subcommands.stream().filter(sbcmd -> sbcmd.getName().equalsIgnoreCase(strings[0])).findFirst();

        if(!optional.isPresent()){
            sender.sendMessage(getErrorMessage(2));
        }

        Subcommand subcommand = optional.get();

        List<Pair<Parameter, Object>> arguments = new ArrayList<>();

        int i = 1;
        for(Parameter param : subcommand.getParameters()){

            if(strings.length == i)return false;

            String element = strings[i];
            Object data = param.getType().transformElement(element);

            if(data != null){
                arguments.add(new Pair(param, data));
            }else{
                sender.sendMessage(getErrorMessage(3, param.getName(), element, param.getType().getName()));
                return false;
            }

            i++;
        }

        ParameterList list = new ParameterList(arguments);

        subcommand.getContent().handle(sender, list);

        return false;
    }

    private String getErrorMessage(int type, String... data) {
        switch (type){
            case 1:
                return "§cErreur ! Ce ne sont pas les bons paramètres !";
            case 2:
                return "§cErreur ! Le terme " + data[0] + " ne correspond pas avec les sous commandes ";
            case 3:
                return "§cLe terme du parametre " + data[0] + " : \"" + data[1] + "\" ne correspond pas avec le type de valeur : " + data[2];
        }
        return "";
    }

    /*
            if(parameters.stream().filter(Parameter::isEssentials).count() > strings.length) {
            commandSender.sendMessage(getErrorMessage(1));
            return false;
        }

        List<Pair<Parameter, Object>> arguments = new ArrayList<>();

        int i = 0;
        for(Parameter param : parameters){

            if(strings.length == i)return false;

            String element = strings[i];
            Object data = param.getType().transformElement(element);

            if(data != null){
                arguments.add(new Pair(param, data));
            }else{
                commandSender.sendMessage(getErrorMessage(2, param.getName(), element, param.getType().getName()));
                return false;
            }

            i++;
        }

        ParameterList list = new ParameterList(arguments);

        content.handle(commandSender, list);

        return false;
     */
}
