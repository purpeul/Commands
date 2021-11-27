package fr.purple.commands.parameters.type;

public enum Parameters {

    STRING(new StringParameter()),
    PLAYER(new PlayerParameter()),
    WORLD(new WorldParameter()),
    ;

    private final ParameterType<Object> type;

    Parameters(ParameterType type) {
        this.type = type;
    }

    public ParameterType<Object> getType() {
        return type;
    }
}
