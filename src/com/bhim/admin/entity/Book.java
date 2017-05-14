package com.bhim.admin.entity;

public class Book {
	private boolean validCheck;

	private int b_id;
	private long fine;
	private String b_name, b_author, b_isbn, b_publication, b_publication_year, b_purchase_date, b_category, b_cost,
			b_number, issuedate, returndate;

	public boolean isValidCheck() {
		return validCheck;
	}

	public void setValidCheck(boolean validCheck) {
		this.validCheck = validCheck;
	}

	public long getFine() {
		return fine;
	}

	public void setFine(long fine) {
		this.fine = fine;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	public String getB_isbn() {
		return b_isbn;
	}

	public void setB_isbn(String b_isbn) {
		this.b_isbn = b_isbn;
	}

	public String getB_publication() {
		return b_publication;
	}

	public void setB_publication(String b_publication) {
		this.b_publication = b_publication;
	}

	public String getB_publication_year() {
		return b_publication_year;
	}

	public void setB_publication_year(String b_publication_year) {
		this.b_publication_year = b_publication_year;
	}

	public String getB_purchase_date() {
		return b_purchase_date;
	}

	public void setB_purchase_date(String b_purchase_date) {
		this.b_purchase_date = b_purchase_date;
	}

	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public String getB_cost() {
		return b_cost;
	}

	public void setB_cost(String b_cost) {
		this.b_cost = b_cost;
	}

	public String getB_number() {
		return b_number;
	}

	public void setB_number(String b_number) {
		this.b_number = b_number;
	}

}
