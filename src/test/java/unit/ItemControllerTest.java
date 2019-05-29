package unit;

import item.entities.Item;
import item.ItemController;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ItemControllerTest {

    private ItemController itemController;

    @Before
    public void setUp() throws IOException {
        itemController = new ItemController();
    }

    @Test
    public void testGetAllItemsFirstItem() throws IOException {
        assertThat(itemController.getAllItems().get(0), is(equalTo(Item.fromFile("src/main/resources/item1.json"))));
    }

    @Test
    public void testGetItemById() throws IOException {
        assertThat(itemController.getItem(1L), is(equalTo(Item.fromFile("src/main/resources/item1.json"))));
    }

    @Test
    public void testGetItemByInexistentId() {
        assertThat(itemController.getItem(0L), is(nullValue()));
    }

    @Test
    public void testAddItemDistinctId() throws IOException {
        itemController.addItem(Item.fromFile("src/test/resources/item6.json"));
        assertThat(itemController.getItem(6L), is(equalTo(Item.fromFile("src/test/resources/item6.json"))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemExistingId() throws IOException {
        itemController.addItem(Item.fromFile("src/main/resources/item1.json"));
    }

}
