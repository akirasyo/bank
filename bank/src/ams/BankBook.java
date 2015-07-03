package ams;
/* @ Date : 6.25
 * @ Author : 구로
 * @ Story : 인터페이스 타입으로 생성된 통장 클래스 */
public class BankBook implements Account{
	private String accountNo;	// 계좌번호
	private String ownerName; // 계좌주인
	private String password;	 // 통장비번
	private int restMoney;	// 잔액
	public BankBook(String accountNo, String ownerName, String password, int restMoney) {
		// 필드값을 파라미터값과 매핑시키는 작업
		this.accountNo = accountNo ; 
		this.ownerName = ownerName ;
		this.password = password ;
		this.restMoney = restMoney ;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public String getPassword() {
		return password;
	}
	public int getRestMoney() {
		return restMoney;
	}
	public void setRestMoney(int restMoney) {
		this.restMoney = restMoney;
	}
	@Override
	public void deposit(int money) {
		if (money <=0) {
			System.out.println("입금액은 0보다 커야 합니다.");
		} else {
			this.restMoney += money ;
		}
	}

	@Override
	public void withdraw(int money) {
		if (money <= 0 ) {
			System.out.println("출금액은 0보다 커야 합니다.");
		} else if (getRestMoney()<money){
			System.out.println("출금액은 잔액보다 작아야 합니다.");
		} else {
			this.restMoney -= money;
	}
	}
	//	자바 API 중에서 java.lang.Ojbect 클래스의 메소드인
	//	toString() 을 오버라이딩 하였다.
	@Override
	public String toString() {
		return "[ " + BANK_NAME + " ]\n" + "계좌번호 : "+ getAccountNo() + " \n소 유 주 : "+ getOwnerName()
				+ " \n비밀번호 : **********\n" + "잔     액 : "+ getRestMoney() ;
	}
}
