package myPackage;

import java.io.*;
/**
 * File class
 * @pathName: path of the file
 * @author Aya 
 * Constructor: File(String pathName, char mode) that once File object created, a java.io.File,
    java.io.PrintWriter, and java.util.Scanner objects are created.
 * This is a class that make you able to create, write, and read files.
 */
public class File{
    String pathName;
    java.io.File file;
    BufferedReader Reader;
    BufferedWriter Writer;

    public File(String pathName) throws Exception{
        this.pathName = pathName;
        this.file = new java.io.File(pathName);
    }
    public void write(String s) throws Exception{
        this.Writer = new BufferedWriter(new FileWriter(this.getPathName()));
        this.Writer.write(s);
        this.Writer.close();
    }
    public void write(char s) throws Exception{
        this.Writer = new BufferedWriter(new FileWriter(this.getPathName()));
        this.Writer.write(s);
        this.Writer.close();
    }
    public void append(String s) throws Exception{
        this.Writer = new BufferedWriter(new FileWriter(this.getPathName(), true));
        this.Writer.append(s);
        this.Writer.close();
    }
    public String readLine() throws Exception{
        this.Reader = new BufferedReader(new FileReader(pathName));
        return this.Reader.readLine();
    }
    public void delete() throws Exception{
        this.file.delete();
    }
    public void closeReader() throws Exception{
        this.Reader.close();
    }
    public BufferedReader getBufferReader() throws Exception{
        return this.Reader;
    }
    public BufferedWriter getBufferedWriter() throws Exception{
        return this.Writer;
    }
    public String getPathName() {
        return this.pathName;
    }
    public java.io.File getFileObject() throws Exception{
        return this.file;
    }
}