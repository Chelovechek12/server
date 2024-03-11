package bip.online.biplio2023.Controller; import bip.online.biplio2023.entity.BookEntity;

import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;


@RestController
@RequestMapping("api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<BookEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<BookEntity>(true, "Список Книг", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<BookEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Найдена следующая Книга", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<BookEntity>> save(@RequestBody BookEntity books) {
        return ResponseEntity.ok(
                new DataResponse<BookEntity>(true, "Книга сохранен", service.save(books)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity books) {
        service.update(books);
        return ResponseEntity.ok(
                new BaseResponse(true, "Книга сохранена"));
    }
    @GetMapping
    public
}