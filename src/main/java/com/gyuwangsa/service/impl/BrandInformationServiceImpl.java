package com.gyuwangsa.service.impl;

import com.gyuwangsa.dao.BrandInformationDao;
import com.gyuwangsa.service.BrandInformationService;
import com.gyuwangsa.vo.BrandVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("brandInformationService")
public class BrandInformationServiceImpl implements BrandInformationService {

    @Resource(name = "brandInformationDaoImpl")
    private BrandInformationDao brandInformationDao;

    //브랜드 등록
    @Override
    public int insertBrandJoin(BrandVO vo) throws Exception {
        System.out.println("===> <브 랜 드> Service insertBrandJoin() 기능 처리");
        return brandInformationDao.insertBrandJoin(vo);
    }
    //브랜드 목록
    @Override
    public List<BrandVO> selectBrandInfoListJoin(Character c) throws Exception {
        System.out.println("===> <브 랜 드> Service selectBrandInfoListJoin() 기능 처리");
        return brandInformationDao.selectBrandInfoListJoin(c);
    }
}
