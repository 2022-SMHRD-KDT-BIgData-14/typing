package gameplay;

public class GameVO {

	private long typingSpeed;
	private boolean strEquals;
	
	public GameVO(long typingSpeed, boolean strEquals) {
		this.typingSpeed = typingSpeed;
		this.strEquals = strEquals;
	}
	public long getTypingSpeed() {
		return typingSpeed;
	}
	public void setTypingSpeed(long typingSpeed) {
		this.typingSpeed = typingSpeed;
	}
	public boolean getStrEquals() {
		return strEquals;
	}
	public void setStrEquals(boolean strEquals) {
		this.strEquals = strEquals;
	}
	
}
