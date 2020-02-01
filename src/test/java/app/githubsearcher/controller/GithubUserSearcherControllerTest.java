package app.githubsearcher.controller;

import app.githubsearcher.logic.GitHubSearchMultipleLogic;
import app.githubsearcher.model.dto.ReportUsersDto;
import app.githubsearcher.model.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.*;


/**
 *
 * @author skuarch
 */
@DirtiesContext
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GithubUserSearcherControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private GitHubSearchMultipleLogic logic;
    
    public GithubUserSearcherControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        assertNotNull(mockMvc);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testSearchGithubUser() throws Exception {
        // I want to search users in github
        
        // given
        List<UserDto> users = new ArrayList<>();
        UserDto user1 = new UserDto("Chunky", "Garg", "Gurgaon");
        UserDto user2 = new UserDto("Sharvi", "Verma", "India");
        UserDto user3 = new UserDto("Rahul", "Gaur", "India");
        UserDto user4 = new UserDto("Abhishek", "Parikh", "");
        UserDto user5 = new UserDto("Anubhav", "Verma", "India");        
        UserDto user6 = new UserDto("Shiva", "Tiwari", "Bangalore");
        UserDto user7 = new UserDto("Sumit", "Yadav", "New Delhi");        
        UserDto user8 = new UserDto("Varun", "Arora", "India");
        UserDto user9 = new UserDto("Anshika", "Singh", "India");
        UserDto user10 = new UserDto("Salman", "Kagzi", "");
        UserDto user11 = new UserDto("James", "Golick", "New York");
        UserDto user12 = new UserDto("Dave", "Fayram", "San Francisco, CA");
        UserDto user13 = new UserDto("Nishan", "Perera", "London");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
        users.add(user11);
        users.add(user12);
        users.add(user13);
        
        // when
        List<ReportUsersDto> report = logic.searchMultipleUsers(users);
                
        // then 
        assertNotNull(report);
        
    }
    
}
