package bip.online.biplio2023.Controller;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.response.BaseResponse;
import bip.online.biplio2023.response.DataResponse;
import bip.online.biplio2023.response.ListResponse;
import bip.online.biplio2023.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(
                new ListResponse<AuthorEntity>(true, "Список аvторов", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<AuthorEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody AuthorEntity author) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<AuthorEntity>(true, "Автор сохранен", service.save(author)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }


    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity author) {
        try {
            service.update(author);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Автор сохранен"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id ){
        try{
            return ResponseEntity.ok(
                    new BaseResponse(true,"Автор удалён"));
        }catch (RuntimeException e){
            return ResponseEntity.ok(
                    new BaseResponse(false,e.getMessage()));
        }
    }
}