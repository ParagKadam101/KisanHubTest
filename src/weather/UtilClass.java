package weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UtilClass {
	
	public enum RegionCode {UK, ENGLAND, WALES, SCOTLAND}
	public enum WeatherParam {MAX_TEMP, MIN_TEMP, MEAN_TEMP, SUNSHINE, RAINFALL}
    public enum Key {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC, WIN, SPR, SUM, AUT, ANN}
	static class Constants
	{
		public static final String UK_MAX_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmax/date/UK.txt";
		public static final String UK_MIN_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmin/date/UK.txt";
		public static final String UK_MEAN_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmean/date/UK.txt";
		public static final String UK_SUNSHINE_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Sunshine/date/UK.txt";
		public static final String UK_RAINFALL_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Rainfall/date/UK.txt";
		
		public static final String ENGLAND_MAX_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmax/date/England.txt";
		public static final String ENGLAND_MIN_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmin/date/England.txt";
		public static final String ENGLAND_MEAN_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmean/date/England.txt";
		public static final String ENGLAND_SUNSHINE_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Sunshine/date/England.txt";
		public static final String ENGLAND_RAINFALL_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Rainfall/date/England.txt";
		
		public static final String WALES_MAX_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmax/date/Wales.txt";
		public static final String WALES_MIN_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmin/date/Wales.txt";
		public static final String WALES_MEAN_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmean/date/Wales.txt";
		public static final String WALES_SUNSHINE_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Sunshine/date/Wales.txt";
		public static final String WALES_RAINFALL_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Rainfall/date/Wales.txt";
		
		public static final String SCOTTLAND_MAX_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmax/date/Scotland.txt";
		public static final String SCOTTLAND_MIN_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmin/date/Scotland.txt";
		public static final String SCOTTLAND_MEAN_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Tmean/date/Scotland.txt";
		public static final String SCOTTLAND_SUNSHINE_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Sunshine/date/Scotland.txt";
		public static final String SCOTTLAND_RAINFALL_URL = "http://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/Rainfall/date/Scotland.txt";
		
		// Add more as and when required
	}
	
	private static String urlResolver(String regionCode, String weatherParam){
		String regionWeather = regionCode+"_"+weatherParam;
		switch(regionWeather)
		{
			case "UK_MAX_TEMP": return Constants.UK_MAX_URL;
			case "UK_MIN_TEMP": return Constants.UK_MIN_URL;
			case "UK_MEAN_TEMP":return Constants.UK_MEAN_URL;
			case "UK_SUNSHINE": return Constants.UK_SUNSHINE_URL;
			case "UK_RAINFALL": return Constants.UK_RAINFALL_URL;
				
			case "ENGLAND_MAX_TEMP": return Constants.ENGLAND_MAX_URL;
			case "ENGLAND_MIN_TEMP": return Constants.ENGLAND_MIN_URL;
			case "ENGLAND_MEAN_TEMP":return Constants.ENGLAND_MEAN_URL;
			case "ENGLAND_SUNSHINE": return Constants.ENGLAND_SUNSHINE_URL;
			case "ENGLAND_RAINFALL": return Constants.ENGLAND_RAINFALL_URL;
				
			case "WALES_MAX_TEMP": return Constants.WALES_MAX_URL;
			case "WALES_MIN_TEMP": return Constants.WALES_MIN_URL;
			case "WALES_MEAN_TEMP":return Constants.WALES_MEAN_URL;
			case "WALES_SUNSHINE": return Constants.WALES_SUNSHINE_URL;
			case "WALES_RAINFALL": return Constants.WALES_RAINFALL_URL;
				
			case "SCOTLAND_MAX_TEMP": return Constants.SCOTTLAND_MAX_URL;
			case "SCOTLAND_MIN_TEMP": return Constants.SCOTTLAND_MIN_URL;
			case "SCOTLAND_MEAN_TEMP":return Constants.SCOTTLAND_MEAN_URL;
			case "SCOTLAND_SUNSHINE": return Constants.SCOTTLAND_SUNSHINE_URL;
			case "SCOTLAND_RAINFALL": return Constants.SCOTTLAND_RAINFALL_URL;
			
			// Add more as and when required
				
			default: return "Invalid regionCode or weatherParam";
		}
	}
	
	public static ArrayList<Weather> getWeatherData(ArrayList<Input> inputList) throws Exception
	{
		ArrayList<Weather> weatherArrayList = new ArrayList<>();
		
		for(Input input : inputList)
		{
			URL obj = new URL(urlResolver(input.regionCode.name(), input.weatherParam.name()));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			final String USER_AGENT = "Mozilla/5.0";
			con.setRequestProperty("User-Agent", USER_AGENT);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			ArrayList<String> linesArrayList = new ArrayList<>();
			while ((inputLine = in.readLine()) != null) {
				linesArrayList.add(inputLine);
			}
			String[] lines = linesArrayList.toArray(new String[0]);
			in.close();
			
			String year = "", value, key;
			
			for(int i = 8; i < lines.length; i++)
			{	
				StringTokenizer st = new StringTokenizer(validateLine(lines[i])," ");
				if(st.hasMoreTokens())
				{
					year = st.nextToken();	
									}
				for(Key tempKey : Key.values())
				{
					key = tempKey.name();
					value = st.nextToken();
					weatherArrayList.add(new Weather(input.regionCode.name(), input.weatherParam.name(), year, key, value));
				}
			}
		}
		for(Weather weather:weatherArrayList)
		{
			System.out.println(weather);
		}
		return weatherArrayList;
	}
	
	public static String validateLine(String line)
	{
		char[] lineCharArray = line.toCharArray();
		int count = 0;
		for(int i = 0; i < lineCharArray.length; i++)
		{
			if(lineCharArray[i] == ' ')
			{
				count++;
				if(count > 4)  // We assume that the MAX number of spaces in between two values cannot be more than 4
				{
					lineCharArray[i] = 'N';
					lineCharArray[i+1] = '/';
					lineCharArray[i+2] = 'A';
					count = 0;
				}
			}
			else
			{
				count = 0;
			}
		}
		
		String outputString = new String(lineCharArray);
		StringTokenizer st = new StringTokenizer(outputString," ");
		for(int i = 0; i< (18 - st.countTokens()); i++)
		{
			outputString += "   N/A"; 
		}
		
		return outputString;
	}
}
