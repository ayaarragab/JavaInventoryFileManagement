/**
 * ToString Class
 * 
 * This class provides functionality for converting object data to formatted strings and vice versa.
 * It includes methods for creating formatted strings from object data and reading formatted strings from text files.
 * 
 * @author Aya Ragab
 */

package myPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.*;

public class ToString {
    
    /**
     * Convert object data to a formatted string.
     * 
     * @param obj    The object to be converted.
     * @param number An identifier for the object.
     * @return The formatted string representing the object data.
     * @throws Exception If an error occurs during reflection or method invocation.
     */
    public static String objectToString(Object obj, int number) throws Exception {
        StringBuilder buffer = new StringBuilder();
        Class<?> class_u = obj.getClass();
        buffer.append("[" + class_u.getSimpleName() + " " + number + "]" + "\n");

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

    /**
     * Convert object data to a formatted string without an identifier.
     * 
     * @param obj The object to be converted.
     * @return The formatted string representing the object data.
     * @throws Exception If an error occurs during reflection or method invocation.
     */
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

    /**
     * Convert text file data to a readable format.
     * 
     * @param file The File object representing the text file.
     * @return The formatted string representing the text file data.
     * @throws Exception If an error occurs during file reading.
     */
    public static String fileToString(File file) throws Exception {
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
