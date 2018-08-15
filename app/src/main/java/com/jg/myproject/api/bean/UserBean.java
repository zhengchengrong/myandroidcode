package com.jg.myproject.api.bean;

/**
 * Created by llz on 2018/3/29.
 */

public class UserBean {

    private String id;
    private String customerid;

    private String username;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    private String district;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    private String password;

    /**
     * userId : 4028830a622ca5a701622cbd76340015
     * keyId : null
     * salt : null
     * email : null
     * phone : null
     * displayName : XMB-000030
     * position : null
     * customerId : 26877
     * createtime : 2018-03-16 10:57:16
     * address : null
     * birthday :
     * gender : null
     * isAdmin : false
     * rememberMe : false
     * deptname : 4028830a61f8e9bf0161f9034b930007
     * accountType : 施工单位
     * company : {"id":"4028830a61df4fb20161df880ec00003","name":"广州天河施工单位001","code":"72983","address":null,"icon":null,"customerId":"26877","type":"施工单位","typeDesc":null,"firstRegion":"广东省","secondRegion":"广州市","thirdRegion":"天河区","phone":null,"header":null,"headerPhone":null,"headerEmail":null,"delegationModel":null}
     * locked : false
     * admin : false
     */

    private String userId;
    private Object keyId;
    private Object salt;
    private Object email;
    private Object phone;
    private String displayName;
    private Object position;
    private String customerId;
    private String createtime;
    private Object address;
    private String birthday;
    private Object gender;
    private boolean isAdmin;
    private boolean rememberMe;
    private String deptname;
    private String accountType;
    private CompanyBean company;
    private boolean locked;
    private boolean admin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getKeyId() {
        return keyId;
    }

    public void setKeyId(Object keyId) {
        this.keyId = keyId;
    }

    public Object getSalt() {
        return salt;
    }

    public void setSalt(Object salt) {
        this.salt = salt;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public CompanyBean getCompany() {
        return company;
    }

    public void setCompany(CompanyBean company) {
        this.company = company;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static class CompanyBean {
        /**
         * id : 4028830a61df4fb20161df880ec00003
         * name : 广州天河施工单位001
         * code : 72983
         * address : null
         * icon : null
         * customerId : 26877
         * type : 施工单位
         * typeDesc : null
         * firstRegion : 广东省
         * secondRegion : 广州市
         * thirdRegion : 天河区
         * phone : null
         * header : null
         * headerPhone : null
         * headerEmail : null
         * delegationModel : null
         */

        private String id;
        private String name;
        private String code;
        private Object address;
        private Object icon;
        private String customerId;
        private String type;
        private Object typeDesc;
        private String firstRegion;
        private String secondRegion;
        private String thirdRegion;
        private Object phone;
        private Object header;
        private Object headerPhone;
        private Object headerEmail;
        private Object delegationModel;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getTypeDesc() {
            return typeDesc;
        }

        public void setTypeDesc(Object typeDesc) {
            this.typeDesc = typeDesc;
        }

        public String getFirstRegion() {
            return firstRegion;
        }

        public void setFirstRegion(String firstRegion) {
            this.firstRegion = firstRegion;
        }

        public String getSecondRegion() {
            return secondRegion;
        }

        public void setSecondRegion(String secondRegion) {
            this.secondRegion = secondRegion;
        }

        public String getThirdRegion() {
            return thirdRegion;
        }

        public void setThirdRegion(String thirdRegion) {
            this.thirdRegion = thirdRegion;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getHeader() {
            return header;
        }

        public void setHeader(Object header) {
            this.header = header;
        }

        public Object getHeaderPhone() {
            return headerPhone;
        }

        public void setHeaderPhone(Object headerPhone) {
            this.headerPhone = headerPhone;
        }

        public Object getHeaderEmail() {
            return headerEmail;
        }

        public void setHeaderEmail(Object headerEmail) {
            this.headerEmail = headerEmail;
        }

        public Object getDelegationModel() {
            return delegationModel;
        }

        public void setDelegationModel(Object delegationModel) {
            this.delegationModel = delegationModel;
        }
    }
}
