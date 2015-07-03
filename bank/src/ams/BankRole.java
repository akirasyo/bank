package ams;
/* @ Date : 6.25
 * @ Author : 구로
 * @ Story : 은행(관리자) 기능 정의*/
public interface BankRole {
	//	계좌를 개설 기능
	public void openAccount(String accountNo, String ownerName, String password, int restMoney);
	//	계좌번호로 특정 계좌를 조회(검색) 기능
	public Account searchAccountByAccountNo(String accountNo);
	//	예금주 이름으로 그 사람이 가지고 있는 계좌 조회
	public Account[] searchAccountsByName(String ownerName);
	//	계좌번호로 특정 계좌를 폐기(삭제) 기능
	public boolean closeAccount(String accountNo);
}
