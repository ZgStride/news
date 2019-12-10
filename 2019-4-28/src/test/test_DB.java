package test;

import common.DB;

public class test_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DB db = new DB();
		String sql = "delete from user where id=21;";
		 int row = db.executeUpdate(sql);
		 if(row >=0){
		 	System.out.println("删除成功");
		 }else{
			 System.out.println("删除失败");
		 }
	}

}
