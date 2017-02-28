package mr_auspicious.shivam_kr_shiv.com.adapters1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {


    private Button mAscButton;
    private Button mDescButton;
    private ListView mNameListView;

    private List<String> stringList;
    private ArrayAdapter<String> stringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAscButton = (Button) findViewById(R.id.b1);
        mDescButton = (Button) findViewById(R.id.b2);
        mNameListView = (ListView) findViewById(R.id.list);

        //Adding the data into Array List
        stringList = new ArrayList<>();
        stringList.add("January");
        stringList.add("February");
        stringList.add("March");
        stringList.add("April");
        stringList.add("May");
        stringList.add("June");
        stringList.add("July");
        stringList.add("August");
        stringList.add("September");
        stringList.add("October");
        stringList.add("November");
        stringList.add("December");

        stringAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,stringList); //Initializing the Array Adapter
        mNameListView.setAdapter(stringAdapter); //Setting up the listview with our adpater..

        mAscButton.setOnClickListener(this);
        mDescButton.setOnClickListener(this);


    }

    // Comparator for Ascending Order
    public static Comparator<String> StringAscComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName1.compareToIgnoreCase(stringName2);
        }
    };

    //Comparator for Descending Order
    public static Comparator<String> StringDescComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName2.compareToIgnoreCase(stringName1);
        }
    };


    //Handling the click Events ..
    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.b1 :
                Collections.sort(stringList, StringAscComparator);
                Toast.makeText(MainActivity.this, "Sorting in Ascending Order", Toast.LENGTH_LONG).show();
                break;
            case R.id.b2 :
                Collections.sort(stringList, StringDescComparator);
                Toast.makeText(MainActivity.this, "Sorting in Descending Order", Toast.LENGTH_LONG).show();
                break;
        }
        stringAdapter.notifyDataSetChanged();

    }

}