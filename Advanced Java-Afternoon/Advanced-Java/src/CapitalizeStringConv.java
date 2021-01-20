import java.lang.reflect.Field;


public class CapitalizeStringConv {

    public static void capitalizeString(Object object) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();
        String temp = new String();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(CapitalizeString.class)) {
                CapitalizeString addDate = field.getAnnotation(CapitalizeString.class);
                if (addDate.capitalizeString())
                    temp = field.get(object).toString();
                    field.set(object, temp.substring(0, 1).toUpperCase() + temp.substring(1));
            }
        }
    }
}
