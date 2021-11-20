package com.bridgelabz;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookCSVFile {

    public static File addressbook_csv = new File("AddressBook.csv");


    public static void createfile() {
        try {
            addressbook_csv.createNewFile();
            System.out.println("\nEmpty File is created successfully....");
        } catch (IOException e) {
            System.out.println("" + e);
        }
    }

    public static void write_csvfile() throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        try {
            FileWriter outfile = new FileWriter(addressbook_csv);
            CSVWriter csvwriter = new CSVWriter(outfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] header = {"Contact Name", "First Name", "Last Name", "Address", "City", "State", "Phone Number",
                    "Email", "Zip"};
            List<String[]> list = new ArrayList<>();
            list.add(header);
            AddressBookMain.contactList.forEach(contact -> {
                String[] details = {contact.getFirst_name(), contact.getLast_name(),
                        contact.getAddress(), contact.getCity(), contact.getState(),
                        String.valueOf(contact.getPhone_number()), contact.getEmail(),
                        String.valueOf(contact.getZip())};
                list.add(details);
            });
            csvwriter.writeAll(list);
            csvwriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
