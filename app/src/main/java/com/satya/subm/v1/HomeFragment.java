package com.satya.subm.v1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.satya.subm.v1.adapter.TaskAdapter;
import com.satya.subm.v1.model.DataSources;
import com.satya.subm.v1.model.Task;
import com.satya.subm.v1.model.TaskStatus;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
        DataSources.init();
    }

    public static HomeFragment getInstance(){
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TaskAdapter adapter = new TaskAdapter(DataSources.getTaskList(TaskStatus.ACTIVE), this.listener);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private TaskAdapter.OnTaskItemListener listener = new TaskAdapter.OnTaskItemListener() {
        @Override
        public void onTaskItemClick(int position) {
            Task task = DataSources.getTaskList().get(position);
            Toast.makeText(getContext(), "Anda click task : "+ task.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), TaskActivity.class);
            intent.putExtra("TASK_POSITION", position);
            startActivity(intent);
        }
    };
}