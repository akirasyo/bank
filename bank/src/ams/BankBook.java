package ams;
/* @ Date : 6.25
 * @ Author : ����
 * @ Story : �������̽� Ÿ������ ������ ���� Ŭ���� */
public class BankBook implements Account{
	private String accountNo;	// ���¹�ȣ
	private String ownerName; // ��������
	private String password;	 // ������
	private int restMoney;	// �ܾ�
	public BankBook(String accountNo, String ownerName, String password, int restMoney) {
		// �ʵ尪�� �Ķ���Ͱ��� ���ν�Ű�� �۾�
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
			System.out.println("�Աݾ��� 0���� Ŀ�� �մϴ�.");
		} else {
			this.restMoney += money ;
		}
	}

	@Override
	public void withdraw(int money) {
		if (money <= 0 ) {
			System.out.println("��ݾ��� 0���� Ŀ�� �մϴ�.");
		} else if (getRestMoney()<money){
			System.out.println("��ݾ��� �ܾ׺��� �۾ƾ� �մϴ�.");
		} else {
			this.restMoney -= money;
	}
	}
	//	�ڹ� API �߿��� java.lang.Ojbect Ŭ������ �޼ҵ���
	//	toString() �� �������̵� �Ͽ���.
	@Override
	public String toString() {
		return "[ " + BANK_NAME + " ]\n" + "���¹�ȣ : "+ getAccountNo() + " \n�� �� �� : "+ getOwnerName()
				+ " \n��й�ȣ : **********\n" + "��     �� : "+ getRestMoney() ;
	}
}
