package bo;

public class app_bo_add {
	
	
	private  int id;
	private String task;
	private String  status;
    private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name= name;
	}
	@Override
	public String toString() {
		return "app_bo_add [id=" + id + ", task=" + task + ", status=" + status + ", Name=" + name + "]";
	}
	
	
	
    
    
}
