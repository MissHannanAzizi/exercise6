package rainfallDataSelected;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReadRainfall {
    public static void main(String[] args) {

        // Specify the input file path
        String inputPath = "rainfall_data.txt";

        // Variables for computed values
        int stationCount = 0; // Count of stations
        int districtCount = 0; // Count of districts
        int[] stationRainfallSum = new int[4]; // Array to store rainfall sum for each station

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9) { // Ensure the data has the expected number of elements
                    String stationId = data[0];
                    String stationName = data[1];
                    String districtName = data[2];

                    System.out.println("Station ID: " + stationId);
                    System.out.println("Station Name: " + stationName);
                    System.out.println("District Name: " + districtName);

                    int[] dailyRainfall = new int[6]; // Array to store daily rainfall readings
                    for (int i = 0; i < 6; i++) {
                        dailyRainfall[i] = Integer.parseInt(data[i + 3]);
                        System.out.println("Day " + (i + 1) + " Rainfall: " + dailyRainfall[i]);
                        stationRainfallSum[stationCount] += dailyRainfall[i];
                    }

                    System.out.println();

                    stationCount++;
                    if (stationCount == 2) { // Two stations belong to the same district
                        districtCount++;
                        stationCount = 0;
                    }
                }
            }

            System.out.println("Average Rainfall:");
            for (int i = 0; i < stationRainfallSum.length; i++) {
                double averageRainfall = (double) stationRainfallSum[i] / 6; // Compute average rainfall
                System.out.println("Station " + (i + 1) + ": " + averageRainfall);
            }

            System.out.println("Number of Stations: " + stationRainfallSum.length);
            System.out.println("Number of Districts: " + districtCount);
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
    }
}
