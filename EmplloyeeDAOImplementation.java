package com.kodnest.DOAPattern.DOAPAttern;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class EmplloyeeDAOImplementation implements EmployeeDAO {
	Scanner sc = new Scanner(System.in);
	SessionFactory sf = null;

	public SessionFactory getSessionFactory() {
		if (sf == null) {
			Configuration configuration = new Configuration();

			configuration.configure("hibernate.cfg.xml");

			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sf = configuration.buildSessionFactory(serviceRegistry);
			return sf;
		}
		return sf;
	}

	@Override
	public List<Employee> getEmployee() {
		Session session = null;

		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Employee.class);
			List<Employee> emplist = criteria.list();
			for (Employee emp : emplist) {
				System.out.println(emp);

			}
			return emplist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();

		}

	}

	@Override
	public Employee getEmployeeByid(int id) {
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			Employee obj = (Employee) session.get(Employee.class, id);
			return obj;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public String persistEmployee(Employee obj) {
		sf = getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(obj);
		session.getTransaction().commit();
		session.close();

		return obj.toString() + " inserted";
	}

	@Override
	public String updateEmployee(String department) {
		Session session = null;
		try {
			System.out.println("Enter employee id :");
			int id = sc.nextInt();
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			Employee obj = (Employee) session.get(Employee.class, id);
			obj.setDepartment(department);
			session.update(obj);
			session.getTransaction().commit();

			return "row updated..";

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public String deleteemployee(Employee obj) {
		Session session = null;
		try {
			sf = getSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
			return "one row deleted";

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

}
