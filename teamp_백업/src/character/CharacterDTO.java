package character;

public class CharacterDTO {
	int hp;
	int att;
	int def;
	String nickname;

	CharacterDTO(int hp, int att, int def, String nickname) {
		
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.nickname = nickname;
		
	}

	public String getnickname() {
		return nickname;
	}

	public void setnickname(String nickname) {
		this.nickname = nickname;
	}

	public int gethp() {
		return hp;
	}

	public void sethp(int hp) {
		this.hp = hp;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
}
