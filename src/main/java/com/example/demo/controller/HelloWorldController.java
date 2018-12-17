package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.MyException;
import com.example.demo.common.update.SFTPClientUtils;
import com.example.demo.common.update.SFTPConnectionFactory;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.Person;
import com.example.demo.domain.Sftp;
import com.example.demo.domain.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.RedisService;



@RestController
@RequestMapping("${server.name}/helloWorld")
public class HelloWorldController {
	
	private final Logger log=  LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
    private UserService userServiceImpl;
	@Autowired
    Person person;
	 @Value("${sftp.downloadSleep}")
     Integer downloadSleep;
	 
	 @Autowired
	    StringRedisTemplate stringRedisTemplate;
	 @Autowired
	 RedisService redisService;
	 
	
    @RequestMapping("/hello")
    public String index() {
    	
    	
        return "Hello World";
    }
    
    @RequestMapping("/getUser.do")
    public List<UserEntity> getUser() {
    	if(1>0)
    		throw new MyException("101", "Sam 错误");
    	//log.error("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%eeeee%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    	List<UserEntity>	list= userServiceImpl.getAll();
    UserEntity user=new UserEntity();
    
        return list;
    }
    
    @PostMapping("/upload.do") 
    public Map<String,Map<Boolean,String>> singleFileUpload(@RequestParam("file") List<MultipartFile> files) {
       String basePath="/usr/local/updateFiles";
       String directory="img";
       redisService.set("aa","zhubaorui");
      Object aa= stringRedisTemplate.opsForValue().get("aa");
      
      System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%:"+aa);
      
       
       Map<String,Map<Boolean,String>> result=SFTPClientUtils.upload(basePath, directory, files);
       
       return result;
       
    }
    
}
