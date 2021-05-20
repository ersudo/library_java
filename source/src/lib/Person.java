package lib;
import java.util.*;
public abstract class Person {
	protected String Person_name;
	protected String Person_email;
	protected String Person_address;
	protected String Person_phonenumber;

	public Person() {
		this.Person_name = "";
		this.Person_email = "";
		this.Person_address="";
		this.Person_phonenumber="";
		
	}
	public Person(String name,String email,String address,String phone) {
		this.Person_name = name;
		this.Person_email = email;
		this.Person_address =address;
		this.Person_phonenumber = phone;
	}
	public void print_user_information() {
        System.out.println("-------------------------------");
        System.out.println("|          회원 정보             |");
        System.out.println("-------------------------------");
        System.out.println("이름: "+ Person_name);
        System.out.println("이메일: "+ Person_email);
        System.out.println("주소: "+ Person_address);
        System.out.println("핸드폰 번호: "+Person_phonenumber);
	}
	public void print_lib_information() {
		    System.out.println("-------------------------------");
	        System.out.println("|          사서 정보             |");
	        System.out.println("-------------------------------");
	        System.out.println("이름: "+ Person_name);
	        System.out.println("이메일: "+ Person_email);
	        System.out.println("주소: "+ Person_address);
	        System.out.println("핸드폰 번호: "+Person_phonenumber);
	}
	/*---------------set 함수-------------------*/
	
	public void set_name(String name) {
		Person_name = name;
	}
	public void set_email(String email) {
		Person_email =email;
	}
	public void set_address(String address) {
		Person_address = address;
	}
	public void set_phonenumber(String phone) {
		Person_phonenumber = phone;
	}
	/*---------------get 함수-------------------*/
	
	public String get_name() {
		return Person_name;
	}
	public String get_email() {
		return Person_email;
	}
	public String get_address() {
		return Person_address;
	}
	public String get_phonenumber() {
		return Person_phonenumber;
	}
}