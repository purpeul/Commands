package fr.purple.commands.parameters;

import fr.purple.commands.parameters.type.CustomType;
import fr.purple.commands.parameters.type.ParameterType;
import fr.purple.commands.parameters.type.Parameters;

public final class Parameter {

    private final String name;
    private final boolean essentials;
    private final ParameterType type;

    public Parameter(String name, boolean essentials, Parameters type) {
        this.name = name;
        this.essentials = essentials;
        this.type = type.getType();
    }

    public Parameter(String name, boolean essentials, CustomType custom) {
        this.name = name;
        this.essentials = essentials;
        this.type = custom;
    }

    public String getName() {
        return name;
    }

    public boolean isEssentials() {
        return essentials;
    }

    public ParameterType getType() {
        return type;
    }
}
