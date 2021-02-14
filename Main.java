package salaries;

public class Main {

	private static void init() {
		Company company = new Company();
		boolean exit;
		
		do {
			company.printMenu();
			int option = company.readOption();
			exit = company.executeOption(option);
		} while (!exit);
	}

	public static void main(String[] args) {
		init();
	}
}
