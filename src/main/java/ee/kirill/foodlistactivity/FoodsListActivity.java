package ee.kirill.foodlistactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.ee.kirill.foodlistfromxml.R;

import java.util.List;

public class FoodsListActivity extends ListActivity {
    private static final String TAG = "FoodsListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final List<Food> foodsList = HandleFoodXML.getListOfFood(getResources());

        String[] from = new String[]{Food.NAME, Food.PRICE, Food.CALORIES};
        int[] to = new int[]{R.id.itemName, R.id.itemPrice, R.id.itemCalories};

        setListAdapter(new SimpleAdapter(this, foodsList, R.layout.list_item, from, to));
        final FoodsListActivity activity = this;
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Toast.makeText(getApplicationContext(), "Был выбран пункт " + position,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, FoodInfo.class);

                Log.v(TAG, "id" + foodsList.get(position).getId());
                intent.putExtra(Food.PREF_FOOD_ID, foodsList.get(position).getId());

                startActivity(intent);

            }
        };
        getListView().setOnItemClickListener(itemListener);
    }

}