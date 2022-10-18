package no.hvl.dat100ptc.oppgave4;


import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	//a)
	// beregn total distances (i meter)
	public double totalDistance() {
		
 double distance = 0;

		
 // TODO - START
		for (int i = 0; i < gpspoints.length - 1; i++) {
			
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]); 
			// distance mellom det forrige punktet og det nåværende punktet f.eks. fra punkt 3 til punkt 4.
			
		}
		return distance;
/**Forklaring: 1. implementer metoden public douuble totalDistance() som beregner den totale distansen på ruten som GPS datene i gpspoints-tabellen angir. 
*Dvs metoden må legge sammen distanser mellom de punktene som utgjør ruten. 
*2. implementerer Data type bouble distance = 0;. Double som lagrer brøktall. Tilstrekkelig for lagring av 15 desimaler. 
*3. implementerer for (int i = 0; i < gpspoints.length - 1; i++). Jeg vet hvor mange ganger jeg vil gå gjennom en kodeblokk, bruker jeg for-løkken.
* for (utsagn 1(int = 0); utsagn 2( i < gpspoints.length -1), utsagn 3(i++)), utsagn 1: utføres (en gang) før utførelse av kodeblokken,
* utsagn 2: definerer betingelsen for å utføre kodeblokken, utsagn 3: utføres (hver gang) etter at kodeblokken er utført.
* utsagn 1 setter en variable før løkken starter(int i = 0). utsagn 2 definerer betingelsen for at sløyfen skal kjøre(i må være større enn (gpspoints.length - 1). 
* hvis betingelsen er sann, vil sløyfen starte på nytt, hvis det er usann, vil sløyfen avsluttes. 
* utsagn 3 øker en verdi (i++) hver gang kodeblokken i løkken har blit utført. 
* (distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1])): distance = GPSUtils.distance(gpspoints[i] +  gpspoints[i+1].
**/

		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		// TODO - START
		for (int i = 0; i < gpspoints.length - 1; i++) {
			
			if (gpspoints[i].getElevation() > gpspoints[i].getElevation()) {
				elevation += gpspoints[i+1].getElevation() - gpspoints[i].getElevation();		
			}
		}
		return elevation;
/** Implementer metoden public double totalElevation() som beregner det totale antall høydemeter på ruten.
*2. implementerer Data type bouble elevation = 0;. 3.for (int i = 0; i < gpspoints.length - 1; i++). 
*4. if (gpspoints[i].getElevation() > gpspoints[i].getElevation()): Bruker if-setningen for å spesifisere en blokk med Java-kode 
*som skal utføres hvis en betingelse er sann. Hvis gpspoints[i].getElevation() > gpspoints[i].getElevation().
*5. elevation += gpspoints[i+1].getElevation() - gpspoints[i].getElevation(): elevation = elevation + gpspoints[i+1].getElevation() - gpspoints[i].getElevation()
* 6. return elevation : ... (elevation) i outputs
**/
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		
		int lengde = gpspoints.length - 1;
		
		int time = gpspoints[lengde].getTime() - gpspoints[0].getTime();
		
		return time;
		
		//throw new UnsupportedOperationException(TODO.method());

	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		
		double[] speed = new double[gpspoints.length - 1];
		
		// TODO - START		// OPPGAVE - START
		
		for (int i = 0; i < gpspoints.length - 1; i++) {
		
			speed[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		
		}
		
		return speed;
	}
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO - START
		double [] maxSpeed = speeds();
		
		for (double speed : maxSpeed) {
			
			if (speed > maxspeed)
				maxspeed = speed;
		}
		
		
		return maxspeed;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}	
		

	public double averageSpeed() {

		double average = 0;
		
		// TODO - START
		
	average = ((totalDistance()/totalTime())*60*60)/1000;
		
		return average;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal;
		
		
		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;
		

		// TODO - START
		if (speedmph < 10) 
			met = 4.0;
		
		else if (speedmph < 12) 
			met = 6.0;
		
		else if (speedmph < 14) 
			met = 8.0;
		
		else if (speedmph < 16) 
			met = 10.0;
		
		else if (speedmph < 20) 
			met = 12.0;
		
		else 
			
		        met = 16.0;
		
		kcal = (met * weight * secs)/60/60;
		
		return kcal;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO - START
		double[] speed = speeds();
		
		int[] time = new int[speed.length];
		
		for (int i = 0; i < time.length; i++) {
		
			time[i] = gpspoints[i+1].getTime() - gpspoints[i].getTime();
			
			totalkcal += kcal(weight, time[i], speed[i]);
			
					
		}
		
		return totalkcal;
	}
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	private static double WEIGHT = 80.0;

	public String[] displayStatistics() {

		System.out.println("==============================================");
		int TEXTWIDTH = 15;
		
		String tid = (GPSUtils.formatTime(totalTime()));
		double distance = Math.round(totalDistance()*100)/100.0;
		double totalElevat = Math.round(totalElevation()*100/100.0);
		double maxSpeed = Math.round(maxSpeed()*100)/100.0;
		double average = Math.round(averageSpeed()*100)/100.0;
		double energi = Math.round(totalKcal(WEIGHT)*100)/100.0;
		String totTime = (String.format("%" + - TEXTWIDTH + "s", "Total Time") + ":" + String.format("%" + 12 + "s", tid));
		String totDist = (String.format("%" + - TEXTWIDTH + "s", "Total Distance") + ":" + String.format("%" + 12 + "s", String.format("%.2f", distance)) + "   km");
		String totElev = (String.format("%" + - TEXTWIDTH + "s", "Total elevation") + ":" + String.format("%" + 12 + "s", String.format("%.2f", totalElevat)) + "    m");
		String maxSp = (String.format("%" + - TEXTWIDTH + "s", "Max speed") + ":" + String.format("%" + 12 + "s", String.format("%.2f", maxSpeed)) + " km/t");
		String avgSp = (String.format("%" + - TEXTWIDTH + "s", "Average speed") + ":" + String.format("%" + 12 + "s", String.format("%.2f", average))  + " km/t");
		String Energ = (String.format("%" + - TEXTWIDTH + "s", "Energy") + ":" + String.format("%" + 12 + "s", String.format("%.2f", energi)) + " kcal");
		totDist = totDist.replace(',','.');
		totElev = totElev.replace(',', '.');
		maxSp = maxSp.replace(',','.');
		avgSp = avgSp.replace(',', '.');
		Energ = Energ.replace(',', '.');
		
		
		System.out.println(totTime);
		System.out.println(totDist);
		System.out.println(totElev);
		System.out.println(maxSp);
		System.out.println(avgSp);
		System.out.println(Energ);
		
		String[] strTab = new String[5];
		strTab[0] = totTime;
		strTab[1] = totDist;
		strTab[2] = totElev;
		strTab[3] = maxSp;
		strTab[4] = avgSp;
		strTab[5] = Energ;
		
		
		
		System.out.println("==============================================");
		return strTab;
		
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
		
	}

}
