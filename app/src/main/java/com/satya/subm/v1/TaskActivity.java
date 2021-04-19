package com.satya.subm.v1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.satya.subm.v1.databinding.ActivityTaskBinding;
import com.satya.subm.v1.model.DataSources;
import com.satya.subm.v1.model.Task;

public class TaskActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActivityTaskBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_task);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_task);
        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int position = getIntent().getIntExtra("TASK_POSITION", 0);
        Task task = DataSources.getTaskList().get(position);
        binding.setTask(task);




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuItem home = menu.findItem(android.R.id.home);


        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}