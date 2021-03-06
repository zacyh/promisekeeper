package service;

import dao.AppointmentDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import po.User;
import util.MyUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AppointmentDao appointmentDao;

    public String register(User user, Model model, HttpSession session) {
        List<User> list = userDao.isExist(user);
        if (list.size() > 0) {
            model.addAttribute("msg", "用户已存在！");
            return "register";
        }
        int n = userDao.register(user);
        if (n > 0) {
            model.addAttribute("msg", "注册成功！");
            return "login";
        } else {
            model.addAttribute("msg", "注册失败！");
            return "register";
        }
    }

    public String login(User user, Model model, HttpSession session) {
        User ruser = null;
        List<User> list = userDao.login(user);
        if (list.size() > 0) {
            ruser = list.get(0);
        }
        if (ruser != null) {
            session.setAttribute("user", ruser);
            return "forward:/before";
        } else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
    }

    public String personal(Model model) {
        return "personal";
    }

    public String mine(HttpSession session, Model model) {
        model.addAttribute("appointment", appointmentDao.selectCreated(MyUtil.getUserId(session)));
        return "created";
    }

    public String update(User user, Model model, HttpSession session) {
        userDao.update(user);
        session.setAttribute("user", user);
        return "personal";
    }
}
