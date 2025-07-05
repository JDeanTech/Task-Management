<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Basic Task Manager</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; }
        .container { max-width: 800px; margin: auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h1 { color: #333; text-align: center; }
        ul { list-style: none; padding: 0; }
        li { background: #e9e9e9; margin-bottom: 10px; padding: 10px; border-radius: 5px; display: flex; justify-content: space-between; align-items: center; }
        .completed { text-decoration: line-through; color: #888; }
        form { margin-top: 20px; padding: 15px; border: 1px solid #ddd; border-radius: 5px; background-color: #f9f9f9; }
        input[type="text"] { width: calc(100% - 100px); padding: 8px; margin-right: 10px; border: 1px solid #ccc; border-radius: 4px; }
        input[type="submit"] { padding: 8px 15px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #0056b3; }
        .complete-button { background-color: #28a745; }
        .complete-button:hover { background-color: #218838; }
    </style>
</head>
<body>
    <div class="container">
        <h1>My Basic Task Manager</h1>

        <h2>Add New Task</h2>
        <form action="${pageContext.request.contextPath}/tasks" method="POST">
            <input type="hidden" name="action" value="add"> <input type="text" name="description" placeholder="Enter new task description" required>
            <input type="submit" value="Add Task">
        </form>

        <h2>Current Tasks</h2>
        <c:choose>
            <c:when test="${not empty tasks}">
                <ul>
                    <c:forEach var="task" items="${tasks}" varStatus="loop">
                        <li>
                            <span class="${task.completed ? 'completed' : ''}">${loop.index + 1}. ${task.description}</span>
                            <c:if test="${!task.completed}">
                                <form action="${pageContext.request.contextPath}/tasks" method="POST" style="display:inline;">
                                    <input type="hidden" name="action" value="complete">
                                    <input type="hidden" name="taskIndex" value="${loop.index}">
                                    <input type="submit" value="Complete" class="complete-button">
                                </form>
                            </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <p>No tasks found. Add one above!</p>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>