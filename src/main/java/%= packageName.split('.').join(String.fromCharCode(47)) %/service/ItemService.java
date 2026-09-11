package <%= packageName %>.service;

import <%= packageName %>.common.ResourceNotFoundException;
import <%= packageName %>.model.Item;
import <%= packageName %>.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Item 业务逻辑层。
 */
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> list() {
        return itemRepository.findAll();
    }

    public Item get(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item " + id + " 不存在"));
    }

    public Item create(Item item) {
        item.setId(null);
        return itemRepository.save(item);
    }

    public Item update(Long id, Item item) {
        Item existing = get(id);
        existing.setName(item.getName());
        return itemRepository.save(existing);
    }

    public void delete(Long id) {
        if (!itemRepository.deleteById(id)) {
            throw new ResourceNotFoundException("Item " + id + " 不存在");
        }
    }
}
