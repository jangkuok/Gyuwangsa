package com.gyuwangsa.controller;

import com.gyuwangsa.service.BrandInformationService;
import com.gyuwangsa.vo.BrandVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class BrandInformationController {

    private static final Logger logger = LoggerFactory.getLogger(BrandInformationController.class);

    @Resource(name = "brandInformationService")
    private BrandInformationService brandInformationService;

    //브랜드 가입 페이지 이동
    @RequestMapping(value = "/joinBrand.do", method = RequestMethod.GET)
    public String brandJoinPage() throws Exception{
        logger.info("########## 브랜드 가입 페이지 이동 ##########");
        return "joinBrand";
    };

    //브랜드 가입
    @RequestMapping(value = "/insertBrandJoin.do", method = RequestMethod.POST)
    public String insertBrandJoin(HttpServletRequest request, Model model) throws Exception{
        logger.info("########## 브랜드 가입 ##########");

        BrandVO vo = new BrandVO();

        //오늘 날짜
        Date today = new Date();

        //종료 날짜(+2년)
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.MONTH,24);

        vo.setBrand_nm(request.getParameter("brand_nm"));
        vo.setBrand_img(request.getParameter("brand_img"));
        vo.setBrand_addr_no(request.getParameter("brand_addr_no"));
        vo.setBrand_addr(request.getParameter("brand_addr"));
        vo.setBrand_addr_dtl(request.getParameter("brand_addr_dtl"));
        vo.setDeli_comp_cd(request.getParameter("deli_comp_cd"));
        vo.setState_cd('n');
        vo.setStart_date(today);
        vo.setEnd_date(cal.getTime());

        //브랜드 등록
        try {
            brandInformationService.insertBrandJoin(vo);
        }catch (Exception e){
            System.out.println("브랜드 등록 실패");
            e.printStackTrace();
        }

        return "redirect:/";
    };

    @RequestMapping(value = "/selectBrandInfoListJoin.do", method = RequestMethod.GET)
    public void selectBrandInfoList(Model model) throws Exception{
        List<BrandVO> list = brandInformationService.selectBrandInfoListJoin('y');
        model.addAttribute("brandList", list);
    };
}
