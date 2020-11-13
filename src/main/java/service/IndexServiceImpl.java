package service;

import dao.AppointmentDao;
import dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import po.AppointmentType;
import java.util.List;
import javax.servlet.http.HttpSession;

@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService{
    @Autowired
    IndexDao indexDao;
    @Autowired
    AppointmentDao appointmentDao;

    @Override
    public String before(Model model, HttpSession session, AppointmentType appointmentType) {
        session.setAttribute("test", "sucessful");
        session.setAttribute("typelist", indexDao.selectAppointmentType());
        session.setAttribute("appointment", appointmentDao.selectAppointment());
        return "main";
    }
}
