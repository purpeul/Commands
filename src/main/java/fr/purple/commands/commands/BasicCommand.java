package fr.purple.commands.commands;

import fr.purple.commands.parameters.Parameter;
import fr.purple.commands.parameters.ParameterList;
import fr.purple.commands.utils.Pair;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class BasicCommand extends Command {

    private List<Parameter> parameters;
    private CommandContent content;

    public BasicCommand(String name, List<Parameter> parameters, CommandContent content) {
        super(name);
        this.parameters = parameters;
        this.content = content;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {

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
    }

    private String getErrorMessage(int type, String... data) {
        switch (type){
            case 1:
                return "§cErreur ! Ce ne sont pas les bons paramètres !";
            case 2:
                return "§cLe terme du parametre " + data[0] + " : \"" + data[1] + "\" ne correspond pas avec le type de valeur : " + data[2];
        }
        return "";
    }
}
