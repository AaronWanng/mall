package cn.feng.mall.controller;

import cn.feng.mall.common.api.CommonResult;
import cn.feng.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @projectName:mall
 * @see:cn.feng.mall.controller
 * @author:WF
 * @createTime:2021/7/12 9:51
 * @version:1.0
 */
@RestController
@RequestMapping("/sso")
@AllArgsConstructor
@Api(tags = "UmsMemberController", value = "会员登录注册管理")
public class UmsMemberController {

    private final UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }

}
