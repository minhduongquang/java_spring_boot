package com.example.tp1.util;

import com.example.tp1.constant.SessionConstant;
import com.example.tp1.dto.CartDto;
import com.example.tp1.entity.Users;

import javax.servlet.http.HttpSession;

public class SessionUtil {


        private SessionUtil() {}

        public static CartDto getCurrentCart(HttpSession session) {
            return (CartDto) session.getAttribute(SessionConstant.CURRENT_CART);
        }

        public static Users getCurrentUser(HttpSession session) {
            return (Users) session.getAttribute(SessionConstant.CURRENT_USER);
        }
}
