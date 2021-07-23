# 카카오페이증권 사전과제 - 지점 마케팅 API 개발
## 목차
- [개발 환경](#개발-환경)
- [빌드 및 실행하기](#빌드-및-실행하기)
- [기능 요구사항](#기능-요구사항)
- [개발 제약사항](#개발-제약사항)
- [해결방법](#해결방법)

---

## 개발 환경
- 기본 환경
    - IDE: IntelliJ IDEA Ultimate
    - OS: Window 10
- Server
    - Java8
    - Spring Boot
    - JPA
    - H2
    - Gradle
    - Junit5


## 빌드 및 실행하기
### 터미널 환경
- Java 는 설치되어 있다고 가정한다.

```
$ java -version
```
```
$ ./gradlew clean build
```

- 접속 URI: `http://localhost:8080`

## 기능 요구사항
### 필수사항
- 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발
- 2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발
- 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발
- 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발
    
- 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발
    - 취소여부가 'Y' 거래는 취소된 거래
    - 합계 금액은 거래금액에서 수수료를 차감한 금액
    - 이하 출력 예시
```
[
    {   “year”: 2018,
        “name”: ”계좌명”,
        “acctNo”: ”계좌번호”,
        “acctNo”:0000}
    {   “year”: 2019,
        “name”: ”계좌명”,
        “acctNo”: ”계좌번호”,
        “acctNo”:0000}
]
```

- 2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발
    - 예를들어, 2005년 ~ 2017년 중에 2010년 국민은행의 전체 지원금액(1월 ~ 12월 지원 합계)이 가장 높았다면 `{ “year": “2010” , "bank": “국민은행”}`을 결과로 출력한다.
    - 이하 출력 예시
```
{
    {   “year”: 2018,
        “name”: ”계좌명”,
        “acctNo”: ”계좌번호”}
        ...
    {   “year”: 2019,
        “name”: ”계좌명”,
        “acctNo”: ”계좌번호”,}
        ...
}
```

- 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발
    - 예를들어, 2005년 ~ 2016년 외환은행의 평균 지원금액(매년 12달의 지원금액 평균값)을 계산하여 가장 작은 값과 큰 값을 출력한다. 소수점 이하는 반올림해서 계산한다.
    - 이하 출력 예시

```
[
    {   “year”: 2018,
        “dataList”:[
           {
           ”brName”: ”관리점명”,
           “brCode”: ”관리점코드”,
           “sumAmt”: 0000}
           ...
        ]
    }
    {   “year”: 2019,
        “dataList”:[
           {
           ”brName”: ”관리점명”,
           “brCode”: ”관리점코드”,
           “sumAmt”: 0000}
           ...
        ]
    }
]
```
- 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발
    - 분당점과 판교점을 통폐합하여 판교점으로 관리점 이관
    - 취소여부가 'Y'인 거래는 취소된 거래
    - 이하 출력 예시

## 개발 제약사항
### 필수사항
- API 기능명세에서 기술된 API 를 모두 개발하세요.
- Spring boot 기반의 프레임웍을 사용하세요.
- 단위 테스트 (Unit Test) 코드를 개발하여 각 기능을 검증한다.(필수사항)
- 모든 입/출력은 JSON 형태로 주고 받습니다.
- 단, 각 API 에 HTTP Method 들(GET|POST|PUT|DEL)은 자유롭게 선택하세요.
- README.md 파일을 추가하여, 개발 프레임웍크, 문제해결 방법, 빌드 및 실행 방법을 기술하세요.


## 문제해결 방법
### 1. 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발
- Request

```
http://localhost:8080/kakaoStock/highTotalCustomer
```

```
GET /kakaoStock/highTotalCustomer HTTP/1.1
```

- Response

```json
[
  {
    "name": "테드",
    "year": 2018,
    "sumAmt": 28992000,
    "acctNo": "11111114"
  },
  {
    "name": "에이스",
    "year": 2019,
    "sumAmt": 40998400,
    "acctNo": "11111112"
  }
]
```

- `JpaRepository`에서 `@Query` 어노테이션을 통해 **Native Query** 를 사용하여 해결하였다.


### 2. 2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발
- Request

```
http://localhost:8080/kakaoStock/noTransaction
```

```
GET /kakaoStock/noTransaction HTTP/1.1
```

- Response

```json
[
  {
    "name": "테드",
    "year": 2018,
    "acctNo": "11111114"
  },
  {
    "name": "에이스",
    "year": 2019,
    "acctNo": "11111112"
  }
]
```

- `JpaRepository`에서 `@Query` 어노테이션을 통해 **Native Query** 를 사용하여 해결하였다.

### 3. 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발
- Request

```
http://localhost:8080/kakaoStock/totalByYearBranch
```

```
GET /kakaoStock/totalByYearBranch HTTP/1.1
```

- Response

```json
[
  {
    "year": "2018",
    "dataList": [
      {
        "brName": "분당점",
        "brCode": "B",
        "sumAmt": 38484000
      },
      {
        "brName": "강남점",
        "brCode": "C",
        "sumAmt": 12233267
      },
      {
        "brName": "판교점",
        "brCode": "A",
        "sumAmt": 9507000
      },
      {
        "brName": "잠실점",
        "brCode": "D",
        "sumAmt": 2000000
      }
    ]
  },
  {
    "year": "2019",
    "dataList": [
      {
        "brName": "판교점",
        "brCode": "A",
        "sumAmt": 66095100
      },
      {
        "brName": "분당점",
        "brCode": "B",
        "sumAmt": 18399400
      },
      {
        "brName": "강남점",
        "brCode": "C",
        "sumAmt": 4100000
      },
      {
        "brName": "잠실점",
        "brCode": "D",
        "sumAmt": 2000000
      }
    ]
  },
  {
    "year": "2020",
    "dataList": [
      {
        "brName": "을지로점",
        "brCode": "E",
        "sumAmt": 1000000
      }
    ]
  }
]
```
year ,brName, brCode, sum(sumAmt)
- `JpaRepository`에서 `@Query` 어노테이션을 통해 **Native Query** 를 사용하여 해결하였다.
- Query는 { "연도", "관리점이름", "관리점코드, "연도별 매출총액" } 를 반환하는 것과 { "연도" } 를 반환하는 두 가지 Query를 사용하였다.
- Query의 결과는 `List<Map<String, Object>>` 형태로 반환하며, 이를 `TotalByYearBranchService`에서 이중for문 처리하여 Controller에 리스트 형태로 반환하였다.
- 출력 요건의 형태를 정확히 맞추기 위해 `Map`과 `List`를 교차해서 사용했다.
- `year`와 `dataList`의 { "연도", "관리점이름", "관리점코드, "연도별 매출총액" } 중 `연도`를 맵핑하여 연도별로 나누고, `dataList`의 `연도`는 `remove` 했다.



### 4. 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발
- Request

```
http://localhost:8080/kakaoStock/branchTotal?brName
```

```
GET /kakaoStock/branchTotal HTTP/1.1
```

- Response

```
{
  --분당점 조회시
  "코드": "404",
  "메세지": "br code not found error"
}
```

```json
{
  "brName": "판교점",
  "brCode": "A",
  "sumAmt": 132485500
}
```
- `JpaRepository`에서 `@Query` 어노테이션을 통해 **Native Query** 를 사용하여 해결하였다.
- Query는 `판교 관리점`의 { 관리점이름", "관리점코드, "연도별 매출총액" } 를 반환하는 것과 `판교를 제외한 관리점`의 { 관리점이름", "관리점코드, "연도별 매출총액" } 를 반환하는 두 가지 Query를 사용하였다.
- Query의 결과는 `HTTP Status Code`를 고려하여 `ResponseEntity<Map<String, Object>>` 형태로 반환했다.
- `분당점`의 경우 판교점과 통폐합되어 `분당점` 조회 시 `http status : 404`를 반환하도록 하기 코드와 같이 `HttpStatus.NOT_FOUND`를 사용했다. 

```
ResponseEntity.status(HttpStatus.NOT_FOUND).body(FailResults);
```
