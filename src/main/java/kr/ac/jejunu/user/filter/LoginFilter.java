package kr.ac.jejunu.user.filter;

import kr.ac.jejunu.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {
    private String[] permission={"/","/login","/signup","/css/*","/logout"};
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        String requestURI = request1.getRequestURI();
        log.info("로그인 필터 실행");
        try {
            if (check(requestURI) == true){
                HttpSession session = request1.getSession(false);
                User member = (User) session.getAttribute("member");
                if (member == null){
                    response1.sendRedirect("/");
                    return;
                }
            }
        }
        catch (NullPointerException e){
            response1.sendRedirect("/");
            log.info("비정상 흐름");
            return;
        }
        log.info("정상흐름");
        chain.doFilter(request1,response1);
    }

    private boolean check(String requestURI) {
        return !PatternMatchUtils.simpleMatch(permission, requestURI);
    }
}
