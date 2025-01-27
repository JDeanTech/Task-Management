package projectManagement_Dashboard;

//Here we will represent the fields in a single task
public class Tasks {
	private String title; //Task title
	private String description; //Tasks summary
	private String status; //Not Started, In Progress, or Done
	private String assignee; //Name
	
	
	public Tasks(String Title, String Description, String Status, String Assignee){
		title = Title;
		description = Description;
		status = Status;
		assignee = Assignee;
		
		
		
	}//End of Constructor
	
	public String getTitle() {
		return title;
	}//ending braces of getTitle
	
	public void setTitle(String Title) {
		this.title = Title;
	}//ending braces of setTitle
	
	public String getDesciption() {
		return description;
	}//ending braces of getDescription
	
	public void setDescription(String Description) {
		this.description = Description;
	}//ending braces of setDescription
	
	public String getStatus() {
		return status;
	}//ending braces of getStatus
	
	public void setStatus(String Status) {
		this.status = Status;
	}//ending braces of setStatus
	
	public String getAssignee() {
		return assignee;
	}//ending braces of getStatus
	
	public void setAssignee(String Assignee) {
		this.assignee = Assignee;
	}//ending braces of setStatus
	
	


}//End of Tasks Class
