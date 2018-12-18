package com.example.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="sftp")
public class Sftp {
	
	public Integer getDownloadSleep() {
		return downloadSleep;
	}
	public void setDownloadSleep(Integer downloadSleep) {
		this.downloadSleep = downloadSleep;
	}
	public Integer getDownloadRetry() {
		return downloadRetry;
	}
	public void setDownloadRetry(Integer downloadRetry) {
		this.downloadRetry = downloadRetry;
	}
	public Integer getUploadSleep() {
		return uploadSleep;
	}
	public void setUploadSleep(Integer uploadSleep) {
		this.uploadSleep = uploadSleep;
	}
	public Integer getUploadRettry() {
		return uploadRettry;
	}
	public void setUploadRettry(Integer uploadRettry) {
		this.uploadRettry = uploadRettry;
	}
	private Integer downloadSleep;
	private Integer downloadRetry;
	private Integer uploadSleep;
	private Integer uploadRettry;
	@Override
	public String toString() {
		return "Sftp [downloadSleep=" + downloadSleep + ", downloadRetry=" + downloadRetry + ", uploadSleep="
				+ uploadSleep + ", uploadRettry=" + uploadRettry + "]";
	}
	
	
}
