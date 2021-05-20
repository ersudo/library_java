#next project summary.

# start
description

*fist It will be written in Korean. and will add english translation.

1. 웹 페이지 탐색 도중에 기사나, 논문 등을 읽다가 단어의 뜻을 모를 때,마우스를 해당 단어위에 올려두게 되면 (구체적으로는 마우스를 우클릭) 단어뜻을 찾고 보여준다.
2. 찾은 단어를 기록한다. (기록의 기본 형태는 날짜 ->시간별로 / 시간 표시 형태는 hh:mm (pm/am -location) 으로 표시하여 구분한다.  
   - 보관일은 최대 2주 (7~14일 이내로 보관)
3. 기록되어진 단어들은 날짜별로 정리한다 (기본) 또는 선택옵션으로 a-z순서로 나열한다 ( 기본 구현 / 선택 )

*기본 구현 형태는 위와 같다.
 아래의 내용은 서버를 이용한 구현이므로 서버 구축이후 구현될 예정이다
 
-----------------------------------------------------------------------------------------------------------

4. 계정을 생성하고 로그인시 (온라인으로 서비스이용 -기본은 로컬로그인이다. ) ->저장한 데이터를 (웹 데이터) 서버에 저장 
5. 저장된 데이터를 분류 -> 사용자가 설정한 정보를 바탕으로 분류한다( 사용자가 계정을 생성하면서 선택한 1)신분(직업) 2)관신분야 3) 연령 을 바탕으로 한다.)
  - 구체적인 구현 목표는 ex_) 특정 의학분야의 검색을 하고자 한다고 가정할떄 ) -> 1) 심장과 관련된 정보가 궁금하며 2)이를 검색한 사람은 의학분야에 관심이 있는 사람 (직업)
  - 해당 정보를 바탕으로 심장과 관련되어 검색한 단어의 빈도수를 바탕으로 상위 단어들을 나열 한다. 
6. 사용자가 검색 하고싶은 분야를 선택 ->용어 찾기 /보여주기 


* 서버를 만들고 나서 구현될 형태다.
 - 구체적인 사항들에 대해 추가할 예정
-----------------------------------------------------------------------------------------------------------

구체적인 기능들은? 

- 마우스를 올리면 -> 의 작동은 chrome -extension에 설치후 on/off로 설정 (기능을 사용할지 말지에 대한 사용자 선택)
- 1~2초 정도 검색 실행 (검색 실행은 네이버 사전이나 다음 사전등을 연동한다 ->기본 번역은 영어 ->한글 /그외 단어들은 추가 구현 ) 
  검색 완료후 검색되어진 단어의 뜻과 내용을 정렬하고 나열하여 사용자에게 표시 -o 옵션 (option) 사용자에게 보여지는 창의 불투명도 조절 기능을 추가한다) 
  
  
-----------------------------------------------------------------------------------------------------------

1.if you don't know the meaning of a word while reading an article or a paper while browsing a web page, 
  - you can find and show the meaning of the word (specifically, right-  click) when you put your mouse on the word.
2.Record the words found. (Note that the default format of the record is marked by date -> time / time display by hh:mm (pm/am -location).
  - Storage days up to 2 weeks (stored within 7 to 14 days)
3. The recorded words are organized by date (default) or listed in a-z order as an optional option (default implementation / selection).

*Basic implementation forms are as above. The following contents are implemented using a server, so it will be implemented after the server is deployed.

4. Create an account and log in (Use Service Online - Default is Local Login). ) -> Save saved data to (web data) server
5. Categorize stored data -> Categorize based on user-set information (based on age 1) identification (occupation) 2) interest field 3) selected by user when creating an account)
- Specific goals of implementation are ex_) Suppose you want to search a particular medical field.) -> 1) I am curious about the information related to the heart and 2) The person who searched for it is interested in the medical field (job)
- Based on the information, list the upper words based on the frequency of the words searched in relation to the heart.
6. Select the area you want to search ->Find/Show Terms


* This form will be implemented after the server is created.
- To be added on specific details
- 
-----------------------------------------------------------------------------------------------------------
Specific functions?

- When the mouse is raised, -> is installed in Chrome -extension and set to on/off (select the user whether to use the function or not)
- Search for 1~2 seconds (Search execution links Naver dictionary or the following dictionary -> Basic translation is English -> Hangul/Other words are implemented additionally)
Align and list the meaning and content of the words searched after completion of the search -o option (add the opacity adjustment of the window shown to the user)
