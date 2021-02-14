package salaries;

public class Worker {
	private String name;
	private float salary;
	private String num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public int compareByName(Worker worker) {
		return name.compareToIgnoreCase(worker.getName());
	}
	
	public boolean compareBySalary(Worker worker) {
		return salary > worker.getSalary();
	}
}
