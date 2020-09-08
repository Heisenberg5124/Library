package subereproject.scrawler.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "Books")
@Indexed
public class Book {

	@Id
	private int id;
	@Nationalized
	@Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
	private String title;
	@Nationalized
	@Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
	private String author;
	@Nationalized
	private String type;
	@Nationalized
	private String publisher;
	@Nationalized
	private String no;
	private int available;
	private int total;
	@Nationalized
	private String status;
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	private List<BookCopies> copies;
	
	public Book() {
	}

	public Book(int id, String title, String author, String type, String publisher, String no, int available, int total,
			String status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.type = type;
		this.publisher = publisher;
		this.no = no;
		this.available = available;
		this.total = total;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BookCopies> getCopies() {
		return copies;
	}

	public void setCopies(List<BookCopies> copies) {
		this.copies = copies;
	}

	@Override
	public String toString() {

		return "\nTiêu đề: " + title + "\nTác giả: " + author + "\nDạng tài liệu: " + type + "\nNXB: " + publisher
				+ "\nSố trang: " + no + "\n====\nTrạng thái: " + status + "\nTổng số bản: " + total + "\nSẵn có: "
				+ available + "\nĐã mượn: " + (total - available);
	}

}
