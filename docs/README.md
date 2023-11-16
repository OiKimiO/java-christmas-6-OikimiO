### 다이어 그램
<img src="https://github.com/OiKimiO/java-lotto-6/assets/53805469/edbf315b-4d8f-47b6-ad02-1241f24acde6" style="width:100%;" />

### 패키지 구조
<table>
    <thead>
        <tr>
            <th>Package</th>
            <th>SubPackage</th>
            <th>Class</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
	    <tr>
	        <td rowspan="5">config</td>
	        <td rowspan="2">convert</td>
	        <td>ConvertToArray</td>
	        <td>String을 Array로 변환하는 기능을 수행합니다.</td>
        </tr>
        <tr>
	        <td>ConvertToInt</td>
	        <td>String을 int로 변환하는 기능을 수행합니다.</td>
        </tr>
        <tr>
	        <td rowspan="2">exception</td>
	        <td>ExceptionType</td>
	        <td>각 기능별 예외 기능을 관리합니다.</td>
        </tr>
        <tr>
	        <td>InputException</td>
	        <td>입력 예외를 관리합니다.</td>
        </tr>
        <tr>
	        <td>utils</td>
	        <td>RepeatReader</td>
	        <td>사용자 입력을 재처리할 수 있도록 관리합니다.</td>
        </tr>
		<tr>
	        <td rowspan="3">controller</td>
	        <td >format</td>
	        <td>OrderFormat</td>
	        <td>주문과 관련된 형식을 확인 및 관리합니다.</td>
        </tr>
        <tr>
	        <td rowspan="2">X</td>
	        <td>Reservation</td>
	        <td>예약과 관련된 작업을 진행합니다. </td>
        </tr>
        <tr>
	        <td>PreviewBenefit</td>
	        <td>혜택 미리보기와 관련된 작업을 진행합니다.</td>
        </tr>
        <tr>
	        <td rowspan="22">domain</td>
	        <td rowspan="10">benefit</td>
	        <td>Benefit</td>
	        <td>할인 혜택과 관련된 기능을 관리합니다. </td>
        </tr>
        <tr>
	        <td>DiscountAmount</td>
	        <td><b>할인 금액</b>과 <b>할인 출력 형식</b> 인터페이스를 관리합니다.</td>
        </tr>
        <tr>
	        <td>PresentationPolicy</td>
	        <td>증정에 대한 정책을 관리합니다.</td>
        </tr>
        <tr>
	        <td>DayOfWeekPolicy</td>
	        <td>요일 정책(평일 정책, 주말 정책)에서 반복되는 부분을 관리합니다.</td>
        </tr>
        <tr>
	        <td>WeekDayPolicy</td>
	        <td>평일 요일 정책을 관리합니다. 디저트만 할인을 받을 수 있습니다.</td>
        </tr>
        <tr>
	        <td>WeekendPolicy</td>
	        <td>주말 요일 정책을 관리합니다. 메인 요리만 할인을 받을 수 있습니다.</td>
        </tr>
        <tr>
	        <td>DayPolicy</td>
	        <td>일수 정책(크리스마스 디데이, 특별한날 할인)에서 반복되는 부분을 관리합니다.</td>
        </tr>
        <tr>
	        <td>DDayPolicy</td>
	        <td>크리스마스 디데이 정책을 관리합니다.  크리스마스까지 매일 할인금이 100원씩 추가됩니다.</td>
        </tr>
        <tr>
	        <td>SpecialDayPolicy</td>
	        <td>특별한날 할인 정책을 관리합니다. 사용자가 지정한 일자만 할인 받을 수 있습니다.</td>
        </tr>
        <tr>
	        <td>Badge</td>
	        <td>새해 배지</td>
        </tr>
        <tr>
	        <td rowspan="7">menu</td>
	        <td>Menu</td>
	        <td>메뉴와 관련된 기능을 관리합니다.</td>
        </tr>
        <tr>
	        <td>CookType</td>
	        <td>요리 종류와 관련된 기능을 정리합니다. 요리에 해당하는 모든 내용을 관리합니다.</td>
        </tr>
        <tr>
	        <td>Cooking</td>
	        <td>요리에 해당하는 것을 관리합니다.</td>
        </tr>
        <tr>
	        <td>Appetizer</td>
	        <td>애피타이저와 관련된 음식을 관리합니다.</td>
        </tr>
        <tr>
	        <td>Beverage</td>
	        <td>음료와 관련된 음식을 관리합니다.</td>
        </tr>
        <tr>
	        <td>Dessert</td>
	        <td>디저트와 관련된 음식을 관리합니다.</td>
        </tr>
        <tr>
	        <td>MainDish</td>
	        <td>요리와 관련된 음식을 관리합니다. </td>
        </tr>
        <tr>
	        <td rowspan="5">order</td>
	        <td>Payment</td>
	        <td>사용자의 지불 금액에 대해 관리합니다.</td>
        </tr>
        <tr>
	        <td>OrderHistory</td>
	        <td>주문을 관리합니다.</td>
        </tr>
        <tr>
	        <td>Order</td>
	        <td>주문은 <b>주문 메뉴</b>와 <b>주문 수량</b>을 관리합니다.</td>
        </tr>
        <tr>
	        <td>OrderQuantity</td>
	        <td>주문 수량을 관리합니다.</td>
        </tr>
        <tr>
	        <td>ReservationDay</td>
	        <td>예약일을 관리합니다.</td>
        </tr>
        <tr>
	        <td >dto</td>
	        <td>X</td>
	        <td >ReservationDto</td>
	        <td>예약 정보를 혜택 미리보기에 전달할 때 사용됩니다.</td>
        </tr>
        <tr>
	        <td rowspan="5">view</td>
	        <td>input</td>
	        <td >InputView</td>
	        <td>사용자의 입력을 관리합니다.</td>
        </tr>
        <tr>
	        <td rowspan="4">output</td>
	        <td >OutputView</td>
	        <td>사용자의 출력을 관리합니다.</td>
        </tr>
        <tr>
	        <td >MessageType</td>
	        <td>메시지 타입을 사용하기 위한 인터페이스를 정의합니다.</td>
        </tr>
        <tr>
	        <td >InputMessage</td>
	        <td>사용자가 입력에 대한 메시지를 관리합니다.</td>
        </tr>
        <tr>
	        <td >DomainMessage</td>
	        <td>도메인에 대한 메시지를 관리합니다.</td>
        </tr>
    </tbody>
</table>

### 기능 구현 목록
**메뉴**
```text
1. 애피타이저
   - 양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)
2. 메인
   - 티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
3. 디저트
   - 초코케이크(15,000), 아이스크림(5,000)
4. 음료
   - 제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```

**사용자 입/출력**
```text
기본 기능
- 잘못된 값 입력: `IllegalArgumentException` 발생 후 재입력 유도

1. 식당 예상 방문 날짜 입력
   - 입력 형식: 1 <= 날짜 <= 31
   - 조건이 아닌 경우
      - `[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.`를 출력

2. 주문 메뉴 개수 입력
   - 입력 형식: {메뉴이름}-{메뉴개수}
   - 메뉴개수 조건이 아닌 경우
      - ({메뉴개수} >= 1): `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.` 출력
   - 메뉴이름 조건이 아닌 경우
      - ({메뉴이름} 형식 맞지 않음): `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`를 출력
      - ({메뉴이름} 중복): `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`를 출력

3. 출력 방식
   - 주문 메뉴 순서는 자유롭게 출력
   - 총혜택 금액에 따라 이벤트 배지 이름 다르게 출력
   - 증정 이벤트에 해당하지 않는 경우, 혜택 내역 **없음**으로 출력
   - 혜택 내역
      - 고객에게 적용된 이벤트만 출력(순서는 상관 X)
      - 적용된 이벤트가 없다면 혜태내역 **없음**으로 출력
   - 이벤트 배지
      - 이벤트 배지가 부여되지 않은 경우 **없음**으로 출력
   - 할인 후 예상 결제 금액= 할인 전 총주문 금액 - 할일 금액
```

**혜택 관련 정책**
```text
기본 기능
- 이벤트 적용 조건: 총 주문 금액 10,000원 이상
- 음료만 주문시 주문 X
- 최대 메뉴 주문수: 20개
- 총혜택 금액= 할일 금액 합계 + 증정 메뉴의 가격

1. 크리스마스 디데이 할인 정책
   - 할인 적용 기간: 2023.12.1 ~ 2023.12.25
   - 할인 금액 적용: 1,000원으로 시작해 크리스마스가 다가올수록 금액이 100원씩 증가
     (시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원)

2. 평일 할인 정책
   - 할인 적용 기간: 2023.12.1 ~ 2023.12.31
   - 할인 적용 요일: 일요일 ~ 목요일
   - 할인 금액 적용: **디저트** 메뉴 1개당 2,023원 할인

3. 주말 할인 정책
   - 할인 적용 기간: 2023.12.1 ~ 2023.12.31
   - 할인 적용 요일: 금요일, 토요일
   - 할인 금액 적용: **메인** 메뉴를 메뉴 1개당 2,023원 할인

4. 특별 할인 정책
   - 할인 적용 기간: 2023.12.1 ~ 2023.12.31
   - 할인 적용 요일: 이벤트 달력에 별이 붙어 있는 요일 
   - 할인 금액 적용: 총 주문 금액 - 1,000원 할인 
 
5. 증정 이벤트
   - 할인 적용 기간: 2023.12.1 ~ 2023.12.31
   - 증정 이벤트 조건: 할인 전 총 주문 금액이 12만원 이상
   - 증정 물품: 샴페인 1개
```

**이벤트 배지**
```text
- 이벤트 배지 적용 기간: 2023.12.1 ~ 2023.12.31
- 총 혜택 금액에 따른 이벤트 배지 부여 조건
    - 5,000원 이상: 별
    - 10,000원 이상: 트리
    - 20,000원 이상: 산타
```
