package ams;
/* @ Date : 6.25
 * @ Author : 구로
 * @ Story : 은행(고객) 기능 정의*/
public interface Account {
	public static final String BANK_NAME = "아이티뱅크" ;
	public void deposit(int money);
	public void withdraw(int money);
}
