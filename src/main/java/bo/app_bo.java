package bo;

public class app_bo {
	
	private int Id;
	private String Name;
	private String email;
	private String phone;
	private String password;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

    @Override
	public String toString() {
		return "app_bo [Id=" + Id + ", Name=" + Name + ", Email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}
	
	
	

}
