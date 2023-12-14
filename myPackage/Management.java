package myPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * The `Management` class provides a simplified and encapsulated way to interact with files,
 * offering methods for adding, updating, removing, and retrieving data from a file.
 *
 * @author Aya Ragab
 */
public class Management {
    private File file;

    /**
     * Constructs a `Management` object with the specified file.
     *
     * @param file The file to be managed.
     */
    public Management(File file) {
        this.file = file;
    }

    /**
     * Sets the file to be managed.
     *
     * @param file The file to be set.
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Gets the file being managed.
     *
     * @return The file being managed.
     */
    public File getFile() {
        return this.file;
    }
    
    /**
     * Adds an object to the file with the specified identifier.
     *
     * @param obj The object to be added.
     * @param id  The identifier for the object.
     * @throws Exception If an error occurs during the file operation.
     */
    public void add(Object obj, int id) throws Exception{
        this.file.append(ToString.objectToString(obj, id));
    }

   /**
     * Removes the specified object from the file.
     *
     * @param file The file to be modified.
     * @param obj  The object to be removed.
     * @param id   The identifier for the object.
     * @throws Exception If an error occurs during the file operation.
     */
    public void remove(File file, Object obj, int id) throws Exception{
        String allContent = ToString.fileToString(file);
        String contentToBeDeleted = ToString.objectToString(obj, id).trim();
        String result = allContent.replace(contentToBeDeleted, "");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPathName()));
        writer.write(result);
        writer.close();
    }
    /**
     * Removes a block of data from the file based on the provided ID.
     * The block is identified by lines starting with "id", "Id", or "ID"
     * followed by the specified ID.
     * 
     * @param id The ID used to identify the block of data to be removed.
     * @throws Exception If an error occurs while reading from or writing to the file.
     */
    public void remove(int id) throws Exception {
        String line_prev, line_next;
        StringBuilder contentAfterDelete = new StringBuilder();
        
        BufferedReader reader = new BufferedReader(new FileReader(this.file.getPathName()));
        
        line_prev = reader.readLine();
        line_next = reader.readLine();
        
        while (line_next != null) {
            if ((line_next.startsWith("id") || line_next.startsWith("Id") || line_next.startsWith("ID")) && (Integer.parseInt(line_next.substring(4).trim()) == id)) {
                while (line_next != null && !line_next.contains("["))
                    line_next = reader.readLine();
            } else {
                contentAfterDelete.append(line_prev).append("\n");
            }
            
            if (line_next != null) {
                line_prev = line_next;
                line_next = reader.readLine();
            }
        }
        System.out.println(line_prev);
        if (!line_prev.contains("[")) {
            contentAfterDelete.append(line_prev).append("\n");
        }
        reader.close();
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.getFile().getPathName()));
        writer.write(contentAfterDelete.toString());
        writer.close();
    }

    /**
     * Deletes the entire file.
     *
     * @throws Exception If an error occurs during the file operation.
     */
    public void delete() throws Exception{
        this.file.delete();
    }

    /**
     * Deletes all content of the file.
     *
     * @throws Exception If an error occurs during the file operation.
     */
    public void deleteAllContent() throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.file.getPathName()));
        writer.write("");
        writer.close();   
    }

    /**
     * Checks if a value exists in the file based on a specified field name.
     *
     * @param field_name The field name to be searched.
     * @param value      The value to be searched for.
     * @return True if the value exists, false otherwise.
     * @throws Exception If an error occurs during the file operation.
     */
    public boolean isExist(String field_name, String value) throws Exception{
        String searhed = field_name + ": " + value;
        if (ToString.fileToString(this.file).contains(searhed))
            return true;
        else
            return false;
    }

    /**
     * Checks if an object exists in the file based on an identifier.
     *
     * @param obj       The object to be searched for.
     * @param identifier The identifier for the object.
     * @return True if the object exists, false otherwise.
     * @throws Exception If an error occurs during the file operation.
     */
    public boolean isExist(Object obj, int identifer) throws Exception{
        String searhed = ToString.objectToString(obj, identifer);
        if (ToString.fileToString(this.file).contains(searhed))
            return true;
        else
            return false;
    }

    /**
     * Checks if an object exists in the file.
     *
     * @param obj The object to be searched for.
     * @return True if the object exists, false otherwise.
     * @throws Exception If an error occurs during the file operation.
     */
    public boolean isExist(Object obj) throws Exception{
        String searhed = ToString.objectToString(obj);
        if (ToString.fileToString(this.file).contains(searhed))
            return true;
        else
            return false;
    }

    /**
     * Retrieves the string representation of an object based on an identifier.
     *
     * @param obj        The object to be retrieved.
     * @param identifier The identifier for the object.
     * @return The string representation of the object if it exists, null otherwise.
     * @throws Exception If an error occurs during the file operation.
     */
    public String retrieve(Object obj, int identifier) throws Exception {
        if (this.isExist(obj))
            return ToString.objectToString(obj, identifier);
        else
            return null;
    }

    /**
     * Retrieves an array of string representations of objects in the file.
     *
     * @return An array of string representations of objects in the file.
     * @throws Exception If an error occurs during the file operation.
     */
    public String[] retrieve() throws Exception {
        return ToString.fileToString(this.file).split("product");
    }

    /**
     * Retrieves the string representation of an object.
     *
     * @param obj The object to be retrieved.
     * @return The string representation of the object if it exists, null otherwise.
     * @throws Exception If an error occurs during the file operation.
     */
    public String retrieve(Object obj) throws Exception {
        if (this.isExist(obj))
            return ToString.objectToString(obj);
        else
            return null;
    }
    /**
     * Retrieves the value of a specified field for an object with the given ID.
     *
     * @param id         The ID of the object.
     * @param field_name The name of the field to retrieve.
     * @return The value of the specified field if found, or null if the field or object is not found.
     * @throws Exception If an error occurs during the file operation.
     */
    public String retrieveById(int id, String field_name) throws Exception {
        String line;
    
        BufferedReader reader = new BufferedReader(new FileReader(this.file.getPathName()));
        line = reader.readLine();
        while (line != null && !line.contains(field_name)) {
            if ((line = reader.readLine()) != null && (line.startsWith("id") || line.startsWith("Id") || line.startsWith("ID"))) {
                if (Integer.parseInt(line.substring(4)) == id) {
                    while (!line.contains(field_name))
                        line = reader.readLine();
                }
            }
        }
        reader.close();
        return line.substring(field_name.length() + 1);
    }

    /**
     * Updates the specified field of an object with the given ID in the file.
     *
     * @param id         The ID of the object to be updated.
     * @param field_name The name of the field to be updated.
     * @param value      The new value for the field.
     * @throws Exception If an error occurs during the file operation.
     */
    public void update(int id, String field_name, String value) throws Exception {
        String line;
        String placeInReplaced = field_name + ": " + value;
        BufferedReader reader = new BufferedReader(new FileReader(this.file.getPathName()));
        StringBuilder firstPart = new StringBuilder();
        StringBuilder lastPart = new StringBuilder();
        boolean foundId = false;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("[")) {
                if (foundId) {
                    lastPart.append(line).append("\n");
                    while (line != null) {
                        line = reader.readLine();
                        if (line != null) {
                            lastPart.append(line).append("\n");
                        }
                        else
                            break;
                    }
                } else {
                    firstPart.append(line).append("\n");
                }
            } else if (line.startsWith("id") || line.startsWith("Id") || line.startsWith("ID")) {
                if (Integer.parseInt(line.substring(4).trim()) == id) {
                    foundId = true;
                    firstPart.append(line).append("\n");
                } else {
                    firstPart.append(line).append("\n");
                }
            } else if (line.contains(field_name)) {
                firstPart.append(placeInReplaced).append("\n"); 
            } else {
                firstPart.append(line).append("\n");
            }
        }

        reader.close();
        System.out.println(firstPart);
        // Write the updated content back to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.getFile().getPathName()));
        writer.write(firstPart.toString());
        writer.write(lastPart.toString());
        writer.close();
    }
}
