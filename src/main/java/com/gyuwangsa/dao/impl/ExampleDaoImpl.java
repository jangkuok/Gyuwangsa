package com.gyuwangsa.dao.impl;

import com.gyuwangsa.dao.ExampleDao;
import com.gyuwangsa.mapper.ExampleMapper;
import com.gyuwangsa.vo.ExampleVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository("exampleDaoImpl")
public class ExampleDaoImpl implements ExampleDao {

    @Resource(name = "exampleMapper")
    private ExampleMapper exampleMapper;

    public List<ExampleVO> selectListExample() throws Exception {
        System.out.println("===> MyBatis로 selectListExample() 기능 처리");
        return exampleMapper.selectListExample();
    }

}
