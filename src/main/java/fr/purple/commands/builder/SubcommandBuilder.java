package fr.purple.commands.builder;

import fr.purple.commands.commands.CommandContent;
import fr.purple.commands.commands.Subcommand;
import fr.purple.commands.parameters.Parameter;

import java.util.ArrayList;
import java.util.List;

public class SubcommandBuilder {

    private final ComplexBuilder builder;
    private final List<Parameter> parameters;
    private String permission, desc, name;

    public SubcommandBuilder(String name, ComplexBuilder builder) {
        this.builder = builder;
        this.parameters = new ArrayList<>();
        this.desc = "";
        this.permission = "";
        this.name = name;
    }

    public SubcommandBuilder(ComplexBuilder builder, String description) {
        this.builder = builder;
        this.parameters = new ArrayList<>();
        this.desc = description;
        this.permission = "";
    }

    public SubcommandBuilder with(Parameter parameter){
        this.parameters.add(parameter);
        return this;
    }

    public SubcommandBuilder require(String permission){
        this.permission = permission;
        return this;
    }

    public ComplexBuilder complete(CommandContent content){
        Subcommand cmd = new Subcommand(name, permission, desc, content, parameters);
        return builder.with(cmd);
    }
}
