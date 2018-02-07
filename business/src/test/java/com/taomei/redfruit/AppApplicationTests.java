package com.taomei.redfruit;

import com.taomei.redfruit.api.start.StartService;
import com.taomei.redfruit.business.user.application.RegisterService;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private StartService startService;
    @Test
    public void randomNumber() {
        System.out.println(ValidatesUtil.generateRandomNumber(6));
    }

    @Test
    public void getStart() throws Exception {
        LocalDate date = LocalDate.of(1993,11,20);
        System.out.println(startService.getStart(date));
    }

    @Test
    public void verifyMobile() {

    }
}
