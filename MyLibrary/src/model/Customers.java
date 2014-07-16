package model;

import java.util.ArrayList;
import java.util.List;

public class Customers {

	private List<Customer> custlist = new ArrayList<>();

	public void addCustomer(String email, String firstName, String lastName,
			String password, int phone, String favorite) {
		if (custlist.isEmpty()) {
			System.out.println("Custlist is empty, add the customer");
			Customer cust = new Customer();
			cust.setEmail(email);
			cust.setFirstName(firstName);
			cust.setLastName(lastName);
			cust.setPassward(password);
			cust.setPhone(phone);
			cust.setFavorite(favorite);
			custlist.add(cust);
		} else {
			for (Customer cust : custlist) {
				if (cust.getEmail().equals(email)) {
					System.out.println("This customer is existed");
					return;
				}
			}
			System.out.println("No such customer, add him/her to the custlist");
			Customer cust = new Customer();
			cust.setEmail(email);
			cust.setFirstName(firstName);
			cust.setLastName(lastName);
			cust.setPassward(password);
			cust.setPhone(phone);
			cust.setFavorite(favorite);
			custlist.add(cust);
		}
	}

	public void deleteCustomer(String email, String phone) {
		for (Customer cust : custlist) {
			if (cust.getEmail().equals(email)) {
				System.out.println("Found this customer, remove");
				custlist.remove(cust);
				return;
			}
		}
		System.out.println("Customer is not found");
	}

}
