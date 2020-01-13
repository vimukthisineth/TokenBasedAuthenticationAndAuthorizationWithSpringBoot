package com.prolific.software.foodappbackend.security;

import com.prolific.software.foodappbackend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader("Token");
        String path = httpServletRequest.getRequestURI();
        if ("/signup".equals(path) || "/login".equals(path)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            if (userAccountRepository.findByToken(token).size() == 0){
                ((HttpServletResponse) servletResponse).sendError(401);
            }else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
}
