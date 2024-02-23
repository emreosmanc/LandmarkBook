package com.emreosminho.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.emreosminho.landmarkbook.databinding.ActivityDetailsBinding;
import com.emreosminho.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        //Data
        Landmark pisa = new Landmark("Pisa", "Italy", R.drawable.pisa);
        Landmark eifell = new Landmark("Eifell", "France", R.drawable.eifell);
        Landmark colloseum = new Landmark("Colleseum", "Italy", R.drawable.collesium);
        Landmark londonBrindge = new Landmark("London Brindge", "UK", R.drawable.london);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eifell);
        landmarkArrayList.add(colloseum);
        landmarkArrayList.add(londonBrindge);

        //Adapter
        // Listview
        //Mapping
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));
                startActivity(intent);
            }
        });

    }
}