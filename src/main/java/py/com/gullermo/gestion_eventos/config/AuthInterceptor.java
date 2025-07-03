package py.com.gullermo.gestion_eventos.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();


        if (uri.equals("/") || uri.startsWith("/login") || uri.startsWith("/css") || uri.startsWith("/js")) {
            return true;
        }

        if (session != null && session.getAttribute("usuarioLogueado") != null) {
            return true;
        }


        response.sendRedirect("/");
        return false;
    }
}
