package solutions;

import inputs.Day4Input;
import services.ScratchCardService;

public class Day4 {
	
	public static void main (String[] args) {
		ScratchCardService.getWinners(Day4Input.scratchCards);
		ScratchCardService.getCardCount(Day4Input.scratchCards);
	}

}
