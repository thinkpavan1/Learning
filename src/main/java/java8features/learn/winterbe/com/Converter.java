package java8features.learn.winterbe.com;

@FunctionalInterface
public interface Converter<F,T>{
    T convert(F from);
}

class Main {
    public static void main(String[] args) {
        int i = 10;
        Converter<String,Integer> converter = (from)-> Integer.valueOf (  from );
        Integer converted = converter.convert ( "123" );
        System.out.println ( converted );

        Converter<String,Integer> newObject = Integer::valueOf;
        Integer c = newObject.convert ( "456" );
        System.out.println ( c );

        SomeThing someThingObj = new SomeThing ();
        Converter<String,String> startsWith = someThingObj::startsWith;
        String startingValue = startsWith.convert ( "welcome" );
        System.out.println ( startingValue );

    }
}

class SomeThing{
    public String startsWith(String s){
        return String.valueOf(s.charAt(0));
    }
}