package com.earnbook.ebs.services.ejb.login;

import com.earnbook.ebs.client.constant.JndiName;
import com.earnbook.ebs.client.delegate.service.LoginService;
import com.earnbook.ebs.client.model.domain.user.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;


@Interceptors(SpringBeanAutowiringInterceptor.class)
@Stateless(name = JndiName.LOGIN_SERVICE_EJB, mappedName = JndiName.LOGIN_SERVICE_EJB)

public class LoginServiceEjb  implements LoginService {

    @Qualifier("loginService")
    @Autowired
    private LoginService  loginService;

    @Override
    public UserDetails doLogin(UserDetails userDetails) throws Exception{
        return loginService.doLogin(userDetails);
    }


}
