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

        // Liste de String composant la listView(devrait etre rempli depuis les données récupéré depuis l'api d'allociné.
        String[] values = new String[] { "Film0",
                "Film1",
                "Film2",
                "Film3",
                "Film4",
                "Film5",
                "Film6",
                "Film7",
                "Film8",
                "Film9",
                "Film10",
                "Film11",
                "Film12",
                "Film13",
                "Film14",
                "Film15",
                "Film16",
                "Film17",
                "Film18",
                "Film19",

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
