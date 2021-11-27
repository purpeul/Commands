package fr.purple.commands.parameters.type;

import java.util.function.Function;

public abstract class CustomType<T> extends ParameterType<T> {

    private final Function<String, T> transform;

    public CustomType(Class<T> current, String name, Function<String, T> transform) {
        super(current, name);
        this.transform = transform;
    }

    @Override
    public Object handle(T obj, Class<?> type) {
        return obj;
    }

    @Override
    public T transformElement(String element) {
        return transform.apply(element);
    }
}
