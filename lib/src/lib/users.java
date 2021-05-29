package lib;
import java.io.*;
import java.util.ArrayList;
import java.util.stream.*;
import com.opencsv.*;

public class users extends Person { 
	protected String userID;// 아이디 
	protected String userPW;// 비밀번호 	
	protected String history; // 대출 예약 기록 
	public users() {
		super();
		this.userID = "";
		this.userPW = "";
		this.history= "";
	}
	
	public users(String name,String email,String address,String phone,String id,String pw) {
		super(name,email,address,phone);
		userID = id;
		userPW = pw;
	}
	
	public void set_userID(String id) {
		userID = id;
	}
	public void set_userPW(String pw) {
		userPW = pw;
	}
	public void set_userhistory() {
		this.history = "없음";
	}
	public String getUserID() {
		return userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public String getUsershistory() {
		return history;
	}
	public void print_information() {
		super.print_user_information();
		System.out.println("사용자 아이디: "+userID);
		System.out.println("사용자 비밀번호: "+userPW);
		System.out.println("대출기록: "+history);
		System.out.println("-------------------------------");
	}
}
