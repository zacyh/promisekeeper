package service;

import dao.AppointmentDao;
import dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import po.AppointmentType;
import javax.servlet.http.HttpSession;

@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService{
    @Autowired
    IndexDao indexDao;
    @Autowired
    AppointmentDao appointmentDao;

    public String before(Model model, HttpSession session, AppointmentType appointmentType) {
        session.setAttribute("typelist", indexDao.selectAppointmentType());
        model.addAttribute("appointment", appointmentDao.selectAppointment(0));
        return "main";
    }
}
