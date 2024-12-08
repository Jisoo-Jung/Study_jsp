# 코리아 IT 아카데미 국비과정

## JSP ⭐
![servlet](https://github.com/user-attachments/assets/a154090a-06f3-44e5-af17-939634007a64)

--------------------------------------------------------------

**GET 방식과 POST 방식**
###### ※ 둘 중 어떤 것을 사용해야 할 지 모를 땐 그냥 다 써보자!
#### ▶ GET
```
쿼리스트링을 사용해서 데이터를 서버에 전송한다.
서블릿의 doGet()메소드가 실행된다.
데이터 길이에 제한이 있고, 주소창에 데이터가 보인다.
POST에 비해 속도가 빠르다.
단순 화면 이동 등에서 사용한다.
POST를 사용하는 상황이 아니라면 모두 GET을 사용한다.
```
#### ▶ POST
```
Header객체에 Key:Value 형태의 map구조로 담겨서 서버에 전송된다.
서블릿의 doPost()메소드가 실행된다.
데이터의 길이에 제한이 없고, 주소창에 데이터가 보이지 않는다.
GET에 비해 속도가 느리다.
길이가 긴 데이터 혹은 노출되면 안되는 데이터를 전송할 때 사용한다.
여러 데이터를 작성하거나, 로그인, 회원가입, 글작성 등을 완료할 때 주로 사용한다.
```
--------------------------------------------------------

**JSP 전체 흐름**
```
a.jsp -> web.xml -> Controller -> DAO -> DB -> b.jsp
```
**Controller(서블릿)**
```
doGet과 doPost에는 두 개의 매개변수가 있다.
1. HttpServletRequest
    화면으로부터 요청받은 모든 정보를 가지고 있다.
    사용자가 요청한 경로, ROOT 경로, 파라미터, forward방식의 응답 등
    forward 방식으로 응답할 때, request.setAttribute("key", value)를 사용한다.

2. HttpServletResponse
    응답하기 위한 모든 기능을 가지고 있다.
    직접 HTML 문서를 만들어서 응답, web.xml에 작성된 경로로 이동 등
    redirect 방식으로 응답할 때, response.sendRedirect("path?key=value&key=value...")를 사용한다.
    이 때, request객체가 초기화되면서 ROOT경로도 없어지기 때문에
    path 앞에 request.getContextPath()를 붙여서 ROOT 경로를 표현해준다.
```
**[jsp 방식]**
```
a.jsp --> b.jsp --> c.jsp

각 페이지마다 필요 시 자바 코드가 작성되며, DB와 연결하는 코드도 jsp파일 안에서
모두 작성된다. 분리되어 있지 않기 때문에 규모가 작은 프로젝트에 어울리는 방식이며,
코드가 확장될 수록 가독성이 떨어지고 분업과 유지보수가 좋지 않다.
```
--------------------------------------------------------
### MVC
##### [model1 방식]
```
a.jsp --> b.jsp --> c.jsp
        ↓
    DAO.java

b.jsp에서 dao를 호출함으로써 자바코드가 섞이게 된다. 선언은 JAVA 페이지에 구현이 되어 있기 때문에
jsp 내의 JAVA 코드 양이 줄어들지만 결국 사용은 jsp 페이지에서 하기 때문에
Controller(DAO 메소드를 사용하고 어디 페이지로 이동할 지)와 View가 섞이게 된다.
페이지가 확장될 수록 유지보수가 좋지 않다. 하지만 설계는 쉽다.
```
##### [model2 방식]
![model2](https://github.com/user-attachments/assets/6a4217b9-646f-4905-aed4-c4d4376b7519)

```
a.jsp   -->   web.xml   -->   Front-Controller.java   ------------>   c.jsp
                ↓
            Controller.java
                ↓
            DAO.java
                ↓
                DB

a.jsp에서 다음 페이지를 이동하기 전 필요한 비지니스 로직을 완벽하게 분리하여 관리한다.
사용자가 정의한 확장자(.me, .bo, ...)를 페이지 이동 주소(URL)에 작성하게 되면
web.xml에 가서 경로를 찾는다. web.xml에 파일 경로를 하나씩 모두 만들게 되면
코드가 길어지기 때문에 *.me와 같이 그룹화시킨 확장자로 요청을 하나의 경로로 보내주도록
설정해 놓는다.
이 경로를 알맞는 Front-Controller.java 경로로 설정해 놓는다.
Front-Controller에서는 들어온 요청에서 .me앞의 요청 명으로 어떤 로직을 수행할 지를
판단하도록 분기처리를 한다.
비지니스 로직을 Front-Controller에서 작업하게 되면 마찬가지로 코드가 길어지고
유지보수 및 재사용이 어렵기 때문에 요청별 Controller를 만들어서 req와 resp를 받을
메소드를 선언하여 구현한다. 따라서 Controller안에 선언된 메소드는 모든 Controller에
구현해야 하기 때문에 인터페이스를 선언하여 추상메소드 형태로 선언해 놓고
각 Controller에 지정하여 구현하도록 한다.
메소드 내부에서의 DB연산 작업들은 모두 DAO로 분리하여 사용한다.
내부 작업이 모두 완료되면 페이지를 이동할 것인지, 어떤 방식으로 할 것인지, 그리고 어디로
이동할 것인지를 결정해서 리턴해야 한다. 이에 관련된 필드를 클래스로 만들어 놓은 후
Controller안에 선언한 메소드의 리턴타입으로 지정하여 Front-Controller에 리턴해준다.
Front-Controller에서는 해당 Controller 메소드의 리턴 값에 담긴 결과에 맞게 처리한 후
View로 이동하게 된다.
```
--------------------------------------------------------
**DBCP(Database Connection Pool)**
```
사용자 요청이 있을 때마다 DB연결을 한다면 코드가 복잡해지며,
많은 요청이 있을 때 연결 속도가 저하될 수 있다.
따라서 미리 Connection을 만들어두고 필요 시, 저장된 공간에서
가져다 쓴 후 반환하는 것이 효율적이고 이 기법을 DBCP라고 한다.
```
**JNDI(Java Naming and Directory Interface)**
```
디렉터리 서비스에서 제공하는 데이터 및 객체를 발견하고 참고하기 위한 자바 API이며, 
외부에 있는 객체를 가져오기 위한 기술이다.
```
**MyBatis Framework** 

![mybatis](https://github.com/user-attachments/assets/21182cd5-0c19-43c2-95a9-13867108fe93)

```
소스코드 안에 SQL문을 작성하면 코드가 길어지고 섞여 있어서 유지보수 및 분없이 쉽지 않다. 
MyBatis는 기존 JDBC 방식과는 달리 SQL문을 XML파일에 작성함으로써 코드가 줄어들고,
SQL문 수정이 편해진다. 또한 DBCP를 사용하여 Connection을 한번에 여러 개 생성하기 때문에 JDBC만 
사용하는 것보다는 작업효율과 가독성이 좋아진다.
```

([back to top](#코리아-it-아카데미-국비과정))
