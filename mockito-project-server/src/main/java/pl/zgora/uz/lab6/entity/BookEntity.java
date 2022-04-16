package pl.zgora.uz.lab6.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pl.zgora.uz.lab6.interfaces.Entity;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "Book")
public class BookEntity implements Entity, Serializable {

	@Id
	@Column(name = "ID_BOOK", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_G_USER")
	@SequenceGenerator(name = "S_G_USER", allocationSize = 10)
	private Long id;

	@Column(name = "TITLE", nullable = false)
	private String title;

	@Column(name = "ADDED_DATE", nullable = false)
	private LocalDate addedDate;

	@Column(name = "AUTHOR", nullable = false)
	private String author;

	@Column(name = "NUMBER_OF_PAGES", nullable = false)
	private int numberOfPages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate creationDate) {
		this.addedDate = creationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

}
