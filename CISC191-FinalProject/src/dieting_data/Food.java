package dieting_data;

public class Food {
	String name;
	String type;
	String details;
	
	public Food() {
		
	}
	
	public Food(String name, String type, String details) {
		this.name = name;
		this.type = type;
		this.details = details;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
}
