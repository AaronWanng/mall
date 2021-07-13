package cn.feng.mall.controller;

import cn.feng.mall.common.api.CommonPage;
import cn.feng.mall.common.api.CommonResult;
import cn.feng.mall.mbg.model.PmsBrand;
import cn.feng.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @projectName:mall
 * @see:cn.feng.mall.controller
 * @author:WF
 * @createTime:2021/7/6 17:17
 * @version:1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
@Api(tags = "PmsBrandController", value = "商品品牌管理")
public class PmsBrandController {

    private final PmsBrandService brandService;


    @GetMapping("/listAll")
    @ApiOperation("获取所有品牌列表")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(brandService.listAllBrand());
    }


    @PostMapping("/create")
    @ApiOperation("添加品牌")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = brandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            log.debug("updateBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @PutMapping("/update/{id}")
    @ApiOperation("更新指定id品牌信息")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto) {
        CommonResult commonResult;
        int count = brandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            log.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("删除指定id的品牌")
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @GetMapping("/list")
    @ApiOperation("分页查询品牌列表")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")
                                                        Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3")
                                                        Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @GetMapping("/{id}")
    @ApiOperation("获取指定id的品牌详情")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.getBrand(id));
    }
}
