package bip.online.biplio2023.Controller;
import bip.online.biplio2023.entity.PublisherEntity;

import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/publisher")
@AllArgsConstructor
public class PublisherController {
    private final PublisherService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<PublisherEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<PublisherEntity>(true, "Список издательство", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<PublisherEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Найдено следующее издательство", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<PublisherEntity>> save(@RequestBody PublisherEntity publisher) {
        return ResponseEntity.ok(
                new DataResponse<PublisherEntity>(true, "Издательство сохранено", service.save(publisher)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity publisher) {
        service.update(publisher);
        return ResponseEntity.ok(
                new BaseResponse(true, "Издательство сохранено"));
    }
}
