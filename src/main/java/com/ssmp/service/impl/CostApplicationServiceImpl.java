package com.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.CostApplicationDao;
import com.ssmp.pojo.CostApplication;
import com.ssmp.service.ICostApplicationService;
import org.springframework.stereotype.Service;

@Service
public class CostApplicationServiceImpl extends ServiceImpl<CostApplicationDao, CostApplication> implements ICostApplicationService {
}
