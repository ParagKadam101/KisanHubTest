package weather;

public class Weather {
	private String regionCode, weatherParam, year, key, value  ;

	public Weather(String regionCode, String weatherParam, String year,
			String key, String value) {
		super();
		this.regionCode = regionCode;
		this.weatherParam = weatherParam;
		this.year = year;
		this.key = key;
		this.value = value;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getWeatherParam() {
		return weatherParam;
	}

	public void setWeatherParam(String weatherParam) {
		this.weatherParam = weatherParam;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Weather [regionCode=" + regionCode + ", weatherParam="
				+ weatherParam + ", year=" + year + ", key=" + key + ", value="
				+ value + "]";
	}
	
	
	
	
}
