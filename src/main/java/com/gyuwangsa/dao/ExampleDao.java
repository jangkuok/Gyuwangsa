package com.gyuwangsa.dao;

import com.gyuwangsa.vo.ExampleVO;

import java.util.List;

public interface ExampleDao {

    List<ExampleVO> selectListExample() throws Exception;

}
