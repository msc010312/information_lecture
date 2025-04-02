package ch04;

public class UserDto {
	private String userid;
	private String password;
	//생성자/getterandsetter/toSTring
	public UserDto() {}
	public UserDto(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", password=" + password + "]";
	}	
	
}
