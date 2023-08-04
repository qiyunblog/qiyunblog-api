package com.itshanhe.qiyunblogapi.service;

public interface UploadService {
    /**
     * 图片上传
     * @param filePath 图片路径
     */
    Boolean upload(String filePath);
}
