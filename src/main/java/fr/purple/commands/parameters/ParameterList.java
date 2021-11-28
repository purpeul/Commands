package fr.purple.commands.parameters;


import fr.purple.commands.utils.Pair;

import java.util.List;

public final class ParameterList {

    private final List<Pair<Parameter, Object>> arguments;

    public ParameterList(List<Pair<Parameter, Object>> arguments) {
        this.arguments = arguments;
    }

    public <T> T get(int index){
        return (T) arguments.get(index).getB();
    }

    public <T> T get(int index, Class<T> tclass){

        Pair<Parameter, Object> o = arguments.get(index);

        if(o == null) return null;
        return tclass.cast(o.getB().getClass() == tclass ? o : o.getA().getType().handle(o.getB(), tclass));
    }
}
