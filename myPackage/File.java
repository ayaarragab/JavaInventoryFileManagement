package myPackage;

import java.io.*;
/**
 * File Class
 * 
 * This class provides functionalities for file operations, including writing, reading, and deleting files.
 * It encapsulates a java.io.File object, BufferedReader, and BufferedWriter for file handling.
 * 
 * @author Aya Ragab
 */
public class File{
    String pathName;
    java.io.File file;
    BufferedReader Reader;
    BufferedWriter Writer;
    /**
     * Constructor
     * 
     * @param pathName The path of the file.
     * @throws Exception If an error occurs during file initialization.
     */
    public File(String pathName) throws Exception{
        this.pathName = pathName;
        this.file = new java.io.File(pathName);
    }

    /**
     * Write a string to the file.
     * 
     * @param s The string to be written.
     * @throws Exception If an error occurs during file writing.
     */
    public void write(String s) throws Exception{
        this.Writer = new BufferedWriter(new FileWriter(this.getPathName()));
        this.Writer.write(s);
        this.Writer.close();
    }

    /**
     * Write a character to the file.
     * 
     * @param s The character to be written.
     * @throws Exception If an error occurs during file writing.
     */
    public void write(char s) throws Exception{
        this.Writer = new BufferedWriter(new FileWriter(this.getPathName()));
        this.Writer.write(s);
        this.Writer.close();
    }

    /**
     * Append a string to the end of the file.
     * 
     * @param s The string to be appended.
     * @throws Exception If an error occurs during file appending.
     */
    public void append(String s) throws Exception{
        this.Writer = new BufferedWriter(new FileWriter(this.getPathName(), true));
        this.Writer.append(s);
        this.Writer.close();
    }

    /**
     * Read a line from the file.
     * 
     * @return The read line.
     * @throws Exception If an error occurs during file reading.
     */
    public String readLine() throws Exception{
        this.Reader = new BufferedReader(new FileReader(pathName));
        return this.Reader.readLine();
    }

    /**
     * Delete the file.
     * 
     * @throws Exception If an error occurs during file deletion.
     */
    public void delete() throws Exception{
        this.file.delete();
    }

    /**
     * Close the file reader.
     * 
     * @throws Exception If an error occurs during file reader closing.
     */
    public void closeReader() throws Exception{
        this.Reader.close();
    }

    /**
     * Get the file's BufferedReader.
     * 
     * @return The BufferedReader object.
     * @throws Exception If an error occurs.
     */
    public BufferedReader getBufferReader() throws Exception{
        return this.Reader;
    }

    /**
     * Get the file's BufferedWriter.
     * 
     * @return The BufferedWriter object.
     * @throws Exception If an error occurs.
     */
    public BufferedWriter getBufferedWriter() throws Exception{
        return this.Writer;
    }

    /**
     * Get the path of the file.
     * 
     * @return The path of the file.
     */
    public String getPathName() {
        return this.pathName;
    }

    /**
     * Get the java.io.File object.
     * 
     * @return The java.io.File object.
     * @throws Exception If an error occurs.
     */
    public java.io.File getFileObject() throws Exception{
        return this.file;
    }
}