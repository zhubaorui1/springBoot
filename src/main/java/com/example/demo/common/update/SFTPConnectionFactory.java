package com.example.demo.common.update;

import java.util.Properties;

import org.slf4j.Logger;    
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.Channel;    
import com.jcraft.jsch.ChannelSftp;    
import com.jcraft.jsch.JSch;    
import com.jcraft.jsch.JSchException;    
import com.jcraft.jsch.Session;    

/**
 * SFTP工厂类，用于获取SFTP的连接
 * @author 奇点_
 */

@Component
@ConfigurationProperties(prefix = "sftp")
public class SFTPConnectionFactory {
	private static Logger LOGGER = LoggerFactory.getLogger(SFTPClientUtils.class);
	/** SFTP 登录用户名*/
	private static String username;	
	/** SFTP 登录密码*/	
	private static String password;	
	/** 私钥 */	
	private static String privateKey;	
	/** SFTP 服务器地址IP地址*/	
	 private static String ip;	
	/** SFTP 端口*/	
	private static int port;
	
	private static final SFTPConnectionFactory factory = new SFTPConnectionFactory();
	private ChannelSftp client;
	private Session session;
	private SFTPConnectionFactory(){
		
	}
	
	public static SFTPConnectionFactory getInstance(){
		return factory;
	}
	synchronized public ChannelSftp makeConnection(){
		
		if(client==null||session==null||!client.isConnected()||!session.isConnected()){
			try { 
				
				/* ip: 
				   port: 22
				   username: root
				   password: 453486495zbrZ
				   downloadSleep: 100 #文件下载失败下次超时重试时间
				   downloadRetry: 10 #文件下载失败重试次数
				   uploadSleep: 100 #文件上传失败下次超时重试时间
				   uploadRettry: 10  #文件上传失败重试次数*/
				
				JSch jsch = new JSch(); 
				if (privateKey != null) {  
					jsch.addIdentity(privateKey);// 设置私钥
				}  
				session = jsch.getSession(username, ip, port); 
				if (password != null) {
					session.setPassword(password);
				}
				Properties config = new Properties();
				config.put("StrictHostKeyChecking", "no"); 
				session.setConfig(config);                
				session.connect();                
				Channel channel = session.openChannel("sftp");                
				channel.connect();                
				client = (ChannelSftp) channel;                
				LOGGER.info("sftp服务器连接成功");
			} catch (JSchException e) {                
				LOGGER.error("sftp登录失败，检测登录ip，端口号，用户名密码是否正确，错误信息为"+e.getMessage());
			}
		}
		                
			return client;
	}
	/**  
	 * 关闭连接 server 
	 */
	public void logout(){
		if(client != null) {
			if(client.isConnected()) {
				client.disconnect();
			}
		}
	   if(session != null){
		   if(session.isConnected()){
				session.disconnect();
		   }
		}
	}
 
 
	public static String getUsername() {
		return username;
	}
 
 
	public  void setUsername(String username) {
		SFTPConnectionFactory.username = username;
	}
 
 
	public static String getPassword() {
		return password;
	}
 
 
	public  void setPassword(String password) {
		SFTPConnectionFactory.password = password;
	}
 
 
	public static String getPrivateKey() {
		return privateKey;
	}
 
 
	public  void setPrivateKey(String privateKey) {
		SFTPConnectionFactory.privateKey = privateKey;
	}
 
 
	public static String getIp() {
		return ip;
	}
 
 
	public  void setIp(String ip) {
		SFTPConnectionFactory.ip = ip;
	}
 
 
	public static int getPort() {
		return port;
	}
 
 
	public  void setPort(int port) {
		SFTPConnectionFactory.port = port;
	}
}
