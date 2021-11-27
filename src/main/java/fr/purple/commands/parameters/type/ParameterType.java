package fr.purple.commands.parameters.type;

public abstract class ParameterType<S> {

    private final String name;
    private final Class<S> sClass;

    public ParameterType(Class<S> sClass, String name) {
        this.sClass = sClass;
        this.name = name;
    }

    public Class<S> getsClass() {
        return sClass;
    }
    public String getName() { return name; }


    public abstract Object handle(S obj, Class<?> type);

    public abstract S transformElement(String element);
}
