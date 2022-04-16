package pl.zgora.uz.lab6.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.zgora.uz.lab6.dto.BookDto;
import pl.zgora.uz.lab6.entity.BookEntity;
import pl.zgora.uz.lab6.repository.BookRepository;

@Service
public class BookService implements pl.zgora.uz.lab6.interfaces.Service<BookDto, BookEntity> {

	@Autowired
	private BookRepository repository;

	@Override
	public List<BookDto> find() {
		List<BookEntity> allBooksEntity = repository.findAll();
		List<BookDto> allBooksDto = new ArrayList<>();
		for (BookEntity entity : allBooksEntity) {
			BookDto dto = new BookDto();
			assignEntityToDto(entity, dto);
			allBooksDto.add(dto);
		}
		return allBooksDto;
	}

	@Override
	public BookDto find(Long id) {
		Optional<BookEntity> entity = repository.findById(id);
		BookDto dto = new BookDto();
		assignEntityToDto(entity.get(), dto);
		return dto;
	}

	@Override
	public Long save(BookDto dto) {
		BookEntity entity = new BookEntity();
		assignDtoToEntity(dto, entity);
		repository.save(entity);
		return entity.getId();
	}

	@Override
	public Long update(BookDto dto) {

		Optional<BookEntity> entity = repository.findById(dto.id);

		assignDtoToEntity(dto, entity.get());

		entity.get().setId(dto.id);

		repository.saveAndFlush(entity.get());

		return dto.id;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void assignEntityToDto(BookEntity entity, BookDto dto) {

		dto.id = entity.getId();
		dto.title = entity.getTitle();
		dto.author = entity.getAuthor();
		dto.numberOfPages = entity.getNumberOfPages();
	}

	@Override
	public void assignDtoToEntity(BookDto dto, BookEntity entity) {

		entity.setTitle(dto.title);
		entity.setAddedDate(LocalDate.now());
		entity.setAuthor(dto.author);
		entity.setNumberOfPages(dto.numberOfPages);

	}

}
