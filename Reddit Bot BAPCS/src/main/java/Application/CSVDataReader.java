package Application;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {
    List<Application.SolidStateDriveInformation> driveInformation;

    public CSVDataReader() {
        driveInformation = new ArrayList<>();

        try {
            // This is the url of the CSV file we are parsing
            URL stockURL = new URL("https://docs.google.com/spreadsheets/d/1B27_j9NDPU3cNlj2HKcrfpJKHkOf-Oi1DbuuQva2gT4/export?format=csv");

            // We are building a CSV parser that uses the delimiter ',' and ignores anything in quotations. We also skip the first row as we don't need the field headers
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(stockURL.openStream())).withCSVParser(parser).withSkipLines(1).build();
            String[] record;

            // Import up to date information into our list
            while ((record = csvReader.readNext()) != null) {
                driveInformation.add(new SolidStateDriveInformation(record[0], record[1], record[2], record[3], record[4], record[5],
                        record[6], record[7], record[8], record[9], record[10], record[11], record[12], record[13], record[14], record[15],
                        record[16], record[17], record[18], record[19], record[20], record[21]));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        System.out.println("SSD's imported: " + driveInformation.size());
    }


    public String print(String modelName) {
        for (SolidStateDriveInformation value : driveInformation) {
            if (value.getModelName().equalsIgnoreCase(modelName)) {
                return value.toString();
            }
        }
        return null;
    }

    public String printDeepSearch(String modelName) {
        for (SolidStateDriveInformation value : driveInformation) {
            if (value.getModelName().equalsIgnoreCase(modelName)) {
                return value.toString();
            } else if (value.getModelName().toLowerCase().contains(modelName.toLowerCase())) {
                return value.toString();
            }
        }
        return null;
    }

    public boolean searchSSD(String modelName) {
        for (SolidStateDriveInformation value : driveInformation) {
            if (value.getModelName().equalsIgnoreCase(modelName)) {
                return true;
            }
        }
        return false;
    }

    public boolean deepSearchSSD(String modelName) {
        for (SolidStateDriveInformation value : driveInformation) {
            if (value.getModelName().toLowerCase().contains(modelName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
