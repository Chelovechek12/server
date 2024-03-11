package bip.online.biplio2023.Controller;
import bip.online.biplio2023.entity.GenreEntity;

import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/genre")
@AllArgsConstructor
public class GenreController {
    private final GenreService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<GenreEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<GenreEntity>(true, "Список жанров", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<GenreEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Найден следующий жанр", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<GenreEntity>> save(@RequestBody GenreEntity author) {
        return ResponseEntity.ok(
                new DataResponse<GenreEntity>(true, "Жанр сохранен", service.save(author)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody GenreEntity genre) {
        service.update(genre);
        return ResponseEntity.ok(
                new BaseResponse(true, "Жанр сохранен"));
    }
}
