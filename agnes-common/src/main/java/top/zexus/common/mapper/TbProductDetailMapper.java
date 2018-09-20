package top.zexus.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import top.zexus.common.pojo.TbProductDetail;
import top.zexus.common.pojo.TbProductDetailExample;

public interface TbProductDetailMapper {
    int countByExample(TbProductDetailExample example);

    int deleteByExample(TbProductDetailExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(TbProductDetail record);

    int insertSelective(TbProductDetail record);

    List<TbProductDetail> selectByExampleWithBLOBs(TbProductDetailExample example);

    List<TbProductDetail> selectByExample(TbProductDetailExample example);

    TbProductDetail selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") TbProductDetail record, @Param("example") TbProductDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") TbProductDetail record, @Param("example") TbProductDetailExample example);

    int updateByExample(@Param("record") TbProductDetail record, @Param("example") TbProductDetailExample example);

    int updateByPrimaryKeySelective(TbProductDetail record);

    int updateByPrimaryKeyWithBLOBs(TbProductDetail record);

    int updateByPrimaryKey(TbProductDetail record);
}