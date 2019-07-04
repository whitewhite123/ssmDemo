package com.msj.controller;

import com.msj.entity.ClaimVoucher;
import com.msj.entity.ClaimVoucherInfo;
import com.msj.entity.Employee;
import com.msj.global.Contant;
import com.msj.service.ClaimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.Oneway;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {
    @Autowired
    private ClaimVoucherService claimVoucherService;

    //新增报销单
    @RequestMapping("/to_add")
    public String to_add(Map<String,Object> map){
        map.put("info",new ClaimVoucherInfo());
        map.put("items",Contant.getItems());
        return "claim_voucher_add";
    }
    @RequestMapping("/add")
    public String add(HttpSession session,ClaimVoucherInfo info){
        Employee employee = (Employee) session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherService.save(info.getClaimVoucher(),info.getItems());
        return "claim_voucher_self";
    }

    @RequestMapping("/self")
    public String self(Map<String,Object> map,HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        String createSn = employee.getSn();
        List<ClaimVoucher> claimVoucherList = claimVoucherService.findSelf(createSn);
        System.out.println(claimVoucherList);
        map.put("list",claimVoucherList);
        return "claim_voucher_self";
    }
}
