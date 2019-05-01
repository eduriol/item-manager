import item.Item;
import item.ItemController;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ItemControllerTest {

    private ItemController itemController;

    @Before
    public void setUp() throws IOException {
        itemController = new ItemController();
    }

    @Test
    public void testGetAllItemsFirstItem() throws IOException {
        assertThat(itemController.getAllItems().get(0)).isEqualTo(Item.fromFile("src/main/resources/item1.json"));
    }

    @Test
    public void testGetItemById() throws IOException {
        assertThat(itemController.getItem(1L)).isEqualTo(Item.fromFile("src/main/resources/item1.json"));
    }

    @Test
    public void testGetItemByInexistentId() {
        assertThat(itemController.getItem(0L)).isNull();
    }

    @Test
    public void testAddItem() throws IOException {
        itemController.addItem(Item.fromFile("src/test/resources/item6.json"));
        assertThat(itemController.getItem(6L)).isEqualTo(Item.fromFile("src/test/resources/item6.json"));
    }

    @Test
    public void testReplaceItemWithSameId() throws IOException {
        Item newItem = Item.fromFile("src/test/resources/item5.json");
        itemController.replaceItem(newItem, 5L);
        assertThat(itemController.getItem(5L)).isEqualTo(newItem);
    }

    @Test
    public void testReplaceItemWithNonExistentId() throws IOException {
        Item newItem = Item.fromFile("src/test/resources/item5.json");
        itemController.replaceItem(newItem, 5L);
        assertThat(itemController.getItem(5L)).isEqualTo(newItem);
    }

    @Test
    public void testDeleteItem() {
        int previousSize = itemController.getAllItems().size();
        itemController.deleteItem(5L);
        assertThat(itemController.getItem(5L)).isNull();
        assertThat(itemController.getAllItems().size()).isEqualTo(previousSize - 1);
    }

}
