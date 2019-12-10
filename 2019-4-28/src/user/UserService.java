package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import common.DB;

/**
 * 用户的业务处理类
 * @author 张桃洪
 * @data 2019-4-3
 */
public class UserService {
	private UserBean user;
	private DB db = new DB();
	public UserService() {
		
	}
	
	public UserService(UserBean user) {
		this.user = user;
	}

	
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public boolean islogin() {
		
		String sql = "select username from user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"';";
		ResultSet rs = db.executeQuery(sql);
		boolean b = false;
		try {
			b = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
	} 
	public boolean isExist(String uname) {
		
		String sql = "select username from user where username='"+uname+"'";
		ResultSet rs = db.executeQuery(sql);
		//System.out.println(sql);
		//System.out.println(rs);
		boolean b = false;
		try {
			b = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeDB();
		//System.out.println(b);
		return b;
		
	} 
	public int doReigster() {
		String sql = "insert user(username,password,sex,profession,favourite,note) values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getSex()+"','"+user.getProfession()+"','"+user.getFavourite()+"','"+user.getNote()+"');";
		int row = db.executeUpdate(sql);
		db.closeDB();
		return row;
	}
	
	public int changtype(String type,int id) {
		int row=-1;
		String sql = "update user set type='"+type+"' where id = '"+id+"';";
		row = db.executeUpdate(sql);
		db.closeDB();
		return row;
	}
	
	
	
	public ResultSet doSelect() {
		ResultSet r = null;
		return r;
	}
	public int doDelete(int id) {
		int row=-1;
		String sql = "delete from user where id="+id+";";
		row = db.executeUpdate(sql);
		db.closeDB();
		return row;
	}
	public int doUpdateType() {
		return 0;
	} 
	
	public int doUpdatePassword() {
		return 0;
	}
	
	
	public int doUpdatePassword(UserBean user) {
		return 0;
	}
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 * @return
	 */
	public int doUpdatePassword(int id, String password) {
		int row = -1;
		String sql = "update user set password = '"+password+"' where id = '"+id+"';";
		row = db.executeUpdate(sql);
		db.closeDB();
		return row;
	}
	
	
	public int doResetPassword() {
		String sql = "update user set password = '666666' where id = '"+user.getId()+"';";
		int row = db.executeUpdate(sql);
		db.closeDB();
		return row;
	}
	public int doResetPassword(int id) {
		String sql = "update user set password = '666666' where id = '"+id+"';";
		int row = db.executeUpdate(sql);
		db.closeDB();
		return row;
	}
	
	public UserBean doSelectByUsername(String username) {
		UserBean user = null;
		String sql="select id,username,password,sex,profession,favourite,note,type from user where username='"+username+"';";
		ResultSet rs = db.executeQuery(sql);
		try {
			if(rs.next()) {
				user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setProfession(rs.getString("profession"));
				user.setFavourite(rs.getString("favourite"));
				user.setNote(rs.getString("note"));
				user.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return user;
	}
	
	public ArrayList<UserBean> doSelectAll(String name){
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		
		String sql = "select id,username,password,sex,profession,favourite,type from user ";
		if(name != null) {
			sql+=" where username like '%"+name+"%'";
		}
		System.out.println(sql);
		ResultSet rs = db.executeQuery(sql);	
			try {
				while(rs.next()){
					int id = rs.getInt("id");
					String sex = rs.getString("sex");
					if(sex.equals("0")){
						sex = "男";
					}else{
						sex = "女";
					}
					
					String profession = rs.getString("profession");
					if(profession.equals("0")){
						profession = "学生";
					}else if(profession.equals("1")){
						profession = "教师";
					}else {
						profession = "工人";
					} 
					
					String favourite = rs.getString("favourite");
					
					if(favourite.equals("0 1 2")) {
						favourite="电脑网络 影视娱乐 棋牌娱乐";
					}else if(favourite.equals("0 1 ")) {
						favourite="电脑网络 影视娱乐";
					}else if(favourite.equals("0 2 ")) {
						favourite="电脑网络 棋牌娱乐";
					}else if(favourite.equals("1 2 ")) {
						favourite="影视娱乐 棋牌娱乐";
					}else if(favourite.equals("0 ")) {
						favourite="电脑网络";
					}else if(favourite.equals("1 ")) {
						favourite="影视娱乐";
					}else if(favourite.equals("2 ")) {
						favourite="棋牌娱乐";
					}
					
					String type = rs.getString("type");
					if(type.equals("0")){
						type = "普通用户";
					}else{
						type = "管理员";
					}
					UserBean user = new UserBean();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setSex(sex);
					user.setProfession(profession);
					user.setFavourite(favourite);
					user.setType(type);
					list.add(user);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.closeDB();
			}
				
		return list;
	}

}
