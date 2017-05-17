package me.xiaotian.ichat.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import me.xiaotian.ichat.entity.FamilyRelaEntity;
import me.xiaotian.ichat.entity.FamilyUserEntity;
import me.xiaotian.ichat.entity.UserEntity;
import me.xiaotian.ichat.repository.FamilyRelaRepository;
import me.xiaotian.ichat.repository.FamilyUserRepository;
import me.xiaotian.ichat.service.FamilyUserService;
import me.xiaotian.ichat.service.RedisService;
import me.xiaotian.util.PasswordUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.yunpian.sdk.constant.YunpianConstant.MOBILE;
import static com.yunpian.sdk.constant.YunpianConstant.TEXT;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@Service(timeout = 1200000)
@org.springframework.stereotype.Service
public class FamilyUserServiceImpl implements FamilyUserService {

    private String YunPianApi = "a16d8d69e7c26b289010d059a6d1c74e";

    @Resource
    private RegCodeRedisServiceImpl regCodeRedisService;

    @Resource
    private FamilyUserRepository familyUserRepository;

    @Resource
    private FamilyRelaRepository familyRelaRepository;

    @Resource
    private RedisService redisService;

    public boolean reg(FamilyUserEntity user, String regCode) {

        if (null != this.findByPhone(user.getPhone())) {
            return false;
        }
        if (!regCodeRedisService.exists(user.getPhone())) {
            return false;
        }

        String currentRegCode = regCodeRedisService.get(user.getPhone());
        if (currentRegCode.equals(regCode)) {
            return this.directSaveOne(user);
        } else {
            return false;
        }
    }

    public boolean sendRegCode(String phone) {

        String regCode;
        if (regCodeRedisService.exists(phone)) {
            regCode = regCodeRedisService.get(phone);
        } else {
            int d = (int) (Math.random() * 9000 + 1000);
            regCode = "" + d + "";
        }
        regCodeRedisService.set(phone, regCode, 300000);
        YunpianClient client = new YunpianClient(YunPianApi).init();
        Map<String, String> param = client.newParam(2);
        param.put(MOBILE, phone);
        param.put(TEXT, "【爱聊天亲子】您的验证码是" + regCode);
        Result<SmsSingleSend> r = client.sms().single_send(param);
        System.out.println(r);
        if (r.getCode() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public FamilyUserEntity findByPhone(String phone) {
        return familyUserRepository.findByPhone(phone);
    }

    public FamilyUserEntity findById(String id) {
        return familyUserRepository.findOne(id);
    }

    public FamilyUserEntity login(FamilyUserEntity familyUserEntity) {
        FamilyUserEntity u = this.findByPhone(familyUserEntity.getPhone());
        if (null != u) {
            if (PasswordUtil.isEqual(familyUserEntity.getPass(), u.getPass())) {
                return u;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Transactional
    public boolean directSaveOne(FamilyUserEntity familyUserEntity) {
        if (null != this.findByPhone(familyUserEntity.getPhone())) {
            return false;
        }
        try {
            familyUserEntity.setPass(PasswordUtil.generatePass(familyUserEntity.getPass()));
            FamilyUserEntity dbu = familyUserRepository.save(familyUserEntity);

            FamilyRelaEntity familyRelaEntity = new FamilyRelaEntity();
            Set<String> mems = new HashSet<String>();
            mems.add(dbu.getId());
            familyRelaEntity.setMems(mems);
            FamilyRelaEntity dbfr = familyRelaRepository.save(familyRelaEntity);

            dbu.setFamilyId(dbfr.getId());
            familyUserRepository.save(dbu);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public FamilyUserEntity directSaveNoFamily(FamilyUserEntity familyUserEntity) {
        if (null != this.findByPhone(familyUserEntity.getPhone())) {
            return null;
        }
        familyUserEntity.setPass(PasswordUtil.generatePass(familyUserEntity.getPass()));
        FamilyUserEntity dbu = familyUserRepository.save(familyUserEntity);
        return dbu;
    }

    public boolean delOne(String id) {
        try {
            familyUserRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean keepOnline(String uid) {
        FamilyUserEntity userEntity = null;
        if(redisService.exists(uid)){
            userEntity = toEntity(redisService.get(uid));
        }else {
            userEntity = familyUserRepository.findOne(uid);
        }
        return this.saveUserToRedis(userEntity);
    }

    private boolean saveUserToRedis(FamilyUserEntity u){
        try {
            return redisService.set(u.getId(),toJson(u),300);
        } catch (IOException e) {
            redisService.delete(u.getId());
            e.printStackTrace();
            return false;
        }
    }


    private String toJson(Object object) throws IOException {
        return new ObjectMapper().writeValueAsString(object);
    }

    private FamilyUserEntity toEntity(String jsonStr){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonStr,FamilyUserEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
