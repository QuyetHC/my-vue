package com.ra.controller;
import com.ra.model.entity.*;
import com.ra.service.*;
import oracle.jdbc.driver.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ra.service.CUSTService.*;

@RestController
@CrossOrigin("*")
public class BankController {
    @Autowired
    private CfmastService cfmastService;
    @Autowired
    private SemastService semastService;
    @Autowired
    private CUSTService custService;

    @Autowired
    private LoginService loginService;
    @Autowired
    private LoanService loanService;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private ReportCreditService ReportCreditService;


    @GetMapping("/getcf")
    public ResponseEntity<List<Cfmast>>getCfmast(){
        List<Cfmast> cfmastList=cfmastService.findAll();
        return new ResponseEntity<>(cfmastList, HttpStatus.OK);
    }
    @GetMapping("/getsema")
    public ResponseEntity<List<Semast>> getSemastList(){
        List<Semast> list = semastService.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/getloan")
    public ResponseEntity<List<loan>> getLoanlist(){
        List<loan> list = loanService.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getcust")
    public ResponseEntity<List<CUST>> getCUSTList(@RequestParam String cusitd){
        List<CUST> custlist = custService.findAll(cusitd);
        return new ResponseEntity<>(custlist,HttpStatus.OK);
    }
    @GetMapping("/getbance")
    public ResponseEntity<List<balance>> getBalancelist(){
        List<balance> list = balanceService.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/report")
    public ResponseEntity<List<reportcredit>> reportcreditlist(){
        List<reportcredit> list = ReportCreditService.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/getlogin")
    public ResponseEntity<?> posts(@RequestParam String username, @RequestParam String passwd) {
        List<login> loginList = loginService.findAll(username, passwd);

        // Kiểm tra dữ liệu trên frontend có khớp với dữ liệu trên backend hay không
        if (loginList.isEmpty()) {
            LoginResponse response = new LoginResponse();
            response.setStatus("error");
            response.setMessage("Tên đăng nhập hoặc mật khẩu không chính xác.");
            return ResponseEntity.badRequest().body(response);
        } else {
            LoginResponse response = new LoginResponse();
            response.setStatus("success");
            response.setMessage("Đăng nhập thành công.");
            response.setLoginList(loginList);
            return ResponseEntity.ok().body(response);
        }
    }

}
