package com.DMDA.Lab09_10.controller;

import com.DMDA.Lab09_10.entity.dmdaEntity;
import com.DMDA.Lab09_10.service.dmdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class dmdaController {

    @Autowired
    private dmdaService service;

    // Hiển thị danh sách tài khoản
    @GetMapping("/list")
    public String getAllAccounts(Model model) {
        List<dmdaEntity> accounts = service.getAllAccounts();
        if (accounts == null || accounts.isEmpty()) {
            // Đảm bảo danh sách tài khoản không null hoặc rỗng
            model.addAttribute("accounts", new ArrayList<dmdaEntity>());
        } else {
            model.addAttribute("accounts", accounts);
        }
        return "dmda-account-list";  // View hiển thị danh sách tài khoản
    }


    // Hiển thị form thêm tài khoản
    @GetMapping("/add")
    public String showAddAccountForm(Model model) {
        model.addAttribute("account", new dmdaEntity());  // Thêm một đối tượng mới để binding dữ liệu form
        return "dmda-account-add";  // Chuyển đến trang form thêm tài khoản
    }

    // Thêm tài khoản mới
    @PostMapping("/add")
    public String addAccount(@ModelAttribute dmdaEntity account) {
        service.saveAccount(account);  // Lưu tài khoản mới vào database
        return "redirect:/accounts/list";  // Sau khi thêm xong, chuyển hướng về danh sách tài khoản
    }

    // Hiển thị form sửa tài khoản
    @GetMapping("/edit/{id}")
    public String showEditAccountForm(@PathVariable Long id, Model model) {
        dmdaEntity account = service.getAccountById(id);
        model.addAttribute("account", account);  // Truyền tài khoản cần sửa ra view
        return "dmda-account-edit";  // Chuyển đến trang form sửa tài khoản
    }

    // Cập nhật tài khoản
    @PostMapping("/edit/{id}")
    public String updateAccount(@PathVariable Long id, @ModelAttribute dmdaEntity account) {
        account.setId(id);  // Đảm bảo ID không bị thay đổi
        service.saveAccount(account);  // Cập nhật tài khoản
        return "redirect:/accounts/list";  // Sau khi cập nhật xong, chuyển hướng về danh sách tài khoản
    }

    // Xóa tài khoản
    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);  // Xóa tài khoản
        return "redirect:/accounts/list";  // Sau khi xóa, chuyển hướng về danh sách tài khoản
    }
}
