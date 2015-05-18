package ee.kirill.foodlistactivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ee.kirill.foodlistfromxml.R;


public class FoodInfo extends Activity {
    private static final String TAG = "FoodInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_info);
        String foodId = getIntent().getStringExtra(Food.PREF_FOOD_ID);
        Log.v(TAG, "id" + foodId);

        TextView foodInfoName = (TextView) findViewById(R.id.foodInfoName);
        TextView foodInfoPrice = (TextView) findViewById(R.id.foodInfoPrice);
        TextView foodInfoCalories = (TextView) findViewById(R.id.foodInfoCalories);
        TextView foodInfoDesc = (TextView) findViewById(R.id.foodInfoDesc);

        Resources resources = getResources();
        Food food = HandleFoodXML.getFoodById(resources, foodId);
        if (food != null) {
            foodInfoName.setText(food.getName());
            foodInfoPrice.setText(food.getPrice());
            foodInfoCalories.setText(food.getCalories());
            foodInfoDesc.setText(food.getDescription());
        }
    }
}
