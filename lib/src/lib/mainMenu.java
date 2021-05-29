package lib;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
public class mainMenu {
	 public static void clearmenu() { // 화면 지우기
		 for (int i =0;i<20;i++) {
			 System.out.println();
		 }
	 }	 
	
	 public static int takeInput(int min, int max) // 0 - max 까지
	    {    
	        String choice; //선택 입력 
	        Scanner input = new Scanner(System.in); //값 입력받기        
	        while(true)
	        {
	            System.out.print("메뉴를 선택해 주세요: ");

	            choice = input.next();
	             
	            if((!choice.matches(".*[a-zA-Z]+.*")) && (Integer.parseInt(choice) > min && Integer.parseInt(choice) < max))
	            {
	                return Integer.parseInt(choice); //입력값 되돌려 주기
	            } //숫자 외 입력 x, 범위내 숫자 입력시 
	            
	            else
	                System.out.println("\n잘못된 입력입니다.");
	        }
	    }
	 /* ------------------ user data 를 csv 파일로 변경 -----------------------------*/
	 public static void  writeCSVFileusers(String csvFileName, List<users> users_) {
		    ICsvBeanWriter beanWriter = null;
		    CellProcessor[] processors = new CellProcessor[] {
		            new NotNull(), // name
		            new NotNull(), // email
		            new NotNull(), // address
		            new NotNull(), // phone
		            new NotNull(),// id
		            new NotNull() // pw
		    };
		 
		    try {
		        beanWriter = new CsvBeanWriter(new FileWriter(csvFileName),
		                CsvPreference.STANDARD_PREFERENCE);
		        String[] header = {"name","email","address","phone","userID","userPW"};
		        beanWriter.writeHeader(header);
		 
		        for (users user : users_) {
		            beanWriter.write(user, header, processors);
		        }
		 
		    } catch (IOException ex) {
		        System.err.println("Error writing the CSV file: " + ex);
		    } finally {
		        if (beanWriter != null) {
		            try {
		                beanWriter.close();
		            } catch (IOException ex) {
		                System.err.println("Error closing the writer: " + ex);
		            }
		        }
		    }
	 }
	 /*--------------------user db 를 csv 로 성공적으로 변환----------------*/
	 
	 /*--------------------book db 를 csv 로 변환 ----------------*/

	 public static void  writeCSVFilebook(String csvFileName, List<book> book_) {
		    ICsvBeanWriter beanWriter = null;
		    CellProcessor[] processors = new CellProcessor[] {
		    		new NotNull(), // ISBN
		            new NotNull(), // subject
		            new NotNull(), // language
		            new NotNull(), // publisher
		            new NotNull(), // pbulication_date
		            new NotNull(),// tag
		            new NotNull(), // title
		            new NotNull(), //page_number
		            new NotNull(), //book_type
		            new Optional(new FmtBool("Y", "N")), //borrowed
		            new NotNull(), //borrowed_person
		            new NotNull(), //due_date
		            new NotNull() // renew
		    };
		 
		    try {
		        beanWriter = new CsvBeanWriter(new FileWriter(csvFileName),
		                CsvPreference.STANDARD_PREFERENCE);
		          String[] header = {"ISBN","subject","language","publisher","publicationdate","tag","title","pagenumber","booktype","borrow","person","duedate","renew"};
		        beanWriter.writeHeader(header);
		 
		        for (book books : book_) {
		            beanWriter.write(books, header, processors);
		        }
		 
		    } catch (IOException ex) {
		        System.err.println("Error writing the CSV file: " + ex);
		    } finally {
		        if (beanWriter != null) {
		            try {
		                beanWriter.close();
		            } catch (IOException ex) {
		                System.err.println("Error closing the writer: " + ex);
		            }
		        }
		    }
	 }
	 
	 /*------------------------book db를 csv 파일로 성공적으로 변환 -----------------------------*/
	 /*
	  * String name,String email,String address,String phone,
			String position,String workplace
	  * */
	 /*--------------------librarian db 를 csv 로 변환 ----------------*/
	 public static void  writeCSVFilelibrarian(String csvFileName, List<librarian> librarian_) {
		    ICsvBeanWriter beanWriter = null;
		    CellProcessor[] processors = new CellProcessor[] {
		    		new NotNull(), // name
		            new NotNull(), // email
		            new NotNull(), // address
		            new NotNull(), // phone
		            new NotNull(), // position
		            new NotNull() // workplace
		    };
		 
		    try {
		        beanWriter = new CsvBeanWriter(new FileWriter(csvFileName),
		                CsvPreference.STANDARD_PREFERENCE);
		          String[] header = {"name","email","address","phone","position","workplace"};
		        beanWriter.writeHeader(header);
		 
		        for (librarian librarians : librarian_) {
		            beanWriter.write(librarians, header, processors);
		        }
		 
		    } catch (IOException ex) {
		        System.err.println("Error writing the CSV file: " + ex);
		    } finally {
		        if (beanWriter != null) {
		            try {
		                beanWriter.close();
		            } catch (IOException ex) {
		                System.err.println("Error closing the writer: " + ex);
		            }
		        }
		    }
	 }
	 /*------------------------librarian db를 csv 파일로 성공적으로 변환 -----------------------------*/
	 
	 public static void main(String[] args) {
		 Scanner person = new Scanner(System.in);
		 Scanner press_button = new Scanner(System.in);
		 Scanner book_m = new Scanner(System.in);
		 library lib = library.getInstance();
		 /*--------------user_db 생성 기본 정보 저장 --------------*/
		
		 //ArrayList<users> user_db = new ArrayList<users>();
		 users user_db_1 = new users("kim_chul_su","chulsu@naver.com","Sinbi-ro 70","541-54xx","kim","kim1234");	
		 users user_db_2 = new users("son_naeun","sonny@naver.com","Sinbi-ro 60","531-53xx","sonny","sonny123");
		 users user_db_3 =new users("kim_jungchul","jungchurch@naver.com","Sinbi-ro 50","501-50xx","church","church");
		 users user_db_4 = new users("Jeong_namgu","jungman@naver.com","Gumijungang-ro 40","401-50xx","jung","jung99");
		 users user_db_5 = new users("kim_namgil","namgill@naver.com","Gumijungang-ro 15","301-57xx","namgill","namgi");
		 users user_db_6 = new users("lee_minsu","minsu@naver.com","Gumijungang-ro 20","317-47xx","minsu","minsu77");
		 
		 List<users> userdb_data =new ArrayList<>(Arrays.asList(user_db_1,user_db_2,user_db_3,user_db_4,user_db_5,user_db_6));
		 String csvFileNameuserDB = "user_db.csv";
		 writeCSVFileusers(csvFileNameuserDB,userdb_data);
		 /*------------user_db 에 대한 account 계정 생성 -------------*/
		 
		 /*-------------book_db 생성 기본 정보 저장 ---------------------*/
		 /*
		  * String ISBN, String subject,String language, 
		  * String publisher,String publication_date,
			String tag,String title,int page_number,
			String book_type,boolean borrowed,int due_date,int renew
			ISBN,주제,언어,저자, 발행일 ,분류,제목,페이지수 ,책 형태, 대출여부,대출기간,대출연장
		  * */ 
		 
		 // ArrayList<book> book_db = new ArrayList<book>();
		 book book_db_1 = new book("978-89-34986-82-9","natural science","korean","kimyoungcompnay","2021","computer science","The data scienctist's way of thinking","393p","printed matter",true,"None","Seven days from the date of the loan","Contact and extend");
		 book book_db_2 = new book("978-89-34986-82-9","natural science","korean","kimyoungcompnay","2021","computer science","The data scienctist's way of thinking","393p","printed matter",true,"None","Seven days from the date of the loan","Contact and extend");
		 book book_db_3 = new book("979-11-85415-42-0","science","korean(translate)","","2021","basic science","Buzz: the Nature and Necessity of Bees ","402p","printed matter",true,"None","Seven days from the date of the loan","Contact and extend");
		 book book_db_4 = new book("978-89-86022-29-2","economics","korean(translate)","Kelton Stephanie","2021","economics","The Deficit Myth","415p","printed matter",true,"None","Seven days from the date of the loan ","Contact and extend");
		 book book_db_5 = new book("978-89-54446-87-7","general literature","korean","one tae young","2021","Humanities/Sociality","Draw a circle with your fingertips, and I love you as much as you can without it.","161p","printed matter",true,"None","Seven days from the date of the loan","Contact and extend");
		 book book_db_6 = new book("979-11-87289-73-9 ","general literature","korean(translate)","Akira Wakasugi","2019","Humanities/Sociality","Discard Time Exercise","247p","printed matter",true,"None","Seven days from the date of the loan","Contact and extend");
		 
		 List<book> bookdb_data = new ArrayList<> (Arrays.asList(book_db_1,book_db_2,book_db_3,book_db_4,book_db_5,book_db_6));
		 String csvFileNamebookDB = "book_db.csv";
		 writeCSVFilebook(csvFileNamebookDB,bookdb_data);
		 
		 /*------------ 사서 db 생성 및 기본 정보 저장 ------------------*/
		 /*
		  * String name,String email,String address,String phone,
			String position,String work_place
			사서 이름,이메일,주소,핸드폰 번호,직책,일하는 부서 위치
		  * */
		 //ArrayList<librarian> librarian_db = new ArrayList<librarian>();
		 librarian librarian_db_1 = new librarian("kim_eunkung","eunkung@naver.com","gumi_maket 5","500-40xx","staff","second floor"); 
		 librarian librarian_db_2 = new librarian("jung_mins","mins@naver.com","gumi_loadocean 15","300-40xx","staff","second floor");
		 librarian librarian_db_3 = new librarian("go_changseek","gojung@naver.com","construct field road 15","200-40xx","staff","first floor");
		 librarian librarian_db_4 = new librarian("park_jiwon","gigi@naver.com","oak building street 11","301-50xx","staff","first floor");
		 librarian librarian_db_5 = new librarian("kim_zin","zin@naver.com","sin-pung 5street 27","601-50xx","staff","third floor");
		 librarian librarian_db_6 = new librarian("thanks_dragon","dragon@naver.com","wallstreetbet 36","614-50xx","staff","third floor");
		 List<librarian> librarain_data = new ArrayList<>(Arrays.asList(librarian_db_1,librarian_db_2,librarian_db_3,librarian_db_4,librarian_db_5,librarian_db_6));
		 String csvFileNameLibrarianDB = "librarian_db.csv";
		 writeCSVFilelibrarian(csvFileNameLibrarianDB,librarain_data);
		 boolean stop = false;
		 while(!stop) { // true 가 아닐때
			clearmenu();//화면지우기
	
			System.out.println("--------------------------------------------------------");
            System.out.println("\t "+lib.get_library_name()+"도서관에 오신것을 환영합니다.");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. 회원 로그인 ");
            System.out.println("2. 관리자(사서) 로그인 ");
            System.out.println("3. 나가기 ");
            System.out.println("도서관 연락처 /각종 민원 접수 연락처: "+lib.get_library_call_number());
            System.out.println("도서관 주소: "+ lib.get_library_address());
            System.out.println("영업일: "+lib.get_workday() +"/휴뮤일: "+lib.get_holiday());
            System.out.println("--------------------------------------------------------");
            int menu_choice = 0 ;// 메뉴 선택하기
            menu_choice = takeInput(0,4); //범위 내에서 입력받기
            if(menu_choice == 3) //나가기 
            	break;
            if(menu_choice == 1) { //회원 로그인이면
            	clearmenu();//화면지우기
            	System.out.println("\n---회원 아이디와 비밀번호를 입력하세요---- ");
            	System.out.print("로그인 아이디 : ");
            	String userID = person.next();
            	System.out.print("로그인 비밀번호 : ");
            	String userPW = person.next();
            		 for(int i=0;i<userdb_data.size();i++) { 
            			 if( userID.equals(userdb_data.get(i).userID) &&
            					 userPW.equals(userdb_data.get(i).userPW )){
            				 String currnet_username = userdb_data.get(i).getName();
            				 while(true) {
            					 	clearmenu();//화면지우기
            					 	
            		            	System.out.println("--------------------------------------------------------");
            		                System.out.println( currnet_username+" 회원님 환영합니다");
            		                System.out.println("--------------------------------------------------------");
            		                System.out.println("1. 책 검색 ");
            		                System.out.println("2. 책 전체 보기 ");
            		                System.out.println("3. 책 대출 하기 ");
            		                System.out.println("4. 대출 기록 검색 ");
            		                System.out.println("5. 뒤로가기 ");
            		                menu_choice = takeInput(0,6); //범위 내에서 입력받기
            		                if(menu_choice == 5)// 뒤로가기
            		                	break;
            		                if(menu_choice == 1) { // 책 검색
            		                	Scanner scan_list = new Scanner(System.in);//책 제목으로 검색
            		                	System.out.print("검색할 제목을 입력하세요 : ");
            		                	String search = scan_list.nextLine();
            		                	//scan_list.close();
            		                	for(int j=0;j<bookdb_data.size();j++) {
            		                		if(search.equals(bookdb_data.get(j).title)) {
            		                			book book_data = bookdb_data.get(j);
	            		                				while(true) {
	            		                				System.out.println("\n\n");
	            		                				book_data.show_bookinformation();
	            		                				System.out.println("\n 1. 뒤로가기 ");
	            		                				menu_choice =takeInput(0,2);
	            		                				if(menu_choice == 1)
	            		                					 break;
	            		                				}
	            		                		   }
            		                				
            		                	       }
            		                   }
            		                	if(menu_choice == 2) { // 책 전체 목록 보기
            		                		for(int j=0;j<bookdb_data.size();j++) {
            		                				book book_data = bookdb_data.get(j);
            		                				System.out.println("\n-------------------------");
	            		                			book_data.show_bookinformation();
            		                		}
            		                		while(true) {
            		                		System.out.println("\n 1. 뒤로가기 ");
    		                				menu_choice =takeInput(0,2);
    		                				if(menu_choice ==1)
    		                					 break;
            		                		}
            		                	}
            		                	if(menu_choice == 3) { // 책 대출하기
            		                		lib.borrowed_book(bookdb_data, userdb_data, currnet_username); //도서관 책 빌리기
            		                		while(true) {
            		                		System.out.println("\n\n 1. 뒤로가기 ");
           		                			menu_choice =takeInput(0,2);
           		                			if(menu_choice == 1)
           		                					 break;
            		                		}
            		                	}
            		                	if(menu_choice == 4) { //대출 기록 보기
            		                		//현재 계정정보는 가지고 잇으니 계정 정보를 바탕으로 기록 ?
            		                		System.out.println("-----회원님의 대출 목록 ------");
            		                		lib.borrowed_person_information(bookdb_data, userdb_data, currnet_username);
                		                		while(true) {
                		                			System.out.println("\n1.책 정보 자세히 보기");
                    		                		System.out.println("2. 뒤로가기 \n");
                		                			menu_choice =takeInput(0,3);
                   		                			if(menu_choice == 2)
                   		                					 break;
                		                			if(menu_choice == 1) {
                		                				lib.borrowed_book_detail(bookdb_data, userdb_data, currnet_username);
                            		                		System.out.println("\n 1. 뒤로가기 ");
                           		                			menu_choice =takeInput(0,2);
                           		                			if(menu_choice == 1)
                           		                					 break;
                		                			}
                		                		}
               		                	
            		                	}
            		                } //전체 while문 ->회원 로그인 
            		            } //전체 if문 
            			 }
            } //회원 로그인 if 문 
            if(menu_choice == 2) { //관리자 로그인이라면
            	 clearmenu();//화면지우기
            	 System.out.println("\n---관리자 아이디와 비밀번호를 입력하세요---- ");
            	 System.out.print("관리자 아이디 : ");
            	 String adminId = person.next();
            	 System.out.print("관리자 비밀번호 : ");
            	 String adminPassword = person.next();
            	 if(adminId.equals("admin") && adminPassword.equals("admin1234")) {  //만약 관리자 아이디와 비밀번호가 일치하면
            		 while(true) {
            			 clearmenu();//화면지우기
            			 System.out.println("--------------------------------------------------------");
            			 System.out.println("\t 관리자님 어서오세요.");
                         System.out.println("--------------------------------------------------------");
                         System.out.println("1.회원 관리");
                         System.out.println("2.사서 관리");
                         System.out.println("3.책  관리");
                         System.out.println("4.뒤로가기");
                         System.out.println("--------------------------------------------------------");
                         menu_choice = takeInput(0,5); //범위내 메뉴 선택
                         
                         if(menu_choice == 4) //로그아웃시 나가기 
                        	 break;
                         /*-------------------- 회원관리 -----------------------------*/
                         if(menu_choice == 1) { //회원 관리  
                        	 while(true) {
                        		 clearmenu();//화면지우기
                        		 System.out.println("--------------------------------------------------------");
                    			 System.out.println("\t 관리자 모드 -- 회원 관리");
                                 System.out.println("--------------------------------------------------------");
                                 System.out.println("1.회원 추가");
                                 System.out.println("2.회원 삭제");
                                 System.out.println("3.회원 정보 보기"); //1. 특정 회원 찾기 2.전체 회원 목록 보기  
                                 System.out.println("4.뒤로 가기");
                                 System.out.println("--------------------------------------------------------");
                                 menu_choice = takeInput(0,5);
                                 if(menu_choice == 4) //뒤로가기
                                	 break;
                                 if(menu_choice == 1) { // 회원추가
                                	lib.set_userDB(userdb_data); //회원추가 library에서 담당
                                	System.out.println("\n\n 1. 뒤로가기 ");
   		                			menu_choice =takeInput(0,2);
   		                			if(menu_choice == 1)
   		                					 break;
         		                }
         		                if(menu_choice == 2) {//회원 삭제
	                            		 System.out.println("삭제하고자 하는 회원의 이름을 입력하세요: ");
	                            		 String delete_user = person.next();
	                            		 for(int i=0;i<userdb_data.size();i++) { 
	                            			 if(delete_user.equals(userdb_data.get(i).name)){
	                            				 userdb_data.removeIf(e->e.equals(delete_user)); //유저에 대한 정보 삭제
	                            				 System.out.println(delete_user+"(의) 유저 정보를 삭제합니다");
	                            			 }
	                            		 } //조건문 -> 회원 정보 찾기       	 
	                            		 while(true) {
	        		                			System.out.println("\n\n 1. 뒤로가기 ");
	        		                			menu_choice =takeInput(0,2);
	        		                			if(menu_choice == 1)
	        		                					 break;
	                             		 }
	       		                		
         		                }//회원 삭제 if문 
         		                if(menu_choice == 3) {
         		                	 while(true) {
                                		 clearmenu();//화면지우기
                                		 System.out.println("--------------------------------------------------------");
                            			 System.out.println("\t 관리자 모드 -- 회원 관리");
                                         System.out.println("--------------------------------------------------------");
                                         System.out.println("1.회원 찾기");
                                         System.out.println("2.전체 회원보기");
                                         System.out.println("3.뒤로 가기");
                                         System.out.println("--------------------------------------------------------");
                                         menu_choice = takeInput(0,4);
                                         if(menu_choice == 3) //뒤로가기
                                        	 break;
                                         if(menu_choice == 1) { //회원 찾기
                                        	System.out.println("\n---찾는 회원 이름을 입력하세요---- ");
                                         	System.out.print("회원 이름 : ");
                                         	String user_find = person.next();
                                         	 for(int i=0;i<userdb_data.size();i++) { 
                                    			 if(user_find.equals(userdb_data.get(i).name)){
                                    				 users user_data = userdb_data.get(i);
                                    				 user_data.print_information();
                                    			 }
                                         	 }
                                         	 
                                         	 while(true) {
 	            		                		System.out.println("\n");
 	            		                		System.out.println("\n 1. 뒤로가기 ");
 	            		                		menu_choice =takeInput(0,2);
 	            		                		if(menu_choice == 1)
 	            		                			 break;
 	            		                		}
                                            }
                                         // 회원찾기 if 문
                                         if(menu_choice == 2) { //전체 회원보기
                                        	 for(int i=0;i<userdb_data.size();i++) { 
                                        		 System.out.println("\n\n");
                                        		 userdb_data.get(i).print_information();
                                        	 }
                                        	 while(true) {
                 		                		System.out.println("\n 1. 뒤로가기 ");
         		                				menu_choice =takeInput(0,2);
         		                				if(menu_choice == 1)
         		                					 break;
                 		                		}
                                         }//전체 회원보기 if문
                                     
         		                }
         		                
                        	 } // 관리자 모드 회원관리  -- if문 
                        	 }
                         }
                         /*-------------------- 회원관리 함수 끝  -----------------------------*/
                         
                         /*-------------------- 사서 관리 -----------------------------*/	 
                         if(menu_choice == 2) { //사서 관리 
                        	 while(true) {
                        		 clearmenu();//화면지우기
                        		 System.out.println("--------------------------------------------------------");
                    			 System.out.println("\t 관리자 모드 -- 사서 관리");
                                 System.out.println("--------------------------------------------------------");
                                 System.out.println("1.사서 추가");
                                 System.out.println("2.사서 삭제");
                                 System.out.println("3.사서 정보 보기"); //1.특정 사서 정보 보기 2. 전체 사서 목록 보기
                                 System.out.println("4.뒤로 가기");
                                 System.out.println("--------------------------------------------------------");
                                 menu_choice = takeInput(0,5);
                                 if(menu_choice == 4) //뒤로가기
                                	 break;
                                 if(menu_choice == 1) {//사서 추가
          		                	 lib.set_librarianDB(librarain_data);
                                	 System.out.println("\n\n 1. 뒤로가기 ");
    		                			menu_choice =takeInput(0,2);
    		                			if(menu_choice == 1)
    		                					 break;
          		                }
          		                if(menu_choice == 2) { //사서 삭제
          		                	 System.out.println("삭제하고자 하는 사서의 이름을 입력하세요: ");
                            		 String delete_lib = person.next();
                            		 for(int i=0;i<librarain_data.size();i++) { 
                            			 if(delete_lib.equals(librarain_data.get(i).name)){
                            				 librarain_data.removeIf(e->e.equals(delete_lib)); //사서에 대한 정보 삭제
                            				 System.out.println(delete_lib+"(의) 사서 정보를 삭제합니다");
                            			 } //조건문 -> 사서 정보 찾기
                            		 }
                            		 while(true) {
       		                			System.out.println("\n\n 1. 뒤로가기 ");
       		                			menu_choice =takeInput(0,2);
       		                			if(menu_choice == 1)
       		                					 break;
                            		 }
          		                }
          		                if(menu_choice == 3) {
          		                	//사서 정보  보기 
		          		             	 while(true) {
		                            		 clearmenu();//화면지우기
		                            		 System.out.println("--------------------------------------------------------");
		                        			 System.out.println("\t 관리자 모드 -- 사서 관리");
		                                     System.out.println("--------------------------------------------------------");
		                                     System.out.println("1.사서 찾기");
		                                     System.out.println("2.전체 사서 목록 보기");
		                                     System.out.println("3.뒤로 가기");
		                                     System.out.println("--------------------------------------------------------");
		                                     menu_choice = takeInput(0,4);
		                                     if(menu_choice == 3) //뒤로가기
		                                    	 break;
		                                     if(menu_choice == 1) { //사서 찾기
		                                    	System.out.println("\n---찾는 사서 이름을 입력하세요---- ");
		                                     	System.out.print("사서 이름 : ");
		                                     	String lib_find = person.next();
		                                     	 for(int i=0;i<librarain_data.size();i++) { 
		                                			 if(lib_find.equals(librarain_data.get(i).name)){
		                                				 librarian lib_data = librarain_data.get(i);
		                                				 while(true) {
			            		                				System.out.println("\n\n");
			            		                				lib_data.print_information();
			            		                				System.out.println("\n 1. 뒤로가기 ");
			            		                				menu_choice =takeInput(0,2);
			            		                				if(menu_choice == 1)
			            		                					 break;
			            		                				}
		                                			 }
		                                        }
		                                     }// 사서 찾기 if 문
		                                     if(menu_choice == 2) { //전체 사서 목록 보기
		                                    	 for(int i=0;i<librarain_data.size();i++) { 
		                                    		 System.out.println("\n\n");
		                                    		 librarain_data.get(i).print_information();
		                                    	 }
		                                    	 while(true) {
		             		                		System.out.println("\n 1. 뒤로가기 ");
		     		                				menu_choice =takeInput(0,2);
		     		                				if(menu_choice == 1)
		     		                					 break;
		             		                		}
		                                     }
		     		                  }
          		                }//전체 사서보기 if문 
                        	 }
                         }
                         /*-------------------- 사서 관리 끝 -----------------------------*/
                         
                         /*-------------------- 책 관리  -----------------------------*/
                         if(menu_choice == 3) { //책 관리
                        	 while(true) {
                        		 clearmenu();//화면지우기
                        		 System.out.println("--------------------------------------------------------");
                    			 System.out.println("\t 관리자 모드 -- 책 관리");
                                 System.out.println("--------------------------------------------------------");
                                 System.out.println("1.책 추가");
                                 System.out.println("2.책 삭제");
                                 System.out.println("3.책 정보 보기"); // 1.특정 책 정보 보기 2. 전체 책 목록 보기 
                                 System.out.println("4.뒤로 가기");
                                 System.out.println("--------------------------------------------------------");
                                 menu_choice = takeInput(0,5);
                                 if(menu_choice == 4) //뒤로가기
                                	 break;
                                 if(menu_choice == 1) {//책 추가
                                	 if(menu_choice == 1) {
                                		 lib.set_bookDB(bookdb_data);
                                    	 System.out.println("\n\n 1. 뒤로가기 ");
        		                			menu_choice =takeInput(0,2);
        		                			if(menu_choice == 1)
        		                					 break;
              		                }
                                 }//책 추가 if문 마지막 
                                 if(menu_choice == 2) { //책 삭제
                            		 System.out.println("삭제하고자 하는 책의 제목을 입력하세요: ");
                            		 String delete_book = book_m.next();
                            		 for(int i=0;i<bookdb_data.size();i++) { 
                            			 if(delete_book.equals(bookdb_data.get(i).title)){
                            				 //bookdb_data.remove(i); //책에 대한 정보 삭제
                            				 bookdb_data.removeIf(e ->e.equals(delete_book));
                            				 System.out.println(delete_book+"(의) 책 정보를 삭제합니다");
                            			 }
                            		 } 
                            		 while(true) {
        		                			System.out.println("\n\n 1. 뒤로가기 ");
        		                			menu_choice =takeInput(0,2);
        		                			if(menu_choice == 1)
        		                					 break;
                             		 }
           		                }//책 삭제 if문 마지막
                                 
           		                if(menu_choice == 3) {//책 정보 보기 
           		                	
           		                	for(int j=0;j<bookdb_data.size();j++) {
		                				book book_data = bookdb_data.get(j);
		                				System.out.println("\n-------------------------");
    		                			book_data.show_bookinformation();
           		                	}
           		                	while(true) {
           		                		System.out.println("\n 1. 뒤로가기 ");
           		                		menu_choice =takeInput(0,2);
           		                		if(menu_choice ==1)
           		                			break;
           		                	}
           		                } //책 정보 보기  if 문 마지막
                        	 }
                         } 
                         /*-------------------- 책 관리  -----------------------------*/
                        } //관리자 로그인 
                   
                        	 
                        
                         
            	 }//관리자 일치 하면 
            } //관리자 로그인if 문 
		 } //전체 loop 문 
	 } // main 함수 
} //전체 괄호


/**
 * @author ersudo
 * @description  - not used function
	public String toCsvRow() {
		return Stream.of(Person_name, Person_email,Person_address,Person_phonenumber,userID,userPW,history)
				.map(value ->value.replaceAll("\"","\"\""))
				.map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
	            .collect(Collectors.joining(","));
	}
	public String getCSV() {
		String recordasCSV  = usersDB.stream()
				.map(users::toCsvRow)
				.collect(Collectors.joining(System.getProperty("line.separator")));
		return recordasCSV;
	}
	public ArrayList<users> getuserDB(){
		return usersDB;
	}
 *	
 **/