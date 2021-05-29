package lib;
import java.io.*;
import java.util.*;

abstract class book_info{ //책에 대한 추상 클래스  *class about book (abstract)
	protected String ISBN; //고유 번호 * book isbn
	protected String subject; // 책 주제 * book title->subject
	protected String language; // 언어 * book language ->language
	protected String publisher; // 저자 * book author ->publisher
	protected String publicationdate;//출판일 * book publication date 
	public book_info() { //default setting book info
		this.ISBN = " "; 
		this.subject = " ";
		this.language = " ";
		this.publisher = " "; 
		this.publicationdate =" ";
	}
	public book_info(String ISBN, String subject,String language, String publisher,String publicationdate) { //set book info
		this.ISBN = ISBN;
		this.subject = subject;
		this.language = language;
		this.publisher =publisher; 
		this.publicationdate =publicationdate;
	}
	/*------------------get 함수 ------------*/  //get function 
	public String getISBN() {
		return ISBN;
	}
	public String getSubject() {
		return subject;
	}
	public String getLanguage() {
		return language;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getPublicationdate() {
		return publicationdate;
	}
	/*------------------set 함수 ------------*/ //set function
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
	public void set_publication_date(String publicationdate) {
		this.publicationdate =publicationdate;
	}
	
	
	
	public void show_bookinformation() {
		System.out.println("고유번호(ISBN): "+ISBN);
		System.out.println("책 주제:"+ subject);
		System.out.println("책 언어:" + language);
		System.out.println("책 저자: "+ publisher);
		System.out.println("책 출판일: "+ publicationdate);
	}
}
public class book extends book_info{ //책에 대한 정보 (책의 서브 클래스)
	protected String tag;// 책 태그 
	protected String title;//책 타이틀
	protected String pagenumber;// 페이지 수 
	protected String booktype ;//책의 형태
	protected boolean borrow;//대출 여부 대출 가능 =true 대출 가능 = false 책에 대한 대출 불가 
	protected String person;// 대출한 사람에 대한 정보
	protected String duedate;//반납 기간
	protected String renew;//대출 연장 

	public book() {
		super();
		this.tag =" ";
		this.title = " ";
		this.pagenumber = " ";
		this.booktype = " ";
		this.borrow = true; 
		this.person =" ";
		this.duedate =  "대출 일로부터 7일 ";
		this.renew ="연락 후 연장";
		
	}
	public book(String ISBN, String subject,String language, String publisher,String publicationdate,
			String tag,String title,String pagenumber,String booktype,boolean borrow,String person,String duedate,String renew) {
		super(ISBN,subject,language,publisher,publicationdate);
		this.tag =tag;
		this.title = title;
		this.pagenumber = pagenumber;
		this.booktype = booktype;
		this.borrow = borrow;
		this.person = person;
		this.duedate = duedate;
		this.renew = renew;
		
		
	}
	/*
	public void UpdateBookList() throws IOException{
		
	}
	*/
	public void show_borrowedinformation() {
		System.out.println("책 제목: "+ title );
		System.out.println("책 형태: "+ booktype);
		System.out.println("빌려간 사람: "+person);
		System.out.println("대출 반납기간: "+duedate);
		System.out.println("대출 연장:"+renew);
	}
	public void show_bookinformation() {
		super.show_bookinformation();
		System.out.println("책 테그: "+ tag);
		System.out.println("책 페이지수: "+ pagenumber );
		System.out.println("책 제목: "+ title );
		System.out.println("책 형태: "+ booktype);
		if(borrow == true)
			System.out.println("대출가능 : 대출 가능");
		else 
		{	
			System.out.println("대출가능 : 대출 불가");
			System.out.println("빌려간 사람: "+person);
			
		}
		System.out.println("대출 반납기간: "+duedate);
		System.out.println("대출 연장:"+renew);
	}
	
	/*---------------get method 정의 -------------*/
	
	public boolean getBorrow() { //대출 여부
		return borrow;
	}
	public String getTag() {
		return tag;
	}
	public String getTitle() {
		return title;
	}
	public String getPagenumber() {
		return pagenumber;
	}
	public String getPerson() {
		return person;
	}
	public String getBooktype() {
		return booktype;
	}
	public String getDuedate() {
		return duedate;
	}
	public String getRenew() {
		return renew;
	}
	/*---------------set method 정의 -------------*/
	public void set_borrowed_state(String check) { //대출 여부 ->boolean
		if(check == "o") { //가능하면
			this.borrow =true;
		}
		if(check =="x") { //대출 불가이면
			this.borrow =false;
		}
	}
	public void set_tag(String tag) {
		this.tag =tag;
	}
	public void set_title(String title) {
		this.title =title;
	}
	public void set_pagenumber(String pagenumber) {
		this.pagenumber = pagenumber;
	}
	public void set_booktype(String booktype) {
		this.booktype =booktype;
	}
	public void set_duedate(String duedate) {
		this.duedate = duedate; 
	}
	public void set_renew(String renew) {
		this.renew = renew;
	}
}
