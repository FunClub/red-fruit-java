package com.taomei.redfruit;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.api.start.StartService;
import com.taomei.redfruit.business.info.application.RegisterService;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StartService startService;


    @Test
    public void getStart() throws Exception {
        User user = new User();
        user.setEducation("2");
        Page<User> page = new Page<>(2,4);

        Page<User> users = userRepository.selectPage(page,new EntityWrapper<>(user));
        System.out.println(users);

    }


}
