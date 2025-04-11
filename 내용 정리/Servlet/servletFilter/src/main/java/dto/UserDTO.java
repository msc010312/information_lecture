package dto;

public class UserDTO {
	private String username;
	private String password;
	private String user_role;
	
	public UserDTO() {}

	public UserDTO(String username, String password,String user_role) {
		super();
		this.username = username;
		this.password = password;
		this.user_role = user_role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
}
