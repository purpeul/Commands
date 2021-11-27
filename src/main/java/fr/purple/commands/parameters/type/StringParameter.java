package fr.purple.commands.parameters.type;

public class StringParameter extends ParameterType<String>{

    public StringParameter() {
        super(String.class, "Message");
    }

    @Override
    public Object handle(String obj, Class<?> type) {
        return obj;
    }

    @Override
    public String transformElement(String element) {
        return element;
    }
}
