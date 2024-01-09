package entity;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String userPassword;
	private int failedLogin;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

	public User(String firstName, String lastName, String email, String userName, String userPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getFailedLogin() {
		return failedLogin;
	}

	public void setFailedLogin(int failedLogin) {
		this.failedLogin = failedLogin;
	}

}
