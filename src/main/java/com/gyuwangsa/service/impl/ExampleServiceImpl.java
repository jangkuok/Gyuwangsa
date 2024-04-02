package com.gyuwangsa.service.impl;

import com.gyuwangsa.dao.ExampleDao;
import com.gyuwangsa.service.ExampleService;
import com.gyuwangsa.vo.ExampleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    @Resource(name = "exampleDaoImpl")
    private ExampleDao exampleDao;

    public List<ExampleVO> selectListExample() throws Exception {
        return exampleDao.selectListExample();
    }
}
