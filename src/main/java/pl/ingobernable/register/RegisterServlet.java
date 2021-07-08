package pl.ingobernable.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private final RegisterService registerService;

    RegisterServlet(){
        this(new RegisterService(new RegisterRepository()));
    }

    public RegisterServlet(RegisterService registerService) {
        this.registerService = registerService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String email = req.getParameter("email");
        String passwordInput = req.getParameter("passwordInput");
        String passwordConfirm = req.getParameter("passwordConfirm");

        registerService.registerUser(email, passwordInput, passwordConfirm);

        this.getServletContext().getRequestDispatcher("register_complete.html").forward(req, resp);
    }


}
