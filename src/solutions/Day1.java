package solutions;

import inputs.Day1Input;
import services.CalibrationValueService;

public class Day1 {
	
	public static void main(String[] args) {
		CalibrationValueService.calibrate(Day1Input.calibrationValues);
		CalibrationValueService.recalibrate(Day1Input.calibrationValues);
	}
}
