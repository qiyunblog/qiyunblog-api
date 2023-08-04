package com.itshanhe.qiyunblogapi.service.impl;

import com.itshanhe.qiyunblogapi.entity.BlogImg;
import com.itshanhe.qiyunblogapi.mapper.BlogUploadMapper;
import com.itshanhe.qiyunblogapi.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadServiceImpl implements UploadService {
    @Autowired
    private BlogUploadMapper blogUpload;

    @Override
    public Boolean upload(String filePath) {


        return blogUpload.uploadImg(filePath)>0;
    }
}
