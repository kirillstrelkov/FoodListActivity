package ee.kirill.foodlistactivity;

import android.content.res.Resources;
import android.util.Log;

import com.ee.kirill.foodlistfromxml.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

public class HandleFoodXML {
    private static final String TAG = "HandleFoodXML";

    public static Food getFoodById(Resources resources, String foodId) {
        Food food = null;
        try {
            XmlPullParser foodsParser = resources.getXml(R.xml.foods);

            String name = "";
            String id = "";
            String price = "";
            String desc = "";

            int eventType = foodsParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = foodsParser.getName();
                if (eventType == XmlPullParser.START_TAG) {
                    switch (tagName) {
                        case "name":
                            id = foodsParser.getAttributeValue(null, "food_id");
                            foodsParser.next();
                            name = foodsParser.getText();
                            break;
                        case "price":
                            foodsParser.next();
                            price = foodsParser.getText();
                            break;
                        case "description":
                            foodsParser.next();
                            desc = foodsParser.getText();
                            break;
                        case "calories":
                            foodsParser.next();
                            String calories = foodsParser.getText();
                            if (foodId.equals(id)) {
                                food = new Food(id, name, price, calories, desc);
                                return food;
                            }
                            break;
                    }
                }
                eventType = foodsParser.next();
            }
        } catch (Throwable t) {
            Log.v(TAG, "Error XML-file loading: " + t.toString());
        }
        return food;
    }

    public static List<Food> getListOfFood(Resources resources) {
        List<Food> foodsList = new ArrayList<>();

        String name = "";
        String id = "";
        String price = "";

        try {
            XmlPullParser foodsParser = resources.getXml(R.xml.foods);
            int eventType = foodsParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = foodsParser.getName();
                if (eventType == XmlPullParser.START_TAG) {
                    switch (tagName) {
                        case "name":
                            id = foodsParser.getAttributeValue(null, "food_id");
                            foodsParser.next();
                            name = foodsParser.getText();
                            break;
                        case "price":
                            foodsParser.next();
                            price = foodsParser.getText();
                            break;
                        case "calories":
                            foodsParser.next();
                            String calories = foodsParser.getText();
                            foodsList.add(new Food(id, name, price, calories));
                            break;
                    }
                }
                eventType = foodsParser.next();
            }
        } catch (Throwable t) {
            Log.v(TAG, "Error XML-file loading: " + t.toString());
        }

        return foodsList;
    }
}
