package com.itshanhe.qiyunblogapi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogUploadMapper {
    /**
     * 图片上传
     * @param filePath 图片路径
     */
    void uploadImg(String filePath);
}
