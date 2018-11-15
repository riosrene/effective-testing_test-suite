package app.core;

import java.util.HashMap;
import java.util.Map;

public class Sensor {
	private String meassurementUnit;
	private Map<String, String> memory = new HashMap<>();
	
	public String getMeassurementUnit() {
		return meassurementUnit;
	}
	
	public void setMeassurementUnit(String meassurementUnit) {
		this.meassurementUnit = meassurementUnit;
	}
	
	public void saveConfiguration(String configName,String configValue) {
		if(configName.isEmpty() == false || memory.containsKey(configName)) {
			memory.put(configName, configValue);
		}
	}
	
	public Map<String, String> showSavedConfigurations() {
		return this.memory;
	}
	
	public String showConfigValueByName(String configName) {
		return memory.get(configName);
	}
}
