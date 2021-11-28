package fr.purple.commands.builder;

import fr.purple.commands.commands.ComplexCommand;
import fr.purple.commands.commands.Subcommand;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ComplexBuilder {

    private final String name;
    private final List<Subcommand> parameters;
    private final Consumer<ComplexCommand> executorConsumer;
    private String permission;

    public ComplexBuilder(String name, Consumer<ComplexCommand> executorConsumer) {
        this.name = name;
        this.parameters = new ArrayList<>();
        this.executorConsumer = executorConsumer;
        this.permission = "";
    }

    public SubcommandBuilder with(String name){
        return new SubcommandBuilder(name, this);
    }

    public ComplexBuilder with(Subcommand subcmd){
        this.parameters.add(subcmd);
        return this;
    }

    public ComplexBuilder require(String permission){
        this.permission = permission;
        return this;
    }

    public void build(){
        ComplexCommand executor = new ComplexCommand(name, parameters);
        executor.setPermission(permission);
        executorConsumer.accept(executor);
    }
}