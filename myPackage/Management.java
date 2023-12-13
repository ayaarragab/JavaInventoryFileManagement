package myPackage;

import java.io.BufferedWriter;
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
     * Updates the specified field of an object in the file.
     *
     * @param obj       The object to be updated.
     * @param fieldName The name of the field to be updated.
     * @param value     The new value for the field.
     * @throws Exception If an error occurs during the file operation.
     */
    public void update(Object obj, String fieldName, String value) throws Exception{
        String[] objectData = ToString.fileToString(this.file).split("\n");
        String placeInReplaced = fieldName + ":" + " " + value;
        StringBuffer collectAgain = new StringBuffer();
        for (int i = 0; i < objectData.length; i++) {
            if (objectData[i].contains(fieldName)) {
                objectData[i] = placeInReplaced;
                break;
            }
        }
        for (String string : objectData) {
            collectAgain.append(string);
            collectAgain.append("\n");
        }
        String updatedData = collectAgain.toString().trim();
        BufferedWriter write = new BufferedWriter(new FileWriter(this.file.getPathName()));
        write.write(updatedData);
        write.close();
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
}
