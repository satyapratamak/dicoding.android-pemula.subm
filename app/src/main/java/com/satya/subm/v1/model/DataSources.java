package com.satya.subm.v1.model;

import java.util.ArrayList;
import java.util.List;

public class DataSources {

    private static List<Task> taskList;

    public static void init(){
        taskList = new ArrayList<>();
         for (int i = 1; i <= 20; i++){
             if (i % 3 == 1){
                 taskList.add(new Task(
                         i, "Tugas "+i, "Mengerjakan Tugas "+i, TaskPriority.HIGH
                 ));
             }else if (i % 3 == 2){
                 taskList.add(new Task(
                         i, "Tugas "+i, "Mengerjakan Tugas "+i, TaskPriority.COMMON
                 ));
             }else{
                 taskList.add(new Task(
                         i, "Tugas "+i, "Mengerjakan Tugas "+i, TaskPriority.LOW
                 ));
             }

         }

    }

    public static List<Task> getTaskList() {
        return taskList;
    }

    public static List<Task> getTaskList(TaskStatus status) {
        List<Task> list = new ArrayList<>();

        for (Task task : taskList){
            if (task.getStatus() == status){
                list.add(task);
            }
        }
        return list;
    }

    public static List<Task> getTaskList(TaskPriority priority) {
        List<Task> list = new ArrayList<>();

        for (Task task : taskList){
            if (task.getPriority() == priority){
                list.add(task);
            }
        }
        return list;
    }


}
