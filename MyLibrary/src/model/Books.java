package model;

import java.util.ArrayList;
import java.util.List;

public class Books {

	private int numberOfAllKindBooks;
	private List<Book> list = new ArrayList<>();

	public Books() {
	}

	public void addBooks(String Isbn, String name, double price,
			int number) {
		if (list.isEmpty()) {
			System.out.println("List is empty, add books now");
			Book newbook = new Book();
			newbook.setIsbn(Isbn);
			newbook.setName(name);
			newbook.setPrice(price);
			newbook.setStatus(true);
			newbook.setNumber(number);
			list.add(newbook);
		} else {
			for (Book book : list) {
				if (book.getIsbn().equals(Isbn)) {
					System.out
							.println("Found this book in the list, change its number");
					book.setNumber(book.getNumber() + number);
					return;
				}
			}
			System.out.println("No such book in the list, add books now");
			Book newbook = new Book();
			newbook.setIsbn(Isbn);
			newbook.setName(name);
			newbook.setPrice(price);
			newbook.setStatus(true);
			newbook.setNumber(number);
			list.add(newbook);
		}
	}

	// When you need to permanently delete one kind of book from the list
	public void deleteBooks(String Isbn) {
		for (Book book : list) {
			if (book.getIsbn().equals(Isbn)) {
				System.out.println("Found this book in the list, remove it");
				list.remove(book);
				return;
			}
		}
		System.out.println("Book is not found");
	}

	public int getNumberOfAllKindBooks() {
		return numberOfAllKindBooks;
	}

	public void setNumberOfAllKindBooks() {
		this.numberOfAllKindBooks = list.size();
	}
	
	public Book getBook(int index) {
		return list.get(index);
	}

}
