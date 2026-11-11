package <%= packageName %>.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

/**
 * Example domain model.
 */
public class Item {

    private Long id;

    @NotBlank(message = "must not be blank")
    private String name;

    private LocalDateTime createdAt;

    public Item() {
    }

    public Item(Long id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
