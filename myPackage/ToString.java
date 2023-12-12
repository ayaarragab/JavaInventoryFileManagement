package myPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @class ToString
 * @Functionality: The functionality of this class is to do 2 things, convert any object data to formatted string that can be added to files, and do the same with txt file data.
 * @author Aya Ragab
 */
public class ToString{
    public static String objectToString(Object obj, int number) throws Exception {
        StringBuilder buffer = new StringBuilder();
        Class<?> class_u = obj.getClass();
        buffer.append("["+ class_u.getSimpleName() + " " + number + "]" +"\n");

        Method[] methods = class_u.getDeclaredMethods();

        // Sort methods by name
        Arrays.sort(methods, Comparator.comparing(Method::getName));

        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                Object value = method.invoke(obj);
                buffer.append(method.getName().substring(3) + ": " + value + "\n");
            }
        }
        return buffer.toString();
    }

    public static String objectToString(Object obj) throws Exception {
        StringBuilder buffer = new StringBuilder();
        Class<?> class_u = obj.getClass();
        buffer.append(class_u.getSimpleName());

        Method[] methods = class_u.getDeclaredMethods();

        // Sort methods by name
        Arrays.sort(methods, Comparator.comparing(Method::getName));

        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                Object value = method.invoke(obj);
                buffer.append(method.getName().substring(3) + ": " + value + "\n");
            }
        }
        return buffer.toString();
    }


    public static String fileToString(File file) throws Exception{
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(file.getPathName()));
        String line = reader.readLine();
        while (line != null) {
            buffer.append(line);
            buffer.append("\n");
            line = reader.readLine();
        }
        reader.close();
        return buffer.toString();
    }
}