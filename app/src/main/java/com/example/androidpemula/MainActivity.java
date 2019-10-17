package com.example.androidpemula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] nameData;
    String[] overviewData;
    TypedArray photoData;
    Adapter adapter;

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rv = findViewById(R.id.rpl);
        adapter = new Adapter(this);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new GridLayoutManager(this, 2));

        prepare();
        addItem();

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Items item = new Items();
                item.setImage(photoData.getResourceId(position, -1));
                item.setTitle(nameData[position]);
                item.setInfo(overviewData[position]);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("data",  item);
                startActivity(intent);
            }
        });
    }
    public void prepare (){
        nameData = getResources().getStringArray(R.array.name);
        overviewData = getResources().getStringArray(R.array.addres);
        photoData = getResources().obtainTypedArray(R.array.image);
    }
    private void addItem() {
        ArrayList<Items> items = new ArrayList<>();

        for (int i = 0; i < nameData.length; i++) {
            Items club = new Items();
            club.setImage(photoData.getResourceId(i, -1));
            club.setTitle(nameData[i]);
            club.setInfo(overviewData[i]);
            items.add(club);
        }

        adapter.setMovieItems(items);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_change_settings) {
            startActivity(new Intent(MainActivity.this,profile.class));

        }
        return super.onOptionsItemSelected(item);
    }
}
