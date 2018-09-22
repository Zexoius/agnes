package top.zexus.manager.service.impl;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import top.zexus.common.mapper.TbProductMapper;
import top.zexus.common.pojo.TbProduct;
import top.zexus.common.pojo.dto.CartList;
import top.zexus.common.utils.DtoUtils;
import top.zexus.common.utils.Result;
import top.zexus.manager.Redis.RedisClient;
import top.zexus.manager.service.CartService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:21 2018/8/26
 */
@Service
public class CartServiceImpl implements CartService {
    private final String CART = "CART";
    @Resource
    private RedisClient redisClient;
    @Resource
    private TbProductMapper tbProductMapper;

    @Override
    public int addCart(long userId, long goodsId, int num) {
        Boolean flag = redisClient.hexists(CART + ":" + userId, "" + goodsId);
        if (flag) {
            Object room = redisClient.hget(CART + ":" + userId, "" + goodsId);
            try {
                if (room == null) {
                    throw new Exception("查无商品");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String json = (String) room;
            CartList cartList = new Gson().fromJson(json, CartList.class);
            cartList.setGoodsNum(cartList.getGoodsNum() + num);
            redisClient.hset(CART + ":" + userId, "" + goodsId, new Gson().toJson(cartList));
            return 1;
        } else {
            TbProduct tbProduct = tbProductMapper.selectByPrimaryKey(goodsId);
            if (tbProduct == null) {
                return 0;
            }
            CartList cartList = DtoUtils.TbGoods2CartList(tbProduct);
            cartList.setGoodsNum((long) num);
            cartList.setChecked("1");
//            cartList.setProductImg(tbProduct.getImage());
            redisClient.hset(CART + ":" + userId, "" + goodsId, new Gson().toJson(cartList));
            return 1;
        }
    }

    @Override
    public int delCartListItem(long userId, long goodsId) {
        redisClient.hdel(CART + ":" + userId, "" + goodsId);
        return 1;
    }

    @Override
    public Result getCartList(long userId) {
        List<Object> room = redisClient.hvals(CART + ":" + userId);
        List<String> jsonList = (List<String>) (List) room;
        List<CartList> list = new ArrayList<>();
        for (String json : jsonList) {
            CartList cartList = new Gson().fromJson(json, CartList.class);
            list.add(cartList);
        }
        return Result.ok()
                .put("cartList", list);
    }

    @Override
    public Result checkAll(long userId, String checked) {
        List<Object> room = redisClient.hvals(CART + ":" + userId);
        List<String> jsonList = (List<String>) (List) room;
        for (String json : jsonList){
            CartList cartList = new Gson().fromJson(json,CartList.class);
            if (checked.equals("true")){
                cartList.setChecked("1");
            }else if (checked.equals("false")){
                cartList.setChecked("0");
            }else {
                return Result.error();
            }
            redisClient.hset(CART + ":" + userId,"" + cartList.getGoodsId(),new  Gson().toJson(cartList));
        }
        return Result.ok();
    }

    @Override
    public Result delChecked(long userId) {
        List<Object> room = redisClient.hvals(CART + ":" + userId);
        List<String> jsonList = (List<String>) (List) room;
        for (String json : jsonList){
            CartList cartList = new Gson().fromJson(json,CartList.class);
            if (cartList.getChecked().equals("1")){
                redisClient.hdel(CART + ":" + userId,"" + cartList.getGoodsId());
            }
        }
        return Result.ok();
    }

    @Override
    public Result updateCartNum(long userId, long goodsId, int num, String checked) {
        String json = (String) redisClient.hget(CART + ":" + userId,"" + goodsId);
        if (json == null){
            return Result.error("查无商品");
        }
        CartList cartList = new Gson().fromJson(json,CartList.class);
        cartList.setGoodsNum((long) num);
        cartList.setChecked(checked);
        redisClient.hset(CART + ":" + userId,"" + goodsId,new Gson().toJson(cartList));
        return Result.ok();
    }
}
