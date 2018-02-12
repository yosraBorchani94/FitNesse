package rating;

import fit.ColumnFixture;

public class VerifyRating extends ColumnFixture {

	private String teamName;
	private int played;
	private int won;
	private int drawn;
	private int lost;
	Team team = null;

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamName() {
		return teamName;
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

	public Team getTeam() {
		return team;
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

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public long rating() {
		team = new Team(teamName, played, won, drawn, lost);
		return team.getRating();
	}
}
