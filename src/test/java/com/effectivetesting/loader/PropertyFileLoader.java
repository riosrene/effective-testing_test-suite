package com.effectivetesting.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.effectivetesting.entry.TestCreateEntry;

public class PropertyFileLoader implements Loader {
	final static Logger logger = Logger.getLogger(TestCreateEntry.class);
	
	public Map<String, String> getTestData(List<String> params) {
		Properties propertyFile = new Properties();
		InputStream input = null;
		Map<String, String> data = new HashMap<String, String>();

		try {
			input = getClass().getClassLoader().getResourceAsStream(params.get(0));
			propertyFile.load(input);
			logger.debug("Parameters to be extracted from: " + params.get(0));
			
			for(int i=1; i < params.size(); i++) {
				data.put(params.get(i), propertyFile.getProperty(params.get(i)));
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;

	}
}
