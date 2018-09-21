package top.zexus.manager.service.impl;

import org.springframework.stereotype.Service;
import top.zexus.common.mapper.TbAddressMapper;
import top.zexus.common.pojo.TbAddress;
import top.zexus.common.pojo.TbAddressExample;
import top.zexus.common.utils.Result;
import top.zexus.manager.service.AddressService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 15:37 2018/9/20
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private TbAddressMapper tbAddressMapper;

    @Override
    public Result addAddress(TbAddress tbAddress) throws RuntimeException {
        setUniqeDefault(tbAddress);
        if (tbAddressMapper.insert(tbAddress) != 1) {
            throw new RuntimeException("插入地址失败");
        }
        return Result.ok();
    }

    @Override
    public Result delAddress(TbAddress tbAddress) throws RuntimeException {
        if (tbAddressMapper.deleteByPrimaryKey(tbAddress.getAddressId()) != 1) {
            throw new RuntimeException("删除地址失败");
        }
        return Result.ok();
    }

    @Override
    public Result getAddress(Long addressId) throws RuntimeException{
        TbAddress tbAddress = tbAddressMapper.selectByPrimaryKey(addressId);
        if (tbAddress == null){
            throw new RuntimeException("获取单个地址失败");
        }
        return Result.ok()
                .put("result",tbAddress);
    }

    @Override
    public Result getAddressList(Long userid) throws RuntimeException {
        List<TbAddress> list = new ArrayList<>();
        TbAddressExample example = new TbAddressExample();
        TbAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid);
        list = tbAddressMapper.selectByExample(example);
        if (list == null) {
            throw new RuntimeException("获取地址列表失败");
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIsDefault()){
                Collections.swap(list,0,i);
                break;
            }
        }
        return Result.ok()
                .put("result",list);
    }

    @Override
    public Result updateAddress(TbAddress tbAddress) throws RuntimeException{
        setUniqeDefault(tbAddress);
        if (tbAddressMapper.updateByPrimaryKey(tbAddress) != 1){
            throw new RuntimeException("更新地址失败");
        }
        return Result.ok();
    }

    /**
     * 是否唯一地址
     *
     * @param tbAddress
     */
    public void setUniqeDefault(TbAddress tbAddress) {
        if (tbAddress.getIsDefault()) {
            TbAddressExample example = new TbAddressExample();
            TbAddressExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(tbAddress.getUserId());
            List<TbAddress> list = tbAddressMapper.selectByExample(example);
            for (TbAddress tbAddressList : list) {
                tbAddressList.setIsDefault(false);
                tbAddressMapper.updateByPrimaryKey(tbAddressList);
            }
        }
    }
}
