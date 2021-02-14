package salaries;

public class CompareByName implements Sortable {

	@Override
	public boolean compareTo(Worker worker1, Worker worker2) {
		return worker1.compareByName(worker2) > 0;
	}
	
}
