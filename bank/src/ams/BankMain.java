package ams;

import java.util.Scanner;

/* @ Date : 6.25 ~ 6.26
 * @ Author : 구로
 * @ Story : 은행(관리자) 기능 정의		*/
// 이클립스 코드 자동정렬 : CTRL + SHIFT + F
public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank(100);
		Scanner scanner = new Scanner(System.in);
		int accountNo = (int) ((Math.random() * 999999) + 111110);
		// valueOf() 는 자바API에 있는 java.lang.String 클래스의 메소드로
		// 숫자형을 문자열로 바꿔주는 역할을 한다.
		String strAccountNo = String.valueOf(accountNo);
		System.out.println("예 금 주 : ");
		String name = scanner.nextLine();
		System.out.println("비밀번호 : ");
		String pass = scanner.nextLine();
		System.out.println("예 금 액 : ");
		int inputMoney = scanner.nextInt();
		bank.openAccount(strAccountNo, name, pass, inputMoney);
		bank.openAccount("734575", "헐", pass, 300);
		bank.openAccount("789123", "헐크", pass, 500);
		bank.openAccount("741963", "헐로", pass, 100);
		bank.openAccount("741852", "로노", pass, 700);
		searchByName(bank, scanner);
		searchByNo(bank, scanner);

		deleteAccount(bank, scanner);
		searchList(bank);
		deleteAccount(bank, scanner);
		searchList(bank);
	}

	private static void deleteAccount(Bank bank, Scanner scanner) {
		System.out.println("=== 계좌 삭제 ===");
		System.out.println("삭제하려는 계좌번호 입력 :");
		String deleteAccount = scanner.next();
		Account account = bank.searchAccountByAccountNo(deleteAccount);
		if (account != null) {
			boolean isClose = bank.closeAccount(deleteAccount);
			if (isClose) {
				System.out.println("삭제 완료");
			} else {
			System.out.println("삭제불가!!! 전산팀에 문의하시오");
			}
		} else {
			System.out.println("없는 계좌번호 입니다.");
		}
	}

	private static void searchList(Bank bank) {
		System.out.println("=== 계좌번호 전체 목록 출력 ===");
		BankBook[] list = bank.getBankBookList();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());
			}
		} else {
			System.out.println("계좌 개설 필요");
		}
	}

	private static void searchByNo(Bank bank, Scanner scanner) {
		System.out.println("=== 계좌번호 조회(번호 입력) ===");
		System.out.println("조회하려는 계좌번호 입력");
		String searchAccountNo = scanner.next();
		Account account = bank.searchAccountByAccountNo(searchAccountNo);
		if (account != null) {
			System.out.println(account.toString());
		} else {
			System.out.println("조회결과 없음");
		}
	}

	/* 메소드 리펙토링 기법 : 복잡한 스파게티 소스를 가독성 있게 분리 시키고 메소드를 재사용 할수 있도록 모듈화 시키는 작업	 */
	private static void searchByName(Bank bank, Scanner scanner) {
		System.out.println("=== 계좌번호 조회(이름 입력) ===");
		System.out.println("조회하려는 이름을 입력");
		String inputName = scanner.next();
		BankBook[] bankBooks = (BankBook[]) bank
				.searchAccountsByName(inputName);
		// 메소드 오리지날 찾아가는 방법 : CTRL 누른체로 메소드 클릭
		// 디버깅 : 에러를 봤을 떄 데이터 값을 출력해 보면서 버그를 잡아가는 것
		if (bankBooks != null) {
			for (int i = 0; i < bankBooks.length; i++) {
				System.out.println(bankBooks[i].toString());
			}
		} else {
			System.out.println("조회한 이름 없음");
		}
	}
}