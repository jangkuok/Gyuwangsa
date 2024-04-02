package com.gyuwangsa.mapper;

import com.gyuwangsa.vo.ExampleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExampleMapper {

    List<ExampleVO> selectListExample() throws Exception;
}
