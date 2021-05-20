package lib;
import java.io.*;
import java.util.*;

abstract class book_info{ //책에 대한 추상 클래스 
	protected String ISBN; //고유 번호  
	protected String subject; // 책 주제
	protected String language; // 언어 
	protected String publisher; // 저자 
	protected String publication_date;//출판일
	public book_info() {
		this.ISBN = " ";
		this.subject = " ";
		this.language = " ";
		this.publisher = " "; 
		this.publication_date =" ";
	}
	public book_info(String ISBN, String subject,String language, String publisher,String publication_date) {
		this.ISBN = ISBN;
		this.subject = subject;
		this.language = language;
		this.publisher =publisher; 
		this.publication_date =publication_date;
	}
	/*------------------get 함수 ------------*/
	public String get_ISBN() {
		return ISBN;
	}
	public String get_subject() {
		return subject;
	}
	public String get_language() {
		return language;
	}
	public String get_publisher() {
		return publisher;
	}
	public String get_publication_date() {
		return publication_date;
	}
	/*------------------set 함수 ------------*/
	public void set_ISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public void set_subject(String subject) {
		this.subject = subject;
	}
	public void set_language(String language) {
		this.language =language;
	}
	public void set_publisher(String publisher) {
		this.publisher = publisher;
	}
	public void set_publication_date(String publication_date) {
		this.publication_date =publication_date;
	}
	
	
	
	public void show_bookinformation() {
		System.out.println("고유번호(ISBN): "+ISBN);
		System.out.println("책 주제:"+ subject);
		System.out.println("책 언어:" + language);
		System.out.println("책 저자: "+ publisher);
		System.out.println("책 출판일: "+ publication_date);
	}
}
class book extends book_info{ //책에 대한 정보 (책의 서브 클래스)
	protected String tag;// 책 태그 
	protected String title;//책 타이틀
	protected String page_number;// 페이지 수 
	protected String book_type ;//책의 형태
	protected boolean borrowed;//대출 여부 대출 가능 =true 대출 가능 = false 책에 대한 대출 불가 
	protected String borrowed_person;// 대출한 사람에 대한 정보
	protected String due_date;//반납 기간
	protected String renew;//대출 연장 

	public book() {
		super();
		this.tag =" ";
		this.title = " ";
		this.page_number = " ";
		this.book_type = " ";
		this.borrowed_person = "없음";
		this.borrowed = true; 
		this.due_date =  "대출 일로부터 7일 ";
		this.renew ="연락 후 연장";
		
	}
	public book(String ISBN, String subject,String language, String publisher,String publication_date,
			String tag,String title,String page_number,String book_type,boolean borrowed,String borrowed_person,String due_date,String renew) {
		super(ISBN,subject,language,publisher,publication_date);
		this.tag =tag;
		this.title = title;
		this.page_number = page_number;
		this.book_type =book_type;
		this.borrowed =borrowed;
		this.borrowed_person = "없음";
		this.due_date = due_date;
		this.renew =renew;
		
	}
	/*
	public void UpdateBookList() throws IOException{
		
	}
	*/
	public void show_borrowedinformation() {
		System.out.println("책 제목: "+ title );
		System.out.println("책 형태: "+ book_type);
		System.out.println("빌려간 사람: "+borrowed_person);
		System.out.println("대출 반납기간: "+due_date);
		System.out.println("대출 연장:"+renew);
	}
	public void show_bookinformation() {
		super.show_bookinformation();
		System.out.println("책 테그: "+ tag);
		System.out.println("책 페이지수: "+ page_number );
		System.out.println("책 제목: "+ title );
		System.out.println("책 형태: "+ book_type);
		if(borrowed == true)
			System.out.println("대출가능 : 대출 가능");
		else 
		{	
			System.out.println("대출가능 : 대출 불가");
			System.out.println("빌려간 사람: "+borrowed_person);
			
		}
		System.out.println("대출 반납기간: "+due_date);
		System.out.println("대출 연장:"+renew);
	}
	
	/*---------------get method 정의 -------------*/
	
	public boolean get_borrowed_state() { //대출 여부
		return borrowed;
	}
	public String get_tag() {
		return tag;
	}
	public String get_title() {
		return title;
	}
	public String get_pagenumber() {
		return page_number;
	}
	public String get_booktype() {
		return book_type;
	}
	public String get_duedate() {
		return due_date;
	}
	public String get_renew() {
		return renew;
	}
	/*---------------set method 정의 -------------*/
	public void set_borrowed_state(String check) { //대출 여부 ->boolean
		if(check == "o") { //가능하면
			this.borrowed =true;
		}
		if(check =="x") { //대출 불가이면
			this.borrowed =false;
		}
	}
	public void set_tag(String tag) {
		this.tag =tag;
	}
	public void set_title(String title) {
		this.title =title;
	}
	public void set_pagenumber(String page_number) {
		this.page_number = page_number;
	}
	public void set_booktype(String book_type) {
		this.book_type =book_type;
	}
	public void set_duedate(String due_Date) {
		this.due_date = due_Date; 
	}
	public void set_renew(String renew) {
		this.renew = renew;
	}
}
