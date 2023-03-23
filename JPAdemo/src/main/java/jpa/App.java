package jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
	private static EntityManagerFactory emf = null;
	private static EntityManager manager = null;

	static {
		emf = Persistence.createEntityManagerFactory("Test");
		manager = emf.createEntityManager();
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		char ch = 0;
		do {
			System.out.println(" 1)Insert \n 2)Update \n 3)Delete \n 4)Search by Sid");
			System.out.println("Enter the option:");
			int option = scanner.nextInt();

			switch (option) {

			case 1:
				System.out.println("Enter the pid , pname and Pcolor:");
				insertData(scanner.nextInt(), scanner.next(), scanner.next());
				System.out.println("Inserted successfully");
				break;

			case 2:
				System.out.println("Enter the pid and Pcolor:");
				updateData(scanner.nextInt(),scanner.next());
				System.out.println("Updated successfully");
				break;

			case 3:
				System.out.println("Enter the pid to be deleted");
				deleteData(scanner.nextInt());
				System.out.println("Deleted successfully");
				break;
			case 4:
				System.out.println("Enter the pid:");
				findById(scanner.nextInt());
				break;
			}

			System.out.println("enter y or Y to continue");
			ch = scanner.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');
		scanner.close();
	}

	private static void insertData(int Pid, String Pname, String pColor) {
		Product pro =new Product();
		pro.setpId(Pid);
		pro.setpName(Pname);
		pro.setPcolor(pColor);
		manager.getTransaction().begin();
		manager.persist(pro);
		manager.getTransaction().commit();
	}

	private static void updateData(int pid, String color) {
		manager.getTransaction().begin();
		Product pro = manager.find(Product.class, pid); 
		if (pro != null) {
			pro.setPcolor(color);
			manager.merge(pro);
		}
		manager.getTransaction().commit();
	}

	private static void deleteData(int pid) {
		Product pro  = manager.find(Product.class, pid);
		if (pro != null) {
			manager.getTransaction().begin();
			manager.remove(pro);
			manager.getTransaction().commit();
		}
	}

	private static void findById(int pid) {
		Product pro = manager.find(Product.class, pid);
		System.out.println(pro);

	}
	
}

