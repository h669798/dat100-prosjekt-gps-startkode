package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}
	

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

	}

	
	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];
		
		for(int i = 0; i < latitudes.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

            double[] longitudes = new double[gpspoints.length];
		
		for(int i = 0; i < longitudes.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = toRadians(gpspoint1.getLatitude());
		longitude1 = toRadians(gpspoint1.getLongitude());
		latitude2 = toRadians(gpspoint2.getLatitude());
		longitude2 = toRadians(gpspoint2.getLongitude());
		
		double latitude = latitude2 - latitude1;
		double longitude = longitude2 - longitude1;

		double a = pow(sin(latitude/2.0), 2)
			+ (cos(latitude1)
			* cos(latitude2)
			* pow(sin(longitude/2),2));
		
		double c = 2 * atan2(sqrt(a), sqrt(1-a));
		d = (R * c);
		
		return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs = gpspoint2.getTime() - gpspoint1.getTime();
		double distance = distance(gpspoint1, gpspoint2);
		double speed = distance/secs;
		
		speed *= 3.6;
		return speed;


	}

	public static String formatTime(int secs) {

		String timestr;
		
		int ss = secs % 60;
		secs /= 60;
		int mm = secs % 60;
		secs /= 60;
		int hh = secs % 60;
		
		timestr = String.format("%02d:%02d:%02d", hh,mm,ss);
		return timestr;
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = String.format("%.2f", d);
		String storrelse = String.format("%10s", str);
		
		return storrelse;
		
	}
}
