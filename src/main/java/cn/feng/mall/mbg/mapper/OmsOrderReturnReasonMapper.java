package cn.feng.mall.mbg.mapper;

import cn.feng.mall.mbg.model.OmsOrderReturnReason;
import cn.feng.mall.mbg.model.OmsOrderReturnReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderReturnReasonMapper {
    long countByExample(OmsOrderReturnReasonExample example);

    int deleteByExample(OmsOrderReturnReasonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderReturnReason record);

    int insertSelective(OmsOrderReturnReason record);

    List<OmsOrderReturnReason> selectByExample(OmsOrderReturnReasonExample example);

    OmsOrderReturnReason selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderReturnReason record, @Param("example") OmsOrderReturnReasonExample example);

    int updateByExample(@Param("record") OmsOrderReturnReason record, @Param("example") OmsOrderReturnReasonExample example);

    int updateByPrimaryKeySelective(OmsOrderReturnReason record);

    int updateByPrimaryKey(OmsOrderReturnReason record);
}