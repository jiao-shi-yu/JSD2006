package day07.innerClasses.anonymous;

interface ProductInformationList {
	int getNumber();
	String getName();
}

public class InterfaceAnonymousClassTest {
	
	public void test(ProductInformationList pil) {
		System.out.println("产品名称：" + pil.getName() + "，产品数量：" + pil.getNumber());
	}
	
	public static void main(String[] args) {
		InterfaceAnonymousClassTest ac = new InterfaceAnonymousClassTest();
		ac.test(new ProductInformationList() {
			
			@Override
			public int getNumber() {
				return 1;
			}
			
			@Override
			public String getName() {
				return "电脑";
			}
		});
	}
}

