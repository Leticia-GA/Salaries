package salaries;

public class CompareBySalaryAsc implements Sortable {

	@Override
	public boolean compareTo(Worker worker1, Worker worker2) {
		return worker1.compareBySalary(worker2);
	}
	
}
