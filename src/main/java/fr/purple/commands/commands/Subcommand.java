package fr.purple.commands.commands;

import fr.purple.commands.parameters.Parameter;

import java.util.List;

public final class Subcommand {

    private final String name, permission, description;
    private final CommandContent content;
    private final List<Parameter> parameters;

    public Subcommand(String name, String permission,
                      String description, CommandContent content, List<Parameter> parameters) {
        this.name = name;
        this.permission = permission;
        this.description = description;
        this.content = content;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

    public String getDescription() {
        return description;
    }

    public CommandContent getContent() {
        return content;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }
}
