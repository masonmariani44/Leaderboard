public class LeaderBoard {
	int board_size;
	Contestant[] board;
	
	public LeaderBoard(int m) {
		//initilize board size: m and leaderboard: board
		board_size = m;
		board = new Contestant[board_size];
	}
	
	public void add(Contestant c) {
		//loop for check
		int compare;
		//loop through length of board
		for (int i=0; i < board_size; i++) {
			//if the current value is null, put c in its place and break the loop
			if (board[i] == null) {
				board[i] = c;
				break;
			}
			//otherwise...
			else {
				//if score of Contestant to be added is greater than the current value at i, replace and shift
				compare = c.compareTo(board[i]);
				//if greater
				if (compare > 0) {
					//shift every value from the right of array to i up by 1
					for (int j=board_size-1; j > i; j--) {
						board[j] = board[j-1];
					}
					//replace i value and break loop
					board[i] = c;
					break;					
				}
			}
		}	
	}
	
	
	public Contestant[] finalBoard() {
		return board;
	}
	
}
