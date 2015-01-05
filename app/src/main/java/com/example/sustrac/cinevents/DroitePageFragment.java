package com.example.sustrac.cinevents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Page Droite
 */
public class DroitePageFragment  extends Fragment {
    private View v;
    ListView listView ;
    ArrayAdapter ladapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.droite, container, false);


        super.onCreate(savedInstanceState);

        // Get ListView object from xml
        listView = (ListView) v.findViewById(R.id.listViewDroite);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Cine0",
                "Cine1",
                "Cine2",
                "Cine3",
                "Cine4",
                "Cine5",
                "Cine6",
                "Cine7",
                "Cine8",
                "Cine9",
                "Cine10",
                "Cine11",
                "Cine12",
                "Cine13",
                "Cine14",
                "Cine15",
                "Cine16",
                "Cine17",
                "Cine18",
                "Cine19",

        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

            }

        });

        return v;
    }
}
