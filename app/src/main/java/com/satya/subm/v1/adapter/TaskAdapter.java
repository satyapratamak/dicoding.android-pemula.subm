package com.satya.subm.v1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.satya.subm.v1.R;
import com.satya.subm.v1.model.Task;

import java.text.SimpleDateFormat;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{

    private List<Task> taskList;
    private SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy H:mm");
    private OnTaskItemListener itemListener;

    public TaskAdapter(List<Task> taskList, OnTaskItemListener listener) {
        this.taskList = taskList;
        this.itemListener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskViewHolder holder = new TaskViewHolder(view, itemListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.textTaskInitial.setText(task.getTitle().substring(0,1));
        holder.textTaskTitle.setText(task.getTitle());
        holder.textTaskDesc.setText(task.getDesc());
        holder.textTaskStatus.setText(task.getStatus().toString());
        holder.textTaskDate.setText(df.format(task.getDate()));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textTaskInitial, textTaskTitle, textTaskDesc, textTaskStatus, textTaskDate;
        private OnTaskItemListener listener;

        public TaskViewHolder(@NonNull View itemView, OnTaskItemListener listener) {
            super(itemView);
            textTaskInitial = itemView.findViewById(R.id.task_initial);
            textTaskDesc = itemView.findViewById(R.id.task_description);
            textTaskTitle = itemView.findViewById(R.id.task_title);
            textTaskStatus = itemView.findViewById(R.id.task_status);
            textTaskDate = itemView.findViewById(R.id.task_date);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.listener.onTaskItemClick(getAdapterPosition());
        }
    }

    public interface OnTaskItemListener{
        void onTaskItemClick(int position);
    }
}
