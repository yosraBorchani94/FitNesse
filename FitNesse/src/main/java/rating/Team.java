package rating;

public class Team {
    private String name;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int rating;

    
	public String getName() {
		return name;
	}

	public int getPlayed() {
		return played;
	}

	public int getWon() {
		return won;
	}

	public int getDrawn() {
		return drawn;
	}

	public int getLost() {
		return lost;
	}

	public int getRating() {
		return rating;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlayed(int played) {
		this.played = played;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Team(String name, int played, int won, int drawn, int lost) {
		super();
		this.name = name;
		this.played = played;
		this.won = won;
		this.drawn = drawn;
		this.lost = lost;
		calculateRating();
	}

	private void calculateRating() {
		float value = ((10000f * (won * 3 + drawn)) / (3 * played)) / 100;
		setRating(Math.round(value));
	}
}
