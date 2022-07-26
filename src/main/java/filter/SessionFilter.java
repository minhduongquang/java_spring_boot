package filter;

import com.example.tp1.constant.SessionConstant;
import com.example.tp1.dto.CartDto;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain)
    throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        // Kiểm tra session có giỏ hàng chưa
        validateCart(session);
        // Cấp quyền đi tiếp
        chain.doFilter(httpRequest, reponse);
        // Đi tiếp xuống Controller
    }

    private void validateCart(HttpSession session){
        if (ObjectUtils.isEmpty(session.getAttribute(SessionConstant.CURRENT_CART))){
            session.setAttribute(SessionConstant.CURRENT_CART, new CartDto());
        }
    }
}
