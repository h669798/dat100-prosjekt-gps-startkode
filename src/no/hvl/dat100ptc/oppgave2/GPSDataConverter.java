package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
	
	private static int TIME_STARTINDEX = 11;

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		// Format eksempel: 2022-10-18T59:30:01.000Z
		
		hr = Integer.parseInt(timestr.substring(TIME_STARTINDEX,13));
		min = Integer.parseInt(timestr.substring(14,16));
		sec = Integer.parseInt(timestr.substring(17,19));
		
		secs = (hr*60*60) + (min*60) + sec;
		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;
		
		int time = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		
		gpspoint = new GPSPoint(time, latitude, longitude, elevation);
	      return gpspoint;
	}
	
}
