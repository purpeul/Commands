package fr.purple.commands.parameters.type;

public class NumberParameter extends ParameterType<Integer> {

    public NumberParameter() {
        super(Integer.class, "Nombre");
    }

    @Override
    public Object handle(Integer obj, Class<?> type) {
        if(type == String.class){
            return "" + obj;
        }else {
            return obj;
        }
    }

    @Override
    public Integer transformElement(String element) {
        try{
            return Integer.parseInt(element);
        }catch (Exception e){
            return null;
        }
    }
}
