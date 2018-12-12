package com.cverbo.tfg;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cverbo.tfg.model.mongo.MongoFollowedShow;
import com.cverbo.tfg.model.mongo.MongoUser;
import com.cverbo.tfg.model.mongo.MongoViewedEpisode;
import com.cverbo.tfg.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	UserServiceImpl userServiceImpl;	
	
	@Test
	public void insertUser_test() {
		
		MongoUser user = new MongoUser();
		
		user.setActive(true);
		user.setBirthDate(new Date());
		user.setEmail("carlos.verbo@gmail.com");
		user.setFirstName("Carlos");
		user.setLastName("Verbo");
		user.setPassword("1111");
		user.setUserName("carlos.verbo");
		
		MongoFollowedShow followedShow = new MongoFollowedShow();
		
		followedShow.setFavorite(false);
		followedShow.setShowId(44217);
		followedShow.setShowImgUrl("https://image.tmdb.org/t/p/w500/mBDlsOhNOV1MkNii81aT14EYQ4S.jpg");
		followedShow.setShowName("Vikings");
		
		user.setFollowedShows(Arrays.asList(followedShow));
		
		MongoViewedEpisode viewedEpisode = new MongoViewedEpisode();
		
		viewedEpisode.setShowId(44217);
		viewedEpisode.setSeasonId(1);
		viewedEpisode.setEpisodeId(892432);
		
		
		
		
		user.setFollowedUsers(null);
		user.setViewedEpisodes(null);
		
		userServiceImpl.insertUser(user);
		
	}
	
}