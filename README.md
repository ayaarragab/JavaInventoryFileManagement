# Implementation_of_File_class_and_Management_class_in_Inventory_system_In_Java
# Inventory Management System - Implementation of File class and Management class in Java

## File Class

### Overview
The `File` class is a fundamental component of the Inventory Management System. It provides functionalities to create, write, and read files. The class encapsulates the operations related to file handling, ensuring a clean and straightforward interface for other modules.

### Constructor
```java
File(String pathName)

## Management Class

### Overview
The `Management` class serves as a higher-level abstraction for handling file operations. It simplifies the usage of the `File` class by providing methods to add, update, remove, delete, and delete all content. The class ensures that file operations are performed in an encapsulated and organized manner.

### Methods
#### `add(Object obj, int id)`
Adds an object to the file.

#### `update(Object obj, int id)`
Updates the data of an existing object in the file.

#### `remove(Object obj, int id)`
Removes object data from the file.

#### `delete()`
Deletes the entire file.

#### `deleteAllContent()`
Deletes all content within the file.

## ToString Class

### Overview
The `ToString` class plays a crucial role in the `Management` class. It is responsible for converting object data to formatted strings that can be easily added to files. Additionally, it facilitates the conversion of text file data back into a readable format.

### Methods
#### `objectToString(Object obj, int number)`
Converts any object's data to a formatted string for storage in files.

#### `fileToString(File file)`
Converts text file data into a readable format.

## Author
This aspect of the project was implemented by Aya Ragab.
