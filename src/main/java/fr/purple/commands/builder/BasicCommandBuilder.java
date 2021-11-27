package fr.purple.commands.builder;

import fr.purple.commands.commands.CommandContent;
import fr.purple.commands.commands.BasicCommand;
import fr.purple.commands.parameters.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BasicCommandBuilder {

    private final String name;
    private final List<Parameter> parameters;
    private final Consumer<BasicCommand> executorConsumer;


    public BasicCommandBuilder(String name, Consumer<BasicCommand> executorConsumer) {
        this.name = name;
        this.parameters = new ArrayList<>();
        this.executorConsumer = executorConsumer;
    }

    public BasicCommandBuilder with(Parameter parameter){
        this.parameters.add(parameter);
        return this;
    }

    public void build(CommandContent content){
        BasicCommand executor = new BasicCommand(name, parameters, content);
        executorConsumer.accept(executor);
    }
}
