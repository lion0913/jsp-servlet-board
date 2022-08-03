
# 서블릿 & JSP를 이용한 게시판 만들기

> **멋쟁이사자처럼 백엔드스쿨 🦁** <br/><br/>
> **개발기간: 2022.07.19 ~**

<br/>

## 게시판 소개

CRUD 기능 구현에 충실한 게시판입니다. 

데이터베이스 연동을 통해 값을 받아오는 구조라서 article, board 테이블을 생성하셔야 합니다 !

또한 properties 파일을 통해 db 연결시의 환경변수들을 관리해서 **application.properties** 파일을 생성해 아래의 설정을 채워주셔야 합니다.

```properties
#application.properties 파일 설정 

db.driverName = com.mysql.cj.jdbc.Driver
db.url = *
db.user = *
db.password = *  
db.host =  *
db.dbName = * 
db.port = *
```

```mysql
# article table DDL 
create table article
(
    id           bigint auto_increment
        primary key,
    createdDate  datetime     not null,
    modifiedDate datetime     not null,
    title        varchar(100) not null,
    body         text         not null,
    boardId      bigint       null,
    constraint article_id_uindex
        unique (id)
);
```

```mysql
# board table DDL
create table board
(
    id         bigint auto_increment
        primary key,
    createDate datetime    null,
    modifyDate datetime    null,
    name       varchar(10) null,
    code       varchar(10) null,
    constraint board_id_uindex
        unique (id)
);

```

<br/>


## 게시판 주요 기능

> 게시판 메인 화면 (/usr/article/list/free)
 
<img width="1243" alt="image" src="https://user-images.githubusercontent.com/63444424/182611775-27ed06a1-14da-4ca5-8412-549f4f090a5f.png">

> 게시판 등록 화면 (/usr/article/write/free/{id})

<img width="699" alt="image" src="https://user-images.githubusercontent.com/63444424/182613420-c24ab287-0d28-4f6b-a4e1-c3c4c9ee5698.png">

> 게시판 상세 화면 (/usr/article/detail/free/{id})

<img width="500" alt="image" src="https://user-images.githubusercontent.com/63444424/182612912-a2a8253e-0ea7-4058-981f-06e270096b1e.png">

> 게시판 수정 화면 (/usr/article/modify/free/{id})
<br/>

게시물 수정 메인화면

<img width="354" alt="image" src="https://user-images.githubusercontent.com/63444424/182613041-3372570e-1428-4689-ad37-9902b172c88e.png">

수정 목록 작성

<img width="385" alt="image" src="https://user-images.githubusercontent.com/63444424/182613137-8aa03343-a708-4849-88e8-19b32828449f.png">

수정 완료 alert

<img width="636" alt="image" src="https://user-images.githubusercontent.com/63444424/182613208-38dcc238-a352-4883-be6b-df63456bc60a.png">

바뀐 내용 확인

<img width="1287" alt="image" src="https://user-images.githubusercontent.com/63444424/182613259-6e0bcca6-cf15-4b5e-bbfb-7466b0bf73b7.png">

> 게시판 삭제 화면 (/usr/article/delete/free/{id})

<img width="1285" alt="image" src="https://user-images.githubusercontent.com/63444424/182613314-9431e816-7e7e-439d-b7b1-6d63eb107719.png">

<br/>
