package rainfallDataSelected;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataGeneratingRainfall {

    public static void main(String[] args) {

        // Define the data to be written
        String[] stationIds = {"SMPAT1", "SMPAT2", "STNMLK1", "STNMLK2"};
        String[] stationNames = {"Simpang Ampat 1", "Simpang Ampat 2", "Station Melaka 1", "Station Melaka 2"};
        String[] districtNames = {"Alor Gajah", "Alor Gajah", "Melaka Tengah", "Melaka Tengah"};
        int[][] dailyRainfall = {
                {10, 8, 5, 9, 7, 11},
                {6, 4, 3, 5, 4, 7},
                {12, 10, 8, 11, 9, 13},
                {9, 7, 6, 8, 6, 10}
        };

        // Specify the output file path
        String outputPath = "rainfall_data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            // Write the data to the file
            for (int i = 0; i < stationIds.length; i++) {
                writer.write(stationIds[i] + "," + stationNames[i] + "," + districtNames[i]);
                for (int j = 0; j < dailyRainfall[i].length; j++) {
                    writer.write("," + dailyRainfall[i][j]);
                }
                writer.newLine();
            }

            System.out.println("Data generation completed. Data written to file: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing data to file: " + e.getMessage());
        }
    }
}
