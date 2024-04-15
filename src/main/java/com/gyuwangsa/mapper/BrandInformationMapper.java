package com.gyuwangsa.mapper;


import com.gyuwangsa.vo.BrandVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandInformationMapper {
    //브랜드 등록
    int insertBrandJoin(BrandVO vo) throws Exception;
    //브랜드 목록
    List<BrandVO> selectBrandInfoListJoin(Character c) throws Exception;
}
