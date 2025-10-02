package vn.iostar.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import vn.iostar.entity.User;

public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                if (uri.startsWith("/admin") && !"ADMIN".equalsIgnoreCase(user.getRole())) {
                    response.sendRedirect("/login");
                    return false;
                }
                if (uri.startsWith("/user") && !"USER".equalsIgnoreCase(user.getRole())) {
                    response.sendRedirect("/login");
                    return false;
                }
                return true;
            }
        }
        if (uri.startsWith("/admin") || uri.startsWith("/user")) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}