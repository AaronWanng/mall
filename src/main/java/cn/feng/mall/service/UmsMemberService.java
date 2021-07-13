package cn.feng.mall.service;

import cn.feng.mall.common.api.CommonResult;

/**
 * @description: 会员管理service
 * @projectName:mall
 * @see:cn.feng.mall.service
 * @author:WF
 * @createTime:2021/7/12 9:52
 * @version:1.0
 */
public interface UmsMemberService {
    
    /**
     * 生成验证码
     **/
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
