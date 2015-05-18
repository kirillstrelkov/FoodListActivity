package ee.kirill.foodlistactivity;

import java.util.HashMap;

public class Food extends HashMap<String, String> {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String CALORIES = "calories";
    public static final String DESC = "desc";

    public static final String PREF_FOOD_ID = "foodId";

    public Food(String id, String name, String price, String calories) {
        put(ID, id);
        put(NAME, name);
        put(PRICE, price);
        put(CALORIES, calories);
    }

    public Food(String id, String name, String price, String calories, String desc) {
        put(ID, id);
        put(NAME, name);
        put(PRICE, price);
        put(CALORIES, calories);
        put(DESC, desc);
    }

    public String getId() {
        return get(ID);
    }

    public String getName() {
        return get(NAME);
    }

    public String getCalories() {
        return get(CALORIES);
    }

    public String getPrice() {
        return get(PRICE);
    }

    public String getDescription() {
        return get(DESC);
    }
}
