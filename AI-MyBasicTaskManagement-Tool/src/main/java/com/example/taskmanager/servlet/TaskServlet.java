package com.example.taskmanager.servlet;

import com.example.taskmanager.model.Task;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TaskServlet acts as the main controller for our simple task manager application.
 * It handles HTTP GET requests (to display tasks) and HTTP POST requests (to add new tasks or mark them completed).
 *
 * The @WebServlet annotation automatically registers this servlet with the specified URL pattern.
 * For Servlet 3.0+ containers (like Tomcat 7+), this replaces the need for web.xml entries.
 */
@WebServlet("/tasks") // This servlet will respond to requests made to /tasks
public class TaskServlet extends HttpServlet {

    // A simple in-memory list to store our tasks.
    // In a real application, this would be replaced by a database (e.g., JDBC, JPA, Hibernate).
    // Using 'static' makes it a singleton for the application, so all users share the same list.
    // For a multi-user app, you'd manage tasks per session or per user in a DB.
    private static final List<Task> tasks = new ArrayList<>();

    // Initialize with some dummy data for testing
    static {
        tasks.add(new Task("Learn Java Servlets"));
        tasks.add(new Task("Build a portfolio website"));
        tasks.add(new Task("Understand HTTP methods"));
        tasks.get(0).setCompleted(true); // Mark the first task as completed
    }

    /**
     * Handles HTTP GET requests.
     * When a user navigates to /tasks, this method is called.
     * It retrieves the current list of tasks and forwards them to the JSP for display.
     *
     * @param request  The HttpServletRequest object that contains the request the client made.
     * @param response The HttpServletResponse object that contains the response the servlet sends to the client.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException      If an I/O error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the list of tasks as an attribute in the request scope.
        // This makes the 'tasks' list available to the JSP page.
        request.setAttribute("tasks", tasks);

        // Get a RequestDispatcher to forward the request to our JSP page.
        // The path is relative to the webapp directory.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

        // Forward the request and response to the JSP.
        // The JSP will then render the HTML using the 'tasks' data.
        dispatcher.forward(request, response);
    }

    /**
     * Handles HTTP POST requests.
     * This method is typically used for submitting forms, like adding a new task or marking one complete.
     *
     * @param request  The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException If a servlet-specific error occurs.
     * @throws IOException      If an I/O error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the value of the 'action' parameter from the form.
        // This allows us to handle different POST operations (e.g., add, complete)
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Handle adding a new task
            String description = request.getParameter("description");
            if (description != null && !description.trim().isEmpty()) {
                tasks.add(new Task(description.trim()));
            }
        } else if ("complete".equals(action)) {
            // Handle marking a task as complete
            String taskIndexStr = request.getParameter("taskIndex");
            try {
                int taskIndex = Integer.parseInt(taskIndexStr);
                if (taskIndex >= 0 && taskIndex < tasks.size()) {
                    tasks.get(taskIndex).setCompleted(true);
                }
            } catch (NumberFormatException e) {
                // Log the error or handle invalid index gracefully
                System.err.println("Invalid task index for completion: " + taskIndexStr);
            }
        }

        // After processing the POST request, redirect back to the GET /tasks URL.
        // This is a common pattern called "Post-Redirect-Get" (PRG) to prevent
        // duplicate form submissions if the user refreshes the page.
        response.sendRedirect(request.getContextPath() + "/tasks");
    }
}
