package weather;

import weather.UtilClass.RegionCode;
import weather.UtilClass.WeatherParam;

public class Input {
	 RegionCode regionCode;
	 WeatherParam weatherParam;

	public Input(RegionCode regionCode, WeatherParam weatherParam) {
		this.regionCode = regionCode;
		this.weatherParam = weatherParam;
	}
	
}
