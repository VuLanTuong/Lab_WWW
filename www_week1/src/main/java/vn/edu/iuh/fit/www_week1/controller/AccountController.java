package vn.edu.iuh.fit.www_week1.controller;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;
import org.checkerframework.common.reflection.qual.GetMethod;
import vn.edu.iuh.fit.www_week1.models.Account;
import vn.edu.iuh.fit.www_week1.repositories.AccountRepository;

public class AccountController {


    @Inject
    private AccountRepository accountRepository;


    @POST
    public Response login(Account account) throws Exception {
        accountRepository.insert(account);

        return Response.ok("OK").build();
    }


}
