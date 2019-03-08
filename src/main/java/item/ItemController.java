package item;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
class ItemController {

    private final List<Item> repository;

    public ItemController() throws IOException {
        this.repository = new ArrayList<>();
        //set up some example items
        this.repository.add(Item.fromFile("src/main/resources/item1.json"));
        this.repository.add(Item.fromFile("src/main/resources/item2.json"));
        this.repository.add(Item.fromFile("src/main/resources/item3.json"));
        this.repository.add(Item.fromFile("src/main/resources/item4.json"));
        this.repository.add(Item.fromFile("src/main/resources/item5.json"));
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/items")
    List<Item> getAllItems() {
        return repository;
    }

    @PostMapping("/item")
    void addBuyer(@RequestBody Item newItem) {
        repository.add(newItem);
    }

    @GetMapping("/item/{id}")
    Item getItem(@PathVariable Long id) {
        for (Item item: repository) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @PutMapping("/item/{id}")
    void replaceItem(@RequestBody Item newItem, @PathVariable Long id) {
        for (Item item : repository) {
            if (item.getId().equals(id)) {
                item = newItem;
            }
        }
    }

    @DeleteMapping("/item/{id}")
    void deleteItem(@PathVariable Long id){
            for (Item item : repository) {
                if (item.getId().equals(id)) {
                    repository.remove(item);
                }
            }
        }

}
