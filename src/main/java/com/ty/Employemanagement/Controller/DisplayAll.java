package com.ty.Employemanagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ty.Employemanagement.Entity.Employe;
import com.ty.Employemanagement.service.EmpService;

@WebServlet(value = "/displays")
public class DisplayAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService = new EmpService();
        List<Employe> emps = empService.fetchAll();
        PrintWriter pr = resp.getWriter();

        pr.print("<!DOCTYPE html>\r\n"
                + "<html lang=\"en\">\r\n"
                + "<head>\r\n"
                + "    <meta charset=\"UTF-8\">\r\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "    <title>Employee Table</title>\r\n"
                + "    <style>\r\n"
                + "        body {\r\n"
                + "            font-family: 'Roboto', sans-serif;\r\n"
                + "            background-image: url('images/welcom2pic.jpg');\r\n"
                + "            margin: 0;\r\n"
                + "            padding: 0;\r\n"
                + "        }\r\n"
                + "        .container {\r\n"
                + "            background-color: rgba(255, 255, 255, 0.5);\r\n"
                + "            padding: 30px;\r\n"
                + "            border-radius: 12px;\r\n"
                + "            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);\r\n"
                + "            width: 80%;\r\n"
                + "            max-width: 1200px;\r\n"
                + "            margin: 100px auto 0; /* Adjusted for navbar */\r\n"
                + "        }\r\n"
                + "        table {\r\n"
                + "            width: 100%;\r\n"
                + "            border-collapse: collapse;\r\n"
                + "            margin-top: 20px;\r\n"
                + "        }\r\n"
                + "        th, td {\r\n"
                + "            padding: 12px 20px;\r\n"
                + "            text-align: left;\r\n"
                + "            border-bottom: 1px solid #ddd;\r\n"
                + "        }\r\n"
                + "        th {\r\n"
                + "            background-color: #3b82f6;\r\n"
                + "            color: white;\r\n"
                + "        }\r\n"
                + "        tr:hover {\r\n"
                + "            background-color: #f1f5fb;\r\n"
                + "        }\r\n"
                + "        .action-link {\r\n"
                + "            text-decoration: none;\r\n"
                + "            padding: 8px 12px;\r\n"
                + "            color: white;\r\n"
                + "            border-radius: 5px;\r\n"
                + "            transition: background-color 0.3s ease, transform 0.3s ease;\r\n"
                + "        }\r\n"
                + "        .link-edit {\r\n"
                + "            background-color: #2980B9;\r\n"
                + "        }\r\n"
                + "        .link-edit:hover {\r\n"
                + "            background-color:#1C5983 ;\r\n"
                + "            transform: scale(1.05);\r\n"
                + "        }\r\n"
                + "        .link-delete {\r\n"
                + "            background-color: #f44336;\r\n"
                + "        }\r\n"
                + "        .link-delete:hover {\r\n"
                + "            background-color: #e53935;\r\n"
                + "            transform: scale(1.05);\r\n"
                + "        }\r\n"
                + "        .navbar {\r\n"
                + "            background-color: #2C3E50;\r\n"
                + "            padding: 15px 30px;\r\n"
                + "            display: flex;\r\n"
                + "            justify-content: space-between;\r\n"
                + "            align-items: center;\r\n"
                + "            color: white;\r\n"
                + "            font-size: 20px;\r\n"
                + "            width: 100%;\r\n"
                + "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n"
                + "            position: fixed;\r\n"
                + "            top: 0;\r\n"
                + "            left: 0;\r\n"
                + "            z-index: 10;\r\n"
                + "        }\r\n"
                + "        .navbar h1 {\r\n"
                + "            margin: 0;\r\n"
                + "            font-weight: 500;\r\n"
                + "        }\r\n"
                + "        .right-buttons {\r\n"
                + "            display: flex;\r\n"
                + "            justify-content: flex-end;\r\n"
                + "            margin-right: 40px;\r\n"
                + "        }\r\n"
                + "        .right-buttons a {\r\n"
                + "            margin-right: 20px;\r\n"
                + "        }\r\n"
                + "        .right-buttons button {\r\n"
                + "            background-color: #2980B9;\r\n"
                + "            color: white;\r\n"
                + "            padding: 10px 20px;\r\n"
                + "            border: none;\r\n"
                + "            border-radius: 5px;\r\n"
                + "            font-size: 16px;\r\n"
                + "            cursor: pointer;\r\n"
                + "            transition: background-color 0.3s, transform 0.3s ease-in-out;\r\n"
                + "        }\r\n"
                + "        .right-buttons button:hover {\r\n"
                + "            background-color: #1C5983;\r\n"
                + "            transform: scale(1.05);\r\n"
                + "        }\r\n"
                + "    </style>\r\n"
                + "</head>\r\n"
                + "<body>\r\n"
                + "    <div class=\"navbar\">\r\n"
                + "        <h1>HR Management</h1>\r\n"
                + "        <div class=\"right-buttons\">\r\n"
                + "            <a href=\"Welcome.html\">\r\n"
                + "                <button>Home</button>\r\n"
                + "            </a>\r\n"
                + "           <a href=\"add.html\">\r\n"
                + "                <button>Add</button>\r\n"
                + "            </a>\r\n"
                
                + "            <a href=\"editform.html\">\r\n"
                + "                <button>Edit</button>\r\n"
                + "            </a>\r\n"
                + "            <a href=\"deleteform.html\">\r\n"
                + "                <button>Delete</button>\r\n"
                + "            </a>\r\n"
               
                + "        </div>\r\n"
                + "    </div>\r\n"
                + "    <div class=\"container\">\r\n"
                + "        <h1 style=\"text-align: center; color: #333; font-size: 28px;\">Employee Details</h1>\r\n"
                + "        <table>\r\n"
                + "            <thead>\r\n"
                + "                <tr>\r\n"
                + "                    <th>ID</th>\r\n"
                + "                    <th>Name</th>\r\n"
                + "                    <th>Age</th>\r\n"
                + "                    <th>Email</th>\r\n"
                + "                    <th>Salary</th>\r\n"
                + "                    <th>Actions</th>\r\n"
                + "                </tr>\r\n"
                + "            </thead>\r\n"
                + "            <tbody>");

        for (Employe employe : emps) {
            int id = employe.getId();
            String name = employe.getName();
            int age = employe.getAge();
            String emailid = employe.getEmailid();
            int salary = employe.getSalary();

            pr.print("<tr>\r\n"
                    + "    <td>" + id + "</td>\r\n"
                    + "    <td>" + name + "</td>\r\n"
                    + "    <td>" + age + "</td>\r\n"
                    + "    <td>" + emailid + "</td>\r\n"
                    + "    <td>" + salary + "</td>\r\n"
                    + "    <td>\r\n"
                    + "        <a class=\"action-link link-edit\" href='editform.html?id=" + id + "'>Edit</a>\r\n"
                    + "        <a class=\"action-link link-delete\" href='deleteform.html'>Delete</a>\r\n"
                    + "    </td>\r\n"
                    + "</tr>");
        }
        pr.print("            </tbody>\r\n"
                + "        </table>\r\n"
                + "    </div>\r\n"
                + "</body>\r\n"
                + "</html>");
    }
}
