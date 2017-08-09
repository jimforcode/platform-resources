package cn.creatoo.service.test;

import cn.creatoo.common.exception.UserReadableException;
import cn.creatoo.common.utils.UUIDUtil;
import cn.creatoo.dao.test.TestMapper;
import cn.creatoo.model.test.Test;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchAdd(int num) {
        int count=0;
        for(int i =0 ;i<num;i++){
            Test test;
            if (i==num-1){
                 test = new Test("089b8621a5ce4f9ba351bbec4d1ff570","name"+1,i,"content"+i);
            }else {
                 test = new Test(UUIDUtil.createUUId(),"name"+1,i,"content"+i);
            }
           try {
               int res= testMapper.insert(test);
               count+=res;
           }catch (Exception e){
                if(e instanceof DuplicateKeyException){
                    test.setId(UUIDUtil.createUUId());
                    int res= testMapper.insert(test);
                    count+=res;
                }else {
                    e.printStackTrace();
                    throw new UserReadableException("添加失败！");
                }

           }


        }
        return count;
    }
}
