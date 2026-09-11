package <%= packageName %>.repository;

import <%= packageName %>.model.Item;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 示例数据访问层：内存实现。接入真实数据库时可替换为 Spring Data JPA / MyBatis 实现。
 */
@Repository
public class ItemRepository {

    private final ConcurrentMap<Long, Item> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(idGenerator.incrementAndGet());
            item.setCreatedAt(LocalDateTime.now());
        }
        store.put(item.getId(), item);
        return item;
    }

    public boolean deleteById(Long id) {
        return store.remove(id) != null;
    }
}
