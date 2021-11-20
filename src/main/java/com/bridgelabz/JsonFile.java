package com.bridgelabz;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JsonFile {
    public static File addressbookjson = new File("AddressBook.json");


    public static void createfile() {
        try {

            addressbookjson.createNewFile();
            System.out.println("\nEmpty File is created successfully....");
        } catch (IOException e) {
            System.out.println("" + e);
        }
    }
    public static void jsonWrite() {
        createfile();
        try {

            Writer writer = new FileWriter(addressbookjson);
            new Gson().toJson(AddressBook.book, writer);
            writer.close();
            System.out.println("Details written into JSON File");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
