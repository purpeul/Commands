package fr.purple.commands.builder;

import fr.purple.commands.commands.CommandContent;
import fr.purple.commands.commands.BasicCommand;
import fr.purple.commands.parameters.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BasicBuilder {

    private final String name;
    private final List<Parameter> parameters;
    private final Consumer<BasicCommand> executorConsumer;
    private String permission;


    public BasicBuilder(String name, Consumer<BasicCommand> executorConsumer) {
        this.name = name;
        this.parameters = new ArrayList<>();
        this.permission = "";
        this.executorConsumer = executorConsumer;
    }

    public BasicBuilder with(Parameter parameter){
        this.parameters.add(parameter);
        return this;
    }

    public BasicBuilder require(String permission){
        this.permission = permission;
        return this;
    }

    public void build(CommandContent content){
        BasicCommand executor = new BasicCommand(name, parameters, content);
        executor.setPermission(permission);
        executorConsumer.accept(executor);
    }
}
