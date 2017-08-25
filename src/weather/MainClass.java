package weather;

import java.util.ArrayList;
import weather.UtilClass.RegionCode;
import weather.UtilClass.WeatherParam;

public class MainClass {
	public static void main(String[] args) {
	
		Input ukMinTemp = new Input(RegionCode.UK, WeatherParam.MIN_TEMP);
		Input ukMaxTemp = new Input(RegionCode.UK, WeatherParam.MAX_TEMP);
		Input ukMeanTemp = new Input(RegionCode.UK, WeatherParam.MEAN_TEMP);
		Input ukSunshine = new Input(RegionCode.UK, WeatherParam.SUNSHINE);
		Input ukRainfall = new Input(RegionCode.UK, WeatherParam.RAINFALL);
		
		Input englandMinTemp = new Input(RegionCode.ENGLAND, WeatherParam.MIN_TEMP);
		Input englandMaxTemp = new Input(RegionCode.ENGLAND, WeatherParam.MAX_TEMP);
		Input englandMeanTemp = new Input(RegionCode.ENGLAND, WeatherParam.MEAN_TEMP);
		Input englandSunshine = new Input(RegionCode.ENGLAND, WeatherParam.SUNSHINE);
		Input englandRainfall = new Input(RegionCode.ENGLAND, WeatherParam.RAINFALL);
		
		Input walesMinTemp = new Input(RegionCode.WALES, WeatherParam.MIN_TEMP);
		Input walesMaxTemp = new Input(RegionCode.WALES, WeatherParam.MAX_TEMP);
		Input walesMeanTemp = new Input(RegionCode.WALES, WeatherParam.MEAN_TEMP);
		Input walesSunshine = new Input(RegionCode.WALES, WeatherParam.SUNSHINE);
		Input walesRainfall = new Input(RegionCode.WALES, WeatherParam.RAINFALL);
		
		Input scotlandMinTemp = new Input(RegionCode.SCOTLAND, WeatherParam.MIN_TEMP);
		Input scotlandMaxTemp = new Input(RegionCode.SCOTLAND, WeatherParam.MAX_TEMP);
		Input scotlandMeanTemp = new Input(RegionCode.SCOTLAND, WeatherParam.MEAN_TEMP);
		Input scotlandSunshine = new Input(RegionCode.SCOTLAND, WeatherParam.SUNSHINE);
		Input scotlandRainfall = new Input(RegionCode.SCOTLAND, WeatherParam.RAINFALL);
		
		// Add more as and when required
		
		ArrayList<Input> inputList = new ArrayList<>();
		inputList.add(ukMinTemp);
		inputList.add(ukMaxTemp);
		inputList.add(ukMeanTemp);
		inputList.add(ukSunshine);
		inputList.add(ukRainfall);
		
		inputList.add(englandMinTemp);
		inputList.add(englandMaxTemp);
		inputList.add(englandMeanTemp);
		inputList.add(englandSunshine);
		inputList.add(englandRainfall);

		inputList.add(walesMinTemp);
		inputList.add(walesMaxTemp);
		inputList.add(walesMeanTemp);
		inputList.add(walesSunshine);
		inputList.add(walesRainfall);
		
		inputList.add(scotlandMinTemp);
		inputList.add(scotlandMaxTemp);
		inputList.add(scotlandMeanTemp);
		inputList.add(scotlandSunshine);
		inputList.add(scotlandRainfall);
		
		System.out.println("Downloading data please wait..");
		UtilClass.getWeatherData(inputList);
		
	}
}
