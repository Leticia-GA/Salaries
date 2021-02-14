package salaries;

public class Company {

	private Console console;
	private Worker[] workers;

	public Company() {
		console = new Console();
		workers = new Worker[0];
	}

	public void printMenu() {
		console.println("1 - Crear el array.");

		if (workers.length > 0) {
			printWorkersMenu();
		}

		console.println("8 - Finalizar.");
	}

	private void printWorkersMenu() {
		console.println("2 - Mostrar todo el contenido del array.");
		console.println("3 - Mostrar el nombre del empleado que más dinero gana y su sueldo.");
		console.println(
				"4 - Ordenar el array por el nombre del empleado y mostrar el resultado de la ordenación del empleado y sueldo.");
		console.println(
				"5 - Ordenar el array por el sueldo de menor a mayor y mostrar el resultado de la ordenación del empleado y sueldo.");
		console.println(
				"6 - Ordenar el array por el sueldo de mayor sueldo a menor y mostrar el resultado de la ordenación del empleado y sueldo.");
		console.println("7 - Introducir un número i y que muestre los datos del empleado, su nombre y sueldo.");
	}

	public int readOption() {
		console.println("Introduzca una opción");

		int option = console.readInt();

		while (!validOption(option)) {
			console.println("Opción incorrecta. Introduzca una opción de las señaladas anteriormente");
			option = console.readInt();
		}

		return option;
	}

	private boolean validOption(int option) {
		if (workers.length > 0) {
			return option >= 1 && option <= 8;
		}

		return option == 1 || option == 8;
	}

	public boolean executeOption(int option) {
		switch (option) {
		case 1:
			createWorkers();
			break;
		case 2:
			showWorkers(workers);
			break;
		case 3:
			showBestPaid();
			break;
		case 4:
			sortWorkersByName();
			break;
		case 5:
			sortWorkersBySalaryAsc();
			break;
		case 6:
			sortWorkersBySalaryDesc();
			break;
		case 7:
			showWorker();
			break;
		case 8:
			console.println("Fin del programa");
			return true;
		}

		return false;
	}

	private void createWorkers() {
		workers = new Worker[readNumWorkers()];

		for (int i = 0; i < workers.length; i++) {
			Worker worker = readWorker();
			worker.setNum(Integer.toString(i + 1));
			workers[i] = worker;
		}
	}

	private int readNumWorkers() {
		console.println("Introduce el número de trabajadores");
		
		return console.readInt();
	}

	private Worker readWorker() {
		Worker worker = new Worker();

		console.println("Introduce el nombre del trabajador");
		worker.setName(console.readString());

		console.println("Introduce el salario del trabajador");
		worker.setSalary(console.readDecimal());

		return worker;
	}

	private void showWorkers(Worker[] workers) {
		for (int i = 0; i < workers.length; i++) {
			Worker worker = workers[i];
			printWorker(worker);
		}
	}

	private void printWorker(Worker worker) {
		console.println("Empleado Nº " + worker.getNum() + " - " + getWorkerData(worker));
	}

	private String getWorkerData(Worker worker) {
		return "Nombre: " + worker.getName() + ", Salario: " + worker.getSalary() + " €";
	}

	private void showBestPaid() {
		Worker bestPaid = getBestPaid(workers);

		if (bestPaid != null) {
			console.println("El trabajador mejor pagado es " + getWorkerData(bestPaid));
		}
	}

	private static Worker getBestPaid(Worker[] workers) {
		Worker bestPaid = null;
		float bestSalary = 0;

		for (int i = 0; i < workers.length; i++) {
			Worker currentWorker = workers[i];

			if (currentWorker.getSalary() > bestSalary) {
				bestPaid = currentWorker;
				bestSalary = currentWorker.getSalary();
			}
		}

		return bestPaid;
	}

	private void sortWorkersByName() {
		sortWorkers(new CompareByName());
	}

	private void sortWorkersBySalaryAsc() {
		sortWorkers(new CompareBySalaryAsc());
	}

	private void sortWorkersBySalaryDesc() {
		sortWorkers(new CompareBySalaryDesc());
	}
	
	private void sortWorkers(Sortable sortable) {
		Worker[] sortedWorkers = workers.clone();
		Worker aux;

		for (int i = sortedWorkers.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (sortable.compareTo(sortedWorkers[j], sortedWorkers[j + 1])) {
					aux = sortedWorkers[j + 1];
					sortedWorkers[j + 1] = sortedWorkers[j];
					sortedWorkers[j] = aux;
				}
			}
		}

		showWorkers(sortedWorkers);
	}

	private void showWorker() {
		console.println("Introduzca el número de empleado:");
		int numWorker = console.readInt();

		while (!validNumWorker(numWorker)) {
			console.println("Opción incorrecta. Introduzca un número de trabajador entre 1 y " + workers.length);
			numWorker = console.readInt();
		}

		console.println(getWorkerData(workers[numWorker - 1]));
	}

	private boolean validNumWorker(int numWorker) {
		return numWorker > 0 && numWorker <= workers.length;
	}
}
