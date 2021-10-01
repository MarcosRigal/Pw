package factories;

import spectacles.MultipleSpectacle;
import spectacles.SeasonSpectacle;
import spectacles.SingleSpectacle;
import spectacles.Spectacle;

public class SpectacleFactory {
	
	public static Spectacle getSpectacle(String type){
		if("Single".equalsIgnoreCase(type)){
			return new SingleSpectacle();
		}
		if("Multiple".equalsIgnoreCase(type)){
			return new MultipleSpectacle();
		}
		if("Season".equalsIgnoreCase(type)){
			return new SeasonSpectacle();
		}
		return null;
	}

}
