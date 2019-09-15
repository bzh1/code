package com.atguigu.atcrowdfunding.user.service;

import com.atguigu.front.vo.req.MemberRegisterVo;
import com.atguigu.front.bean.TMember;
import com.atguigu.front.exception.UserEmailException;
import com.atguigu.front.exception.UserLoginacctException;

public interface MemberService {


    void regist(MemberRegisterVo memberRegisterVo) throws UserEmailException, UserLoginacctException;

    TMember login(String loginacct, String password);

    TMember getMemberInfo(String accessToken);

}
