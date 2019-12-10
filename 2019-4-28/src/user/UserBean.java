package user;
/**
 * 用户基本信息类
 * @author 张桃洪
 * @data 2019-4-3
 *
 */

public class UserBean {
	//select id,username,password,sex,profession,favourite,type from user;
	
	private int id;
	private String username;
	private String password;
	private String sex;
	private String profession;
	private String favourite;
	private String note;
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	private String type;
	
	public UserBean() {
		super();
	}

	public UserBean(int id) {
		this.id = id;
	}

	public UserBean(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getFavourite() {
		return favourite;
	}

	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
