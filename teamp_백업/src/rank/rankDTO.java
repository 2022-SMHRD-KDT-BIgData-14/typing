package rank;

public class rankDTO {
	
	String  record, nickname;
	int bestround;

	public rankDTO(String record, String nickname, int bestround) {
		this.record = record;
		this.nickname = nickname;
		this.bestround = bestround;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
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
