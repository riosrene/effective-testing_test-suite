package com.effectivetesting.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvFileLoader implements Loader {

	public Map<String, String> getTestData(List<String> params) {
		Map<String, String> testData = new HashMap<String, String>();
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
        	ClassLoader classLoader = getClass().getClassLoader();
        	File file = new File(classLoader.getResource(params.get(0)).getFile());
            br = new BufferedReader(new FileReader(file.getAbsolutePath()));
            
            int i = 0;
            String[] fieldNames = null;
            String[] data = null;
            while ((line = br.readLine()) != null) {
            	if (i == 0) {
            		fieldNames = line.split(cvsSplitBy);
            	} else {
            		data = line.split(cvsSplitBy);
            	}
            	
            	for(String fieldName : fieldNames) {
            		if(i != 0) {
            			testData.put(fieldName, data[i]);
            		}
            	}
            	
            	testData.put(line.split(cvsSplitBy)[0], line.split(cvsSplitBy)[i]);
            	testData.put((params.get(i + 2) + Integer.toString(i)), line.split(cvsSplitBy)[i + 1]);
            	i++;
//            	
            	for(int i = 0; i < data.length; i++) {
//            		testData.put((params.get(i +1) + Integer.toString(i)), data[i]);
//            	}
            	
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        
        } catch (IOException e) {
            e.printStackTrace();
        
        } finally {
            if (br != null) {
                try {
                    br.close();
        
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return testData;
    }

}
