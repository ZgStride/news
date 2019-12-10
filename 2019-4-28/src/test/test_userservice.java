package test;

import java.util.ArrayList;
import java.util.Iterator;

import user.*;
public class test_userservice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService us = new UserService();
		
		ArrayList<UserBean> list = us.doSelectAll("11");
		Iterator<UserBean> it = list.iterator();
		while(it.hasNext()){
			UserBean user = it.next();
			System.out.println(user.getFavourite());
		}		
	}

}
