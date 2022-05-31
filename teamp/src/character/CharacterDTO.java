package character;

public class CharacterDTO {
	int hp;
	int att;
	int def;

	CharacterDTO(int hp, int att, int def) {
		
		this.hp = hp;
		this.att = att;
		this.def = def;
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
