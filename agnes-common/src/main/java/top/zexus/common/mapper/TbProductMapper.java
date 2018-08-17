package top.zexus.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.zexus.common.pojo.TbProduct;
import top.zexus.common.pojo.TbProductExample;

public interface TbProductMapper {
    int countByExample(TbProductExample example);

    int deleteByExample(TbProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbProduct record);

    int insertSelective(TbProduct record);

    List<TbProduct> selectByExample(TbProductExample example);

    TbProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByExample(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByPrimaryKeySelective(TbProduct record);

    int updateByPrimaryKey(TbProduct record);

    List<TbProduct> selectGoodsFront(@Param("cid") Long cid,
                                     @Param("orderCol") String orderCol,
                                     @Param("orderDir") String orderDir,
                                     @Param("priceGt") int priceGt,
                                     @Param("priceLt") int priceLt);
}