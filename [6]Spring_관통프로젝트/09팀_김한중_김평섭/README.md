# SSAFIT 관통프로젝트 - Spring

총 3개의 테이블로 구성
* 영상(videos), 리뷰(reviews), 회원(users)

### 테이블 별 Column
* 영상: videoID (PK), title, channelName, viewCnt, partInfo
* 회원: userID (PK), password, name, email, age
* 리뷰: reviewID (PK), videoID(FK, ref videos(videoID)), userID (FK, ref users(userID)), title, content, regDate, reviewCnt

영상 테이블 및 리뷰 테이블과 연동하여 CRUD 기능 구현
회원가입, 로그인, 로그인 기능 구현

## 소감
김평섭 : 오늘은 배운 기술스택중 가장 어려운 spring 관통 프로젝트를 진행했습니다. 처음에는 막막했지만 수업이외에 따로 공부를 해온 덕에 하나씩 해결해 나갈 수 있었습니다. ctrl+shift+L을 누르면 단축키 목록을 알 수 있다는 꿀팁도 페어님께 전수받고, 이제까지 관통 프로젝트중에 가장 열심히 한 날이라서 뿌듯합니다. 취업 후에도 많이 쓸 것 같은 기술스택이기 때문에 앞으로도 spring 실력을 갈고닦도록 하겠습니다.

김한중 : Spring Framework를 이용한 관통 프로젝트를 진행하면서 많은 어려움이 있었습니다. xml 설정 파일에 오타가 난 경우를 발견하지 못해서 곤란했는데, 페어님과 같이 코드를 정독하면서 무사히 잘못된 코드를 고칠 수 있었습니다. 특히 Swagger UI를 이용하여 DB와 연결된 것을 확인할 수 있었던 점이 좋았습니다. 프론트엔드와 같이 연동한 프로젝트를 완성할 수 있도록 복습을 해서 좀 더 완성도 있는 결과물을 만들 수 있게 되었으면 좋겠습니다.
