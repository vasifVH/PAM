package Hooks;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVDataReader {

    public static List<String[]> readSection(String filePath , String sectionName) {
        List<String[]> sectionData = new ArrayList<>();
        boolean inSection = false;
        boolean skipHeader = false;
        String[] headers = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             CSVReader csvReader = new CSVReader(br)) {

            String[] line;
            while ((line = csvReader.readNext()) != null) {

                // Skip completely empty lines
                if (line.length == 0 || (line.length == 1 && line[0].trim().isEmpty())) {
                    continue;
                }

                // Section markers
                if (line.length == 1) {
                    String singleValue = line[0].trim();

                    if (singleValue.equalsIgnoreCase(sectionName)) {
                        inSection = true;
                        skipHeader = true;
                        continue;
                    } else if (singleValue.equalsIgnoreCase("section end")) {
                        inSection = false;
                        continue;
                    } else if (singleValue.equalsIgnoreCase("end")) {
                        break;
                    }
                }

                // Skip header line right after section name
                if (inSection && skipHeader) {
                    skipHeader = false;
                    continue;
                }

                // Add data row if within section
                if (inSection) {
                    sectionData.add(line);
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return sectionData;
    }
}