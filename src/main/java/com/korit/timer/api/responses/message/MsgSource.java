package com.korit.timer.api.responses.message;

import com.korit.timer.api.responses.message.ConstErrorMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MsgSource {

    public final String USEROK001;
    public final String USEROK002;
    public final String USEROK003;

    public final String EMPLOYEEOK001;
    public final String EMPLOYEEOK002;
    public final String EMPLOYEEOK003;

    public final ConstErrorMsg USERERROR001;
    public final ConstErrorMsg USERERROR002;
    public final ConstErrorMsg USERERROR003;
    public final ConstErrorMsg USERERROR004;
    public final ConstErrorMsg USERERROR005;

    public final ConstErrorMsg EMPLOYEEERROR001;

    public MsgSource(

            @Value("${ok.user.msg.001}") String okUserMsg001,
            @Value("${ok.user.msg.002}") String okUserMsg002,
            @Value("${ok.user.msg.003}") String okUserMsg003,

            @Value("${ok.employee.msg.001}") String okEmployeeMsg001,
            @Value("${ok.employee.msg.002}") String okEmployeeMsg002,
            @Value("${ok.employee.msg.003}") String okEmployeeMsg003,

            @Value("${error.user.msg.001}") String errorUserMsg001,
            @Value("${error.user.msg.002}") String errorUserMsg002,
            @Value("${error.user.msg.003}") String errorUserMsg003,
            @Value("${error.user.msg.004}") String errorUserMsg004,
            @Value("${error.user.msg.005}") String errorUserMsg005,

            @Value("${error.employee.msg.001}") String errorEmployeeMsg001

    ) {

        USEROK001 = okUserMsg001;
        USEROK002 = okUserMsg002;
        USEROK003 = okUserMsg003;

        EMPLOYEEOK001 = okEmployeeMsg001;
        EMPLOYEEOK002 = okEmployeeMsg002;
        EMPLOYEEOK003 = okEmployeeMsg003;

        USERERROR001 = new ConstErrorMsg("USERERROR001", errorUserMsg001);
        USERERROR002 = new ConstErrorMsg("USERERROR002", errorUserMsg002);
        USERERROR003 = new ConstErrorMsg("USERERROR003", errorUserMsg003);
        USERERROR004 = new ConstErrorMsg("USERERROR004", errorUserMsg004);
        USERERROR005 = new ConstErrorMsg("USERERROR005", errorUserMsg005);

        EMPLOYEEERROR001 = new ConstErrorMsg("EMPLOYEEERROR001", errorEmployeeMsg001);

    }


}
