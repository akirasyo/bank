package ams;

import java.util.Scanner;

/* @ Date : 6.26
 * @ Author : 구로
 * @ Story : 		*/
/* 	컨트롤러 패턴(공항의 관제탑)	*/
public class ProcessMain {
	public static void main(String[] args) {
		Bank bank = new Bank(1000);
		Scanner scanner = new Scanner(System.in);
		int input = 0, key = 0;
		while (true) {	//	무한루프
			try {
				System.out.println("1.계좌개설 2.계좌조회(번호) 3.계좌조회(이름) 4.전체조회 5. 계좌삭제");
				input = scanner.nextInt();
				key = InputCheck(input,1,5);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("숫자만 입력가능");
				System.out.println("ProcessMain의 try-catch 에러발생");
			}
			switch (key) {
			case 1:
				int accountNo = (int) ((Math.random() * 999999) + 111110);
				String strAccountNo = String.valueOf(accountNo);
				System.out.println("예 금 주 : ");
				String name = scanner.next();
				System.out.println("비밀번호 : ");
				String pass = scanner.next();
				System.out.println("예 금 액 : ");
				int inputMoney = scanner.nextInt();
				bank.openAccount(strAccountNo, name, pass, inputMoney);				break;
			case 2:
				System.out.println("=== 계좌번호 조회(번호 입력) ===");
				System.out.println("조회하려는 계좌번호 입력");
				String searchAccountNo = scanner.next();
				Account account = bank.searchAccountByAccountNo(searchAccountNo);
				if (account != null) {
					System.out.println(account.toString());
				} else {
					System.out.println("조회결과 없음");
				}				break;
			case 3:
				System.out.println("=== 계좌번호 조회(이름 입력) ===");
				System.out.println("조회하려는 이름을 입력");
				String inputName = scanner.next();
				BankBook[] bankBooks = (BankBook[]) bank.searchAccountsByName(inputName);
				if (bankBooks != null) {
					for (int i = 0; i < bankBooks.length; i++) {
						System.out.println(bankBooks[i].toString());
					}
				} else {
					System.out.println("조회한 이름 없음");
				}				break;
			case 4:
				System.out.println("=== 계좌번호 전체 목록 출력 ===");
				BankBook[] list = bank.getBankBookList();
				if (list != null ) {
					for (int i = 0; i < bank.getCount(); i++) {
						System.out.println(list[i].toString());
					}
				} else {
					System.out.println("계좌 개설 필요");
				}			break;
			case 5:
				System.out.println("=== 계좌 삭제 ===");
				System.out.println("삭제하려는 계좌번호 입력 :");
				String deleteAccount = scanner.next();
				Account account1 = bank.searchAccountByAccountNo(deleteAccount);
				if (account1 != null) {
					boolean isClose = bank.closeAccount(deleteAccount);
					if (isClose) {
						System.out.println("삭제 완료");
					} else {
					System.out.println("삭제불가!!! 전산팀에 문의하시오");
					}
				} else {
					System.out.println("없는 계좌번호 입니다.");
				}				break;
			default:	break;
			}
		}
	}

	private static int InputCheck(int input, int first, int last) {
		int key = input;
		if (key<first || key>last) {
			System.out.println("초기메뉴의 선택범위를 넘어섰습니다.");
			return 0;
		} else {
			return key;
		}
	}
}