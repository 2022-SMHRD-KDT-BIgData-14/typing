package rank;

public class rankDTO {
	
	String  record, nickname, bestround;

	public rankDTO(String record, String nickname, String bestround) {
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

	public String getBestround() {
		return bestround;
	}

	public void setBestround(String bestround) {
		this.bestround = bestround;
	}
	
}
