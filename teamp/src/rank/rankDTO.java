package rank;

public class rankDTO {
	
	String  nickname;
	int bestround;
	public rankDTO(String nickname, int bestround) {
		super();
		this.nickname = nickname;
		this.bestround = bestround;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getBestround() {
		return bestround;
	}
	public void setBestround(int bestround) {
		this.bestround = bestround;
	}

	
}
