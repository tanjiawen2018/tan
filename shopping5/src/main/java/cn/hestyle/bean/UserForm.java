package cn.hestyle.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 表单信息类
 * @author hestyle
 *
 */
public class UserForm {
    private String userName;
    private String password;
    private String repassword;
    private String gender;
    private String emailAddr;
    //表单项错误信息
    private Map<String, String> errMap;

    public UserForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserForm(String userName, String password, String repassword, String gender, String emailAddr) {
        super();
        this.userName = userName;
        this.password = password;
        this.repassword = repassword;
        this.gender = gender;
        this.emailAddr = emailAddr;
        errMap = new HashMap<String, String>();
    }

    /**
     * 用户判断表单的合法性
     * @return
     */
    public boolean isValidate() {
        //检查用户名
        if (userName == null || "".equals(userName.trim())) {
            errMap.put("userName", "请输入用户名！");
        } else if (userName.length() < 6 || userName.length() > 18) {
            errMap.put("userName", "用户名长度不在6-18区间内！");
        } else if (userName.indexOf(" ") > 0) {
            errMap.put("userName", "用户名包含空格！");
        }
        //检查密码
        if(password == null || "".equals(password.trim())){
            errMap.put("password", "请输入密码！");
        }else if(!password.matches("\\d{6,12}")){
            errMap.put("password", "密码长度不在6-12区间内");
        }
        //检查两次密码是否相同
        if (password == null || !password.equals(repassword)) {
            errMap.put("repassword", "密码与确认密码不一致！");
        }
        //检查邮箱格式正确与否
        if (emailAddr == null || "".equals(emailAddr.trim())) {
            errMap.put("emailAddr", "请输入邮箱地址！");
        } else if(!emailAddr.matches("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$")){
            errMap.put("emailAddr", "邮箱格式错误！");
        }
        //检测errMap是否为空，从而检测表单是否合法
        return errMap.isEmpty();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public Map<String, String> getErrMap() {
        return errMap;
    }

    public void setErrMap(Map<String, String> errMap) {
        this.errMap = errMap;
    }

    @Override
    public String toString() {
        return "UserForm [userName=" + userName + ", password=" + password + ", repassword=" + repassword + ", gender="
                + gender + ", emailAddr=" + emailAddr + "]";
    }
}

