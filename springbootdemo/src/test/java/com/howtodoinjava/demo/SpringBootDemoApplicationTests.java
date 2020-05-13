package com.howtodoinjava.demo;

import java.net.URISyntaxException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests 
{
    @LocalServerPort
    int randomServerPort;
     
    @Test
    public void testGetEmployeeListSuccess() throws URISyntaxException 
    {
 
    }  
}