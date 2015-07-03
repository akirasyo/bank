package ams;

import java.util.Scanner;

/* @ Date : 6.25 ~ 6.26
 * @ Author : ����
 * @ Story : ����(������) ��� ����		*/
// ��Ŭ���� �ڵ� �ڵ����� : CTRL + SHIFT + F
public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank(100);
		Scanner scanner = new Scanner(System.in);
		int accountNo = (int) ((Math.random() * 999999) + 111110);
		// valueOf() �� �ڹ�API�� �ִ� java.lang.String Ŭ������ �޼ҵ��
		// �������� ���ڿ��� �ٲ��ִ� ������ �Ѵ�.
		String strAccountNo = String.valueOf(accountNo);
		System.out.println("�� �� �� : ");
		String name = scanner.nextLine();
		System.out.println("��й�ȣ : ");
		String pass = scanner.nextLine();
		System.out.println("�� �� �� : ");
		int inputMoney = scanner.nextInt();
		bank.openAccount(strAccountNo, name, pass, inputMoney);
		bank.openAccount("734575", "��", pass, 300);
		bank.openAccount("789123", "��ũ", pass, 500);
		bank.openAccount("741963", "���", pass, 100);
		bank.openAccount("741852", "�γ�", pass, 700);
		searchByName(bank, scanner);
		searchByNo(bank, scanner);

		deleteAccount(bank, scanner);
		searchList(bank);
		deleteAccount(bank, scanner);
		searchList(bank);
	}

	private static void deleteAccount(Bank bank, Scanner scanner) {
		System.out.println("=== ���� ���� ===");
		System.out.println("�����Ϸ��� ���¹�ȣ �Է� :");
		String deleteAccount = scanner.next();
		Account account = bank.searchAccountByAccountNo(deleteAccount);
		if (account != null) {
			boolean isClose = bank.closeAccount(deleteAccount);
			if (isClose) {
				System.out.println("���� �Ϸ�");
			} else {
			System.out.println("�����Ұ�!!! �������� �����Ͻÿ�");
			}
		} else {
			System.out.println("���� ���¹�ȣ �Դϴ�.");
		}
	}

	private static void searchList(Bank bank) {
		System.out.println("=== ���¹�ȣ ��ü ��� ��� ===");
		BankBook[] list = bank.getBankBookList();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());
			}
		} else {
			System.out.println("���� ���� �ʿ�");
		}
	}

	private static void searchByNo(Bank bank, Scanner scanner) {
		System.out.println("=== ���¹�ȣ ��ȸ(��ȣ �Է�) ===");
		System.out.println("��ȸ�Ϸ��� ���¹�ȣ �Է�");
		String searchAccountNo = scanner.next();
		Account account = bank.searchAccountByAccountNo(searchAccountNo);
		if (account != null) {
			System.out.println(account.toString());
		} else {
			System.out.println("��ȸ��� ����");
		}
	}

	/* �޼ҵ� �����丵 ��� : ������ ���İ�Ƽ �ҽ��� ������ �ְ� �и� ��Ű�� �޼ҵ带 ���� �Ҽ� �ֵ��� ���ȭ ��Ű�� �۾�	 */
	private static void searchByName(Bank bank, Scanner scanner) {
		System.out.println("=== ���¹�ȣ ��ȸ(�̸� �Է�) ===");
		System.out.println("��ȸ�Ϸ��� �̸��� �Է�");
		String inputName = scanner.next();
		BankBook[] bankBooks = (BankBook[]) bank
				.searchAccountsByName(inputName);
		// �޼ҵ� �������� ã�ư��� ��� : CTRL ����ü�� �޼ҵ� Ŭ��
		// ����� : ������ ���� �� ������ ���� ����� ���鼭 ���׸� ��ư��� ��
		if (bankBooks != null) {
			for (int i = 0; i < bankBooks.length; i++) {
				System.out.println(bankBooks[i].toString());
			}
		} else {
			System.out.println("��ȸ�� �̸� ����");
		}
	}
}