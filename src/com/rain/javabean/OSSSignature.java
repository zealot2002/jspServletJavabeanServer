package com.rain.javabean;

import java.net.URL;
import java.util.Date;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import org.apache.http.client.methods.HttpUriRequest;
public class OSSSignature {
//	 private static final String bucketName = "mmedi-app-test-bucket";
	 private static final String bucketName = "mmedi-app-bucket";
	 
	 private static final String ACCESS_ID = "5dSa8MlHGu7yFFTl";
	 private static final String ACCESS_KEY = "cJ9etE0sgxn83G8H1tcRG1kU57rLPU";
	 private static final String OSS_ENDPOINT = "http://oss-cn-beijing.aliyuncs.com";
	 
	public static String getSignature(String key){
		ClientConfiguration config = new ClientConfiguration();
	    OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY, config);
		Date expiration = new Date(new Date().getTime() +60 * 1000);
		URL url = client.generatePresignedUrl(bucketName, key, expiration,HttpMethod.GET);
		return url.toString();
	}
}
