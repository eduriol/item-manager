package item;

import item.entities.Item;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    private List<Item> itemRepository;

    public ItemController() throws IOException {
        this.itemRepository = new ArrayList<>();
        //set up some example items
        for (int i = 1; i <= 5; i++) {
            this.itemRepository.add(Item.fromFile("src/main/resources/item" + i + ".json"));
        }
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepository;
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable Long id) {
        for (Item item: itemRepository) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @PostMapping("/item")
    public void addItem(@RequestBody Item newItem) {
        for (Item item: itemRepository) {
            if (item.getId().equals(newItem.getId())) {
                throw new IllegalArgumentException("Item id already in use.");
            }
        }
        itemRepository.add(newItem);
    }

}
