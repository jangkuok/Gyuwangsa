package com.gyuwangsa.service;


import com.gyuwangsa.vo.BrandVO;

import java.util.List;

public interface BrandInformationService {
    //브랜드 등록
    int insertBrandJoin(BrandVO vo) throws Exception;
    //브랜드 목록
    List<BrandVO> selectBrandInfoListJoin(Character c) throws Exception;
}