package model;

import java.util.Date;
import java.util.List;

import control.ReturnBook;

public class Book {

	private String Isbn;
	private String name;
	private double price;
	private int number;
	private List<Date> borrowList;
	private List<ReturnBook> returnList;
	private List<Customer> customerList;
	private boolean status;

	public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String isbn) {
		Isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void borrowBook(Customer customer, Date borrowDate) {
		customerList.add(customer);
		borrowList.add(borrowDate);
	}

	public void returnBook(Customer customer, Date borrowDate, Date returnDate) {
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).equals(customer)) {
				if (borrowList.get(i).equals(borrowDate)) {
					ReturnBook rb = new ReturnBook();
					rb.setCustomer(customer);
					rb.setBorrowDate(borrowDate);
					rb.setReturnDate(returnDate);
					returnList.add(rb);
					customerList.remove(i);
					borrowList.remove(i);
				}
			}
		}
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
