public class CondMazeLab extends Maze {

	public static void main(String[] args) {

		// Step 1: Run Maze Simulation
		CondMazeLab myMaze = new CondMazeLab();

	}

	public void step() {
		// Steps 2 and 3: Implement HERE
		orient();
		if (puss.isFacingGully()) {
			puss.jump();
		} else if (puss.isFacingMud()) {
			puss.putOnBoots();
			while (puss.isFacingMud()) {
				puss.forward();
				orient();
			}
			puss.forward();
			puss.takeOffBoots();
		} else if (puss.isFacingDog()) {
			puss.startTipToe();
			while (puss.isFacingDog()) {
				puss.forward();
				orient();
			}
			puss.forward();
			puss.stopTipToe();
		} else {
			puss.forward();
		}
	}

	public void orient() {
		puss.right();
		if (puss.isFacingWall()) {
			puss.left();
			if (puss.isFacingWall()) {
				puss.left();
				if (puss.isFacingWall()) {
					puss.left();
				}
			}
		}
	}

	public CondMazeLab() {
		super(true);
	}
}