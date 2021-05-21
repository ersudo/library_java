package lib;
import java.util.*;
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
	 public static void main(String[] args) {
		 Scanner person = new Scanner(System.in);
		 Scanner press_button = new Scanner(System.in);
		 Scanner book_m = new Scanner(System.in);
		 library lib = library.getInstance();
		 
		 /*--------------user_db 생성 기본 정보 저장 --------------*/
		 ArrayList<users> user_db = new ArrayList<users>();
		 user_db.add(new users("김철수","chulsu@naver.com","신평동 70","541-54xx","kim","kim1234"));	
		 user_db.add(new users("손나은","sonny@naver.com","신평동 60","531-53xx","sonny","sonny123"));
		 user_db.add(new users("김정철","jungchurch@naver.com","신평동 50","501-50xx","church","church"));
		 user_db.add(new users("정남구","jungman@naver.com","옥계동 40","401-50xx","jung","jung99"));
		 user_db.add(new users("김남길","namgill@naver.com","옥계동 15","301-57xx","namgill","namgi"));
		 user_db.add(new users("이민수","minsu@naver.com","옥계동 20","317-47xx","minsu","minsu77"));
		 
		 /*------------user_db 에 대한 account 계정 생성 -------------*/
		 
		 /*
		 ArrayList<account> account_db = new ArrayList<account>();
		 for(int i=0; i<user_db.size();i++) {
			 account_db.add(new account());
		 } 
		 */
		 
		 /*-------------book_db 생성 기본 정보 저장 ---------------------*/
		 /*
		  * String ISBN, String subject,String language, 
		  * String publisher,String publication_date,
			String tag,String title,int page_number,
			String book_type,boolean borrowed,int due_date,int renew
			ISBN,주제,언어,저자, 발행일 ,분류,제목,페이지수 ,책 형태, 대출여부,대출기간,대출연장
		  * */ 
		 
		 ArrayList<book> book_db = new ArrayList<book>();
		 book_db.add(new book("978-89-34986-82-9","자연과학","한글","김영사","2021","컴퓨터 공학","데이터 과학자의 사고법","393p","인쇄물",true,"없음","대출 일로부터 7일 ","연락 후 연장"));
		 book_db.add(new book("979-11-85415-42-0","과학","한글(번역)","소어 헨슨","2021","기초과학","벌의 사생활","402p","인쇄물",true,"없음","대출 일로부터 7일 ","연락 후 연장"));
		 book_db.add(new book("978-89-86022-29-2","경제학","한글(번역)","스페파니 켈튼","2021","경제학","적자의 본질: 재정 적자의 이해하는 새로운 패러다임","415p","인쇄물",true,"없음","대출 일로부터 7일 ","연락 후 연장"));
		 book_db.add(new book("978-89-54446-87-7","일반문학","한글","원태연","2021","인문/사회","손끝으로 원을 그려봐 네가 그릴 수 있는 한 크게 그걸 뺀만큼 널 사랑해","161p","인쇄물",true,"없음","대출 일로부터 7일 ","연락 후 연장"));
		 book_db.add(new book("979-11-87289-73-9 ","일반문학","한글(번역)","와카스기 아키라","2019","인문/사회","시간 버리기 연습","247p","인쇄물",true,"없음","대출 일로부터 7일 ","연락 후 연장"));
		 
		 /*------------ 사서 db 생성 및 기본 정보 저장 ------------------*/
		 /*
		  * String name,String email,String address,String phone,
			String position,String work_place
			사서 이름,이메일,주소,핸드폰 번호,직책,일하는 부서 위치
		  * */
		 ArrayList<librarian> librarian_db = new ArrayList<librarian>();
		 librarian_db.add(new librarian("김은경","eunkung@naver.com","구미시 금오시장 5","500-40xx","일반 직원","2층"));
		 librarian_db.add(new librarian("정민서","mins@naver.com","구미시 공단 2동 15","300-40xx","일반 직원","2층"));
		 librarian_db.add(new librarian("고정식","gojung@naver.com","구미시 공단 1동 15","200-40xx","일반 직원","1층"));
		 librarian_db.add(new librarian("박지원","gigig@naver.com","구미시 옥계동 11","301-50xx","일반 직원","1층"));
		 librarian_db.add(new librarian("김시진","zin@naver.com","구미시 신평동 27","601-50xx","일반 직원","3층"));
		 librarian_db.add(new librarian("감사용","dragon@naver.com","구미시 신평동 36","614-50xx","일반 직원","3층"));
		 
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
            		 for(int i=0;i<user_db.size();i++) { 
            			 if( userID.equals(user_db.get(i).userID) &&
            					 userPW.equals(user_db.get(i).userPW )){
            				 String currnet_username = user_db.get(i).get_name();
            				 while(true) {
            					 	clearmenu();//화면지우기
            					 	
            		            	System.out.println("--------------------------------------------------------");
            		                System.out.println( currnet_username+"회원님 환영합니다");
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
            		                	for(int j=0;j<book_db.size();j++) {
            		                		if(search.equals(book_db.get(j).title)) {
            		                			book book_data = book_db.get(j);
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
            		                		for(int j=0;j<book_db.size();j++) {
            		                				book book_data = book_db.get(j);
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
            		                		lib.borrowed_book(book_db, user_db, currnet_username); //도서관 책 빌리기
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
            		                		lib.borrowed_person_information(book_db, user_db, currnet_username);
                		                		while(true) {
                		                			System.out.println("\n1.책 정보 자세히 보기");
                    		                		System.out.println("2. 뒤로가기 \n");
                		                			menu_choice =takeInput(0,3);
                   		                			if(menu_choice == 2)
                   		                					 break;
                		                			if(menu_choice == 1) {
                		                				lib.borrowed_book_detail(book_db, user_db, currnet_username);
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
                                	lib.set_userDB(user_db); //회원추가 library에서 담당
                                	System.out.println("\n\n 1. 뒤로가기 ");
   		                			menu_choice =takeInput(0,2);
   		                			if(menu_choice == 1)
   		                					 break;
         		                }
         		                if(menu_choice == 2) {//회원 삭제
	                            		 System.out.println("삭제하고자 하는 회원의 이름을 입력하세요: ");
	                            		 String delete_user = person.next();
	                            		 for(int i=0;i<user_db.size();i++) { 
	                            			 if(delete_user.equals(user_db.get(i).Person_name)){
	                            				 user_db.remove(i); //유저에 대한 정보 삭제
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
                                         	 for(int i=0;i<user_db.size();i++) { 
                                    			 if(user_find.equals(user_db.get(i).Person_name)){
                                    				 users user_data = user_db.get(i);
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
                                        	 for(int i=0;i<user_db.size();i++) { 
                                        		 System.out.println("\n\n");
                                        		 user_db.get(i).print_information();
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
          		                	 lib.set_librarianDB(librarian_db);
                                	 System.out.println("\n\n 1. 뒤로가기 ");
    		                			menu_choice =takeInput(0,2);
    		                			if(menu_choice == 1)
    		                					 break;
          		                }
          		                if(menu_choice == 2) { //사서 삭제
          		                	 System.out.println("삭제하고자 하는 사서의 이름을 입력하세요: ");
                            		 String delete_lib = person.next();
                            		 for(int i=0;i<librarian_db.size();i++) { 
                            			 if(delete_lib.equals(librarian_db.get(i).Person_name)){
                            				 System.out.println(delete_lib+"(의) 사서 정보를 삭제합니다");
                            				 librarian_db.remove(i); //사서에 대한 정보 삭제
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
		                                     	 for(int i=0;i<librarian_db.size();i++) { 
		                                			 if(lib_find.equals(librarian_db.get(i).Person_name)){
		                                				 librarian lib_data = librarian_db.get(i);
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
		                                    	 for(int i=0;i<librarian_db.size();i++) { 
		                                    		 System.out.println("\n\n");
		                                    		 librarian_db.get(i).print_information();
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
                                		 lib.set_bookDB(book_db);
                                    	 System.out.println("\n\n 1. 뒤로가기 ");
        		                			menu_choice =takeInput(0,2);
        		                			if(menu_choice == 1)
        		                					 break;
              		                }
                                 }//책 추가 if문 마지막 
                                 if(menu_choice == 2) { //책 삭제
                            		 System.out.println("삭제하고자 하는 책의 제목을 입력하세요: ");
                            		 String delete_book = book_m.next();
                            		 for(int i=0;i<book_db.size();i++) { 
                            			 if(delete_book.equals(book_db.get(i).title)){
                            				 book_db.remove(i); //책에 대한 정보 삭제
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
           		                	
           		                	for(int j=0;j<book_db.size();j++) {
		                				book book_data = book_db.get(j);
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
