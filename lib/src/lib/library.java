package lib;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
public class library {
	private String library_name;// 도서관 이름
	private String library_call_number; // 도서관 연락처
	private String library_address;//도서관 주소
	private String work_day;// 일하는 날 
	private String holiday;//쉬는 날 
	private ArrayList <book> bookDB;//책에 대한 db 생성
	private ArrayList <Person> personDB;//개인 정보 db 생성
	private librarian librarian; // 사서 객체 생성
	
	private static library obj;
	
	public static library getInstance() { //도서관에대한 isntance 색성 
		if(obj == null) {
			obj =new library();
		}
		return obj;
	}
	
	private library() {
		library_name = "신평동 국립 ";
		librarian = null; 
		library_call_number = "541-74xx";
		library_address ="구미시 신평동 국립xx";
		work_day = "월요일 -금요일 (주중)";
		holiday = "주말 및 법정 공휴일";
		personDB = new ArrayList<Person>();
		//bookDB = new ArrayList<book>(); 
	}
	
	/*--------------------get 함수 -----------------*/
	public String get_library_name() {
		return library_name;
	}
	public String get_library_call_number() {
		return library_call_number;
	}
	public String get_library_address() {
		return library_address; 
	}
	public String get_workday() {
		return work_day;
	}
	public String get_holiday() {
		return holiday;
	}
	/*--------------------구현 함수 -DB 관련 -----------------*/
	public void addBookDB(book new_book) {
		bookDB.add(new_book); // 책에 대한 db 생성
	}
	public void create_users(Person new_person) {
		personDB.add(new_person);
	}
	public String get_usersID(users new_user) {
		return new_user.get_userID();
	}
	public String get_userPW(users new_user) {
		return new_user.get_userPW();
	}
	/*--------------------구현 함수 -자리 관련 -----------------
	public void seat_view() {
		System.out.print("--------------------------------------------------");
		System.out.print("| 1번 자리  |  2번 자리 | 3번 자리 | 4번 자리 |  5번 자리  |");
		// 에약 상태 에 대한 보여줌 
		System.out.print("-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡ-ㅡㅡ-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡ-|");
		System.out.print("| 6번 자리  |  7번 자리 | 8번 자리 | 9번 자리 | 10번 자리  |");
		System.out.print("-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡ-ㅡㅡ-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡ-|");
		System.out.print("| 11번 자리 | 12번 자리 | 13번 자리 | 14번 자리 | 15번 자리|");
		System.out.print("--------------------------------------------------");
	}
	*/
	/*--------------------구현 함수 -user 데이터 관련 -----------------*/
	public void set_userDB(ArrayList<users> user_) {
		Scanner in_data = new Scanner(System.in);
		users user = new users();
		System.out.print("회원님의 이름을 입력하세요:");
		user.set_name(in_data.next()); 
		System.out.print("이메일을 입력하세요:");//이메일
		user.set_email(in_data.next());
		System.out.print("주소를 입력하세요:");//이메일
		user.set_address(in_data.nextLine());
		in_data.nextLine(); //공백 입력 받기 enter 키 입력-> 연속된 method 입력시 발생하는 오류 잡기
		System.out.print("핸드폰 번호를 입력하세요:");//이메일
		user.set_phonenumber(in_data.nextLine());//핸드폰 번호
		System.out.print("만들고자 하는 회원의 아이디를 입력하세요:");
		user.set_userID(in_data.next());
		System.out.print("만들고자 하는 회원의 비밀번호를 입력하세요:");
		user.set_userPW(in_data.next());
		user_.add(user);
		System.out.println("회원이 생성되었습니다.");
	}
	/* ----------------책 대출과 관련된 함수 -------------------- */
	
	/*책 대출 함수 */
	public void borrowed_book(ArrayList<book> book_,ArrayList<users> user_,String current_name) { 
		Scanner book_name = new Scanner(System.in);
		String book_data;
		System.out.print("대출 하고자 하는 책의 이름을 입력하세요: ");
		book_data = book_name.nextLine(); //책 이름 입력
		for(int j=0;j<book_.size();j++) { // 빌리고자 하는 책 제목이 목록안에 있는지 확인
			if(book_data.equals(book_.get(j).title)&& book_.get(j).borrowed == true){ //대출이 가능한지 확인하다.
				user_.get(j).history = "대출 중..";  
				book_.get(j).borrowed = false;
				book_.get(j).borrowed_person = current_name;
				System.out.println("대출이 완료 되었습니다.");
			}
			else if(book_data.equals(book_.get(j).title) && book_.get(j).borrowed == false) { //대출 기록이 있다면
				System.out.println("현재 대출중입니다");
				break;
			}
		}
	} //책 대출 함수 
	
	//책 대출 정보 보기 
	public void borrowed_person_information(ArrayList<book> book_,ArrayList<users> user_,String current_name) {
		for(int j=0;j<book_.size();j++) { //빌린책이 있는지 목록에서 확인 
			if(current_name.equals(book_.get(j).borrowed_person)) { // 책에서 빌린 사람 이름과 동일하면 
				book_.get(j).show_borrowedinformation(); // 대출한 책에 대한 정보만 보여주기
			}
		}
	}	//책 대출 정보 함수
	
	//책 대출 정보 자세히 보기
	public void borrowed_book_detail(ArrayList<book> book_,ArrayList<users> user_,String current_name) {
		for(int j=0;j<book_.size();j++) { //빌린책이 있는지 목록에서 확인 
			if(current_name.equals(book_.get(j).borrowed_person)) { // 책에서 빌린 사람 이름과 동일하면 
				book_.get(j).show_bookinformation(); // 대출한 책에 대한 정보만 보여주기
			}
		}
	}
	
	/* ----------------사서 관리와 관련된 함수 -------------------- */
	public void set_librarianDB(ArrayList<librarian> librarian_) {
		Scanner in_data = new Scanner(System.in);
		librarian lib_data = new librarian();
		System.out.print("사서 이름을 입력하세요:");
		lib_data.set_name(in_data.next()); 
		System.out.print("이메일을 입력하세요:");//이메일
		lib_data.set_email(in_data.next());
		System.out.print("주소를 입력하세요:");//이메일
		lib_data.set_address(in_data.nextLine());
		in_data.nextLine(); //공백 입력 받기 enter 키 입력-> 연속된 method 입력시 발생하는 오류 잡기
		System.out.print("핸드폰 번호를 입력하세요:");//이메일
		lib_data.set_phonenumber(in_data.nextLine());//핸드폰 번호
		System.out.print("직책을 입력하세요:");
		lib_data.set_work_place(in_data.next());
		System.out.print("일하는 위치를 입력하세요:");
		lib_data.set_work_place(in_data.next());
		librarian_.add(lib_data);
		System.out.println("사서가 생성되었습니다.");
	} 
	/* ----------------책 관리와 관련된 함수 -------------------- */
	public void set_bookDB(ArrayList<book> book_) {
		Scanner in_data = new Scanner(System.in);
		book book_data = new book();
		System.out.print("ISBN을 입력하세요:");
		book_data.set_ISBN(in_data.nextLine());
		System.out.print("주제을 입력하세요:");
		book_data.set_subject(in_data.nextLine());
		System.out.print("언어을 입력하세요:");
		book_data.set_language(in_data.next());
		System.out.print("저자을 입력하세요:");
		book_data.set_publisher(in_data.next());
		System.out.print("발행일을 입력하세요:");
		book_data.set_publication_date(in_data.next());
		System.out.print("분류을 입력하세요:");
		book_data.set_tag(in_data.next());
		System.out.print("제목을 입력하세요:");
		book_data.set_title(in_data.next());
		System.out.print("페이지 수를 입력하세요:");
		book_data.set_pagenumber(in_data.next());
		System.out.print("책 형태를 입력하세요:");
		book_data.set_booktype(in_data.next());
		System.out.print("대출 가능 여부를 입력하세요:");
		book_data.set_borrowed_state(in_data.next());
		
		book_.add(book_data);
		System.out.println("책이 생성되었습니다.");
	}

	/*
		 * String ISBN, String subject,String language, 
		  * String publisher,String publication_date,
			String tag,String title,int page_number,
			String book_type,boolean borrowed,int due_date,int renew
			ISBN,주제,언어,저자, 발행일 ,분류,제목,페이지수 ,책 형태, 대출여부,대출기간,대출연장
		
		
	 * */
}
