package pl.zgora.uz.lab6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.zgora.uz.lab6.dto.BookDto;
import pl.zgora.uz.lab6.service.BookService;

@RestController
@RequestMapping("/books/")
public class BookController {

	@Autowired
	BookService service;

	@GetMapping("find/")
	public List<BookDto> find() {
		return service.find();

	}

	@GetMapping("find/{id}/")
	public BookDto getBook(@PathVariable Long id) {
		return service.find(id);
	}

	@PostMapping("save/")
	public String save(@RequestBody BookDto dto) {
		return "Saved successfull with id - " + service.save(dto);

	}

	@PostMapping("update/")
	public String update(@RequestBody BookDto dto) {
		return "Update successfull with id - " + service.update(dto);
	}

	@DeleteMapping("delete/{id}/")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "Delete successfull in row with id - " + id;
	}

}
