package org.hhs;

import org.hhs.repositories.NoticeRepository;
import org.hhs.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootCharpter2ApplicationTests {
	@Autowired
	private NoticeRepository noticeRepository;

	@Autowired
	private UserRepository userRepository;
	@Test
	public void contextLoads() {
		assert noticeRepository.findAll()!=null;
		assert userRepository.findAll()!=null;
	}

}
