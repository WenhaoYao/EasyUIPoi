package jxau.model;

/**
 * 
 * @ClassName: User
 * @Description: TODO
 * @author: YaoWenHao
 * @date: 2018年7月16日 下午12:48:22
 */
public class User {
	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String qq;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String phone, String email, String qq) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phone=" + phone + ", email=" + email + ", qq=" + qq + "]";
	}
	
}
