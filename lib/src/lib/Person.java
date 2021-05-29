package lib;
import java.util.*;
public abstract class Person { //abstract class ->person , make person basic information 
	protected String name;
	protected String email;
	protected String address;
	protected String phone;

	public Person() { 
		this.name = " "; //make blank ->basic 
		this.email = " ";
		this.address=" ";
		this.phone=" ";
		
	}
	public Person(String name,String email,String address,String phone) {
		this.name = name;
		this.email = email;
		this.address =address;
		this.phone = phone;
	}
	public void print_user_information() {
        System.out.println("-------------------------------"); // top line 
        System.out.println("|          회원 정보             |");  // personal information  title 
        System.out.println("-------------------------------");  // bottom line
        System.out.println("이름: "+ name);// person name
        System.out.println("이메일: "+ email);// person email
        System.out.println("주소: "+ address);// person address
        System.out.println("핸드폰 번호: "+phone);//person phone number
	}
	public void print_lib_information() {
		System.out.println("-------------------------------");
	    System.out.println("|          사서 정보             |"); // librarian information - title
	    System.out.println("-------------------------------"); 
	    System.out.println("이름: "+ name); 
	    System.out.println("이메일: "+ email); 
	    System.out.println("주소: "+ address); 
	    System.out.println("핸드폰 번호: "+phone); 
	}
	/*---------------set 함수-------------------*/  //set function describe
	
	public void set_name(String name) {
		this.name = name;
	}
	public void set_email(String email) {
		this.email = email;
	}
	public void set_address(String address) {
		this.address = address;
	}
	public void set_phonenumber(String phone) {
		this.phone = phone;
	}
	/*---------------get 함수-------------------*/ //get function describe
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
}