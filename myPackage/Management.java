package myPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * @class: Management
 * @author: Aya Ragab
 * @functionality: To use the file methods in much abstracted, encapsulated way in some simple methods:
 * @add: adds an object to file
 * @update: updates object data
 * @remove: remove object data from file
 * @delete: delete the entire file
 * @deleteAllContent: deletes all content of the file
 */
public class Management {
    private File file;

    /* Constructors */   
    public Management(File file) {
        this.file = file;
    }

    /*Getters and setters */
    public void setFile(File file) {
        this.file = file;
    }
    
    public File getFile() {
        return this.file;
    }
    
    /* add methods */
    public void add(Object obj, int id) throws Exception{
        this.file.append(ToString.objectToString(obj, id));
    }

    public void remove(File file, Object obj, int id) throws Exception{
        String allContent = ToString.fileToString(file);
        String contentToBeDeleted = ToString.objectToString(obj, id).trim();
        String result = allContent.replace(contentToBeDeleted, "");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPathName()));
        writer.write(result);
        writer.close();
    }

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
    
    public void delete() throws Exception{
        this.file.delete();
    }
    
    public void deleteAllContent() throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.file.getPathName()));
        writer.write("");
        writer.close();   
    }
}
