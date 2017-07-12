package buffs;

public class Results {
	
	String title;
	
	public Results() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "\n" + title;
	}	
	
}
