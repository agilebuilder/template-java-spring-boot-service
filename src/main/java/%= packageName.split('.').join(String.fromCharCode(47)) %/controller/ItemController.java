package <%= packageName %>.controller;

import <%= packageName %>.common.ApiResponse;
import <%= packageName %>.model.Item;
import <%= packageName %>.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Item 示例 CRUD 端点。
 */
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ApiResponse<List<Item>> list() {
        return ApiResponse.success(itemService.list());
    }

    @GetMapping("/{id}")
    public ApiResponse<Item> get(@PathVariable Long id) {
        return ApiResponse.success(itemService.get(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Item> create(@Valid @RequestBody Item item) {
        return ApiResponse.success(itemService.create(item));
    }

    @PutMapping("/{id}")
    public ApiResponse<Item> update(@PathVariable Long id, @Valid @RequestBody Item item) {
        return ApiResponse.success(itemService.update(id, item));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        itemService.delete(id);
        return ApiResponse.success(null);
    }
}
