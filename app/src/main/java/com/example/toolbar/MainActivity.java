package com.example.toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Toolbar customToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        customToolBar = findViewById(R.id.customToolBar);

        // step 1 set this tool bar as an action bar
        setSupportActionBar(customToolBar);

        // step 2 customization
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // this enable the back button on the activity.
            getSupportActionBar().setTitle("Company Name"); // this has higher priority than toolbar so it will reflect
        }

        customToolBar.setTitle("Company Name");
        customToolBar.setSubtitle("this is subtitle");
    }

    // step 3 setting option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // step 4 set onClick on menu items
    // the back button is also a menu item called as a home button (android.R.id.home)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        
        if(itemId==R.id.opt_new)
            Toast.makeText(this, "Created New File", Toast.LENGTH_SHORT).show();
        else if (itemId==R.id.opt_open)
            Toast.makeText(this, "File Opened", Toast.LENGTH_SHORT).show();
        else if(itemId==R.id.opt_save)
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
        else
            super.onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}