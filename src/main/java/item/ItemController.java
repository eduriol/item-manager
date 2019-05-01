package item;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    private final List<Item> itemRepository;

    public ItemController() throws IOException {
        this.itemRepository = new ArrayList<>();
        //set up some example items
        this.itemRepository.add(Item.fromFile("src/main/resources/item1.json"));
        this.itemRepository.add(Item.fromFile("src/main/resources/item2.json"));
        this.itemRepository.add(Item.fromFile("src/main/resources/item3.json"));
        this.itemRepository.add(Item.fromFile("src/main/resources/item4.json"));
        this.itemRepository.add(Item.fromFile("src/main/resources/item5.json"));
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepository;
    }

    @PostMapping("/item")
    public void addItem(@RequestBody Item newItem) {
        itemRepository.add(newItem);
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

    @PutMapping("/item/{id}")
    public void replaceItem(@RequestBody Item newItem, @PathVariable Long id) {
        for (Item item : itemRepository) {
            if (item.getId().equals(id)) {
                itemRepository.remove(item);
                itemRepository.add(newItem);
                break;
            }
        }
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable Long id){
            for (Item item : itemRepository) {
                if (item.getId().equals(id)) {
                    itemRepository.remove(item);
                    break;
                }
            }
        }

}
