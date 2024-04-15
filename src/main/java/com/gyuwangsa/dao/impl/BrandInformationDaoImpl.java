package com.gyuwangsa.dao.impl;

import com.gyuwangsa.dao.BrandInformationDao;
import com.gyuwangsa.mapper.BrandInformationMapper;
import com.gyuwangsa.vo.BrandVO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("brandInformationDaoImpl")
public class BrandInformationDaoImpl implements BrandInformationDao {

    @Resource(name = "brandInformationMapper")
    private BrandInformationMapper brandInformationMapper;

    //브랜드 등록
    @Override
    public int insertBrandJoin(BrandVO vo) throws Exception {
        System.out.println("===> <브 랜 드> MyBatis로 insertBrandJoin() 기능 처리");
        return brandInformationMapper.insertBrandJoin(vo);
    }
    //브랜드 목록
    @Override
    public List<BrandVO> selectBrandInfoListJoin(Character c) throws Exception {
        System.out.println("===> <브 랜 드> MyBatis로 selectBrandInfoListJoin() 기능 처리");
        return brandInformationMapper.selectBrandInfoListJoin(c);
    }
}
