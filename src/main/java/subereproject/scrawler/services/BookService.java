package subereproject.scrawler.services;

import java.util.List;
import java.util.Optional;

import subereproject.scrawler.models.Book;

public interface BookService {

	void deleteAll();

	void deleteAll(List<Book> entities);

	void delete(Book entity);

	void deleteById(Integer id);

	long count();

	List<Book> findAllById(List<Integer> ids);

	List<Book> findAll();

	boolean existsById(Integer id);

	Optional<Book> findById(Integer id);

	List<Book> saveAll(List<Book> entities);

	Book save(Book entity);

}