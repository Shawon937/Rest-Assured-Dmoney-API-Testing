package testrunner;

import Setup.Setup;
import com.github.javafaker.Faker;
import controller.User;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;
import utils.Utils;

import java.io.IOException;

public class UserTestRunner {
//    @Test
//    public void _1_doLoginWithInvalid() throws ConfigurationException, IOException {
//        User user = new User();
//        user.callingLoginAPI("salman@grr.la", "123");
//        String messageExpected = "Password incorrect";
//        Assert.assertEquals(user.getMessage(), messageExpected);
//    }

    @Test
    public void _2_doLogin() throws ConfigurationException, IOException {
        User user = new User();
        user.callingLoginAPI("salman@grr.la", "1234");
        String messageExpected = "Login successfully";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

//    @Test
//    public void _3_getUserList() throws IOException {
//        User user = new User();
//        String id = user.callingUserListAPI();
//        System.out.println(id);
//        Assert.assertEquals(id, String.valueOf(81));
//    }

    @Test
    public void _3_createCustomer() throws IOException, ConfigurationException {
        User user = new User();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = "cus" + Utils.generateRandomNumber(10000, 99999) + "@test.com";
        String password = "1234";
        String phone_number = "0150" + Utils.generateRandomNumber(1000000, 9999999);
        String nid = "" + Utils.generateRandomNumber(10000000, 99999999);
        String role = "Customer";

        user.createCustomerAPI(name, email, password, phone_number, nid, role);

        String messageExpected = "User created successfully";
        Assert.assertEquals(user.getMessage(), messageExpected);


    }

    @Test
    public void _5_createAgent() throws IOException, ConfigurationException {
        User user = new User();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = "agent" + Utils.generateRandomNumber(10000, 99999) + "@test.com";
        String password = "1234";
        String phone_number = "0150" + Utils.generateRandomNumber(1000000, 9999999);
        String nid = "" + Utils.generateRandomNumber(10000000, 99999999);
        String role = "Agent";

        user.createAgentAPI(name, email, password, phone_number, nid, role);

        String messageExpected = "User created successfully";
        Assert.assertEquals(user.getMessage(), messageExpected);

    }

    @Test
    public void _6_customerLogin() throws IOException, ConfigurationException {

        User user = new User();
        user.callingCustomerLoginAPI();

        String messageExpected = "Login successfully";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

    @Test
    public void _7_updateCustomerData() throws IOException, ConfigurationException {

        User user = new User();
        String phone_number = "0181" + Utils.generateRandomNumber(1000000, 9999999);
        user.callingUpdateCustomerDataAPI(phone_number);
        String messageExpected = "User updated successfully";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

    @Test
    public void _8_depositToAgent() throws IOException, ConfigurationException {

        User user = new User();
        int amount=2000;
        user.callingDepositAgentAPI(amount);
        String messageExpected = "Deposit successful";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

    @Test
    public void _9_depositToCustomer() throws IOException, ConfigurationException {

        User user = new User();
        int amount=1000;
        user.callingDepositCustomerAPI(amount);
        String messageExpected = "Deposit successful";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

    @Test
    public void _10_checkAgentBalance() throws IOException, ConfigurationException {

        User user = new User();
        user.callingAgentBalanceAPI();
        String messageExpected = "User balance";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

    @Test
    public void _11_checkCustomerBalance() throws IOException, ConfigurationException {

        User user = new User();
        user.callingCustomerBalanceAPI();
        String messageExpected = "User balance";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

    @Test
    public void _12_cashOut() throws IOException, ConfigurationException {

        User user = new User();
        int amount = 500;
        user.callingCashOutAPI(amount);
        String messageExpected = "Withdraw successful";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

    @Test
    public void _13_checkCustomerBalanceAgain() throws IOException, ConfigurationException {

        User user = new User();
        user.callingCustomerBalanceAPI();
        String messageExpected = "User balance";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }



}
