public class Contestant implements Comparable<Contestant>{
	String name;
	int score;
	
	public Contestant(String given_name, int given_score) {
		name = given_name;
		score = given_score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	@Override
	public int compareTo(Contestant comp_contestant) {
		int score_comp;
		score_comp = score - comp_contestant.score;
		
		if (score_comp == 0) {
			return name.compareTo(comp_contestant.name);
		}
		
		else {
			return score_comp;
		}
	}
	
	public boolean equals(Object o) {
		return this.equals(o);
	}
	
	public String toString() {
		String str_score = score + "";
		return name + ": " + str_score;
	}
	
}
