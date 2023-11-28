package com.project.springboot001.service.impl;

import com.project.springboot001.entity.File;
import com.project.springboot001.mapper.FileMapper;
import com.project.springboot001.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Qing
 * @since 2023-11-28
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
