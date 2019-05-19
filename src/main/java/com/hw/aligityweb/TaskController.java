package com.hw.aligityweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class TaskController {
    private List<Task> list = new ArrayList<>();
    public TaskController() {
        this.list = initTasks();
    }

    @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    public List<Task> getAllTasksByGet(){
        return list;
    }

    @RequestMapping(value = "/tasks",method = RequestMethod.POST)
    public List<Task> addTaskByPost(HttpServletRequest request , HttpServletResponse response)throws ParseException{
        int id = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        String time = request.getParameter("createdTime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(time);
        Task task = new Task(id,content,date);
        list.add(task);
        return  list;
    }


    private List<Task> initTasks() {
        for (int i = 1; i <= 4; i++) {
            Task task = new Task();
            task.setId(i);
            task.setContent("Restful API homework" + i);
            task.setCreatedTime(new Date());
            list.add(task);
        }
        return list;
    }
}
