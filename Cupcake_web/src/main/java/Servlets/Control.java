package Servlets;

import Datbase.DataMapper;
import Datbase.DataSource;
import Datbase.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author The Overlord
 */
@WebServlet(name = "Control", urlPatterns = { "/Control" })
public class Control extends HttpServlet
{
    DataMapper dm;

    /**
     *laver et nyt object med DataMapper
     */
    public Control()
    {
        dm = new DataMapper(new DataSource().getDataSource());
    }
    
    /**
     *
     * @param request
     * sender request til servlet
     * @param response
     * retuner respone
     * @throws ServletException
     * kaster SevletException
     * @throws IOException
     * kaster IOException
     * der køre response med setContentType
     * herefter er der en switch case med login, search, create, update, delete og med break til sidst
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        switch(request.getParameter("origin"))
        {
            case "login":
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    User user = dm.validateUser(username, password);

                    request.getSession().setAttribute("user", user);

                    //request.getRequestDispatcher("user.jsp").forward(request, response);
                    response.sendRedirect("user.jsp");                

                }
                break;
            case "search":
                {
                    String username = request.getParameter("username");

                    ArrayList<User> users = dm.getUsers(username);

                    request.getSession().setAttribute("users", dm.getUsers(username));

                    response.sendRedirect("users.jsp");

                }
                break;
            case "create":
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
//                    boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

                    dm.createUser(new User(username, password));

                    response.sendRedirect("usercreated.jsp");

                }
                break;
            case "update":
                {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
//                    boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

                    User user = (User) request.getSession().getAttribute("user");

                    if (user != null)
                    {
                        user.setUsername(username);
                        user.setPassword(password);
                       

                        dm.updateUser(user);

                        response.sendRedirect("userupdated.jsp");
                    }                

                }
                break;
            case "delete":
                {
                    User user = (User) request.getSession().getAttribute("user");

                    if (user != null)
                    {
                        dm.deleteUser(user.getUsername());

                        response.sendRedirect("userdeleted.jsp");
                    }                

                }
                break;
        }
    }

    /**
     *
     * @param request
     * sender request til servlet
     * @param response
     * retuner respone
     * @throws ServletException
     * kaster SevletException
     * @throws IOException
     * kaster IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * sender request til servlet
     * @param response
     * retuner respone
     * @throws ServletException
     * kaster SevletException
     * @throws IOException
     * kaster IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     *
     * @return
     * retuner tekst
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}