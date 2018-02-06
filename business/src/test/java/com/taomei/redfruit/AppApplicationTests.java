package com.taomei.redfruit;

import com.taomei.redfruit.business.user.application.service.RegisterAppService;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {
    @Autowired
    private RegisterAppService registerAppService;

    @Test
    public void randomNumber() {
        System.out.println(ValidatesUtil.generateRandomNumber(6));
    }

    @Test
    public void verifyMobile() {
        Assert.assertTrue(registerAppService.verifyMobile("13996652857"));
    }
}
