package com.effectivetesting.loader;

import java.util.List;
import java.util.Map;

public interface Loader {
	public Map<String, String> getTestData(List<String> params);
}
