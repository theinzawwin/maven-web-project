package com.best.mtest;

public class Book {


		private Integer id;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public Integer getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		private String name;
		private String photo;
		private int qty;
		private Integer categoryId;
		private String categoryName;
		
		public Book() {
			super();
		}
		public Book(Integer id, String name, String photo, int qty, Integer categoryId, String categoryName) {
			super();
			this.id = id;
			this.name = name;
			this.photo = photo;
			this.qty = qty;
			this.categoryId = categoryId;
			this.categoryName = categoryName;
		}
		public Book(Integer id, String name, String photo, int qty, Integer categoryId) {
			super();
			this.id = id;
			this.name = name;
			this.photo = photo;
			this.qty = qty;
			this.categoryId = categoryId;
		}
		
		
	
}
