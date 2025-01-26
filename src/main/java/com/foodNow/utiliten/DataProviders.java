package com.foodNow.utiliten;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "validRegistrationData")
    public Iterator<Object[]> validRegistrationData() throws IOException {
        return readDataFromCSV("src/test/resources/RegistrationPositive.csv");
    }

    @DataProvider(name = "invalidRegistrationData")
    public Iterator<Object[]> invalidRegistrationData() throws IOException {
        return readDataFromCSV("src/test/resources/RegistrationNegative.csv");
    }

    @DataProvider(name = "invalidLoginData")
    public Iterator<Object[]> invalidLoginData() throws IOException {
        return readDataFromCSV("src/test/resources/LoginNegative.csv");
    }

    private Iterator<Object[]> readDataFromCSV(String filePath) throws IOException {
        List<Object[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while (line != null) {
                list.add(line.split(","));
                line = reader.readLine();
            }
        }
        return list.iterator();
    }
}
