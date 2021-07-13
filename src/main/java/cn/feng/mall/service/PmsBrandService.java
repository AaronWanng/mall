package cn.feng.mall.service;

import cn.feng.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @description:
 * @projectName:mall
 * @see:cn.feng.mall.service
 * @author:WF
 * @createTime:2021/7/6 17:21
 * @version:1.0
 */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
